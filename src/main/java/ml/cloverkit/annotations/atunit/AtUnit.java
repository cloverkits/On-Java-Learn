package ml.cloverkit.annotations.atunit;

import ml.cloverkit.ProcessFiles;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AtUnit implements ProcessFiles.Strategy {
    static Class<?> testClass;
    static List<String> failedTests = new ArrayList<>();
    static long testsRun = 0;
    static long failures = 0;

    public static void main(String[] args) throws Exception {
        // 启用断言
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
        new ProcessFiles(new AtUnit(), "class").start(args);
        if (failures == 0)
            System.out.println("OK (" + testsRun + " tests");
        else {
            System.out.println("(" + testsRun + " tests)");
            System.out.println(
                    "\n>>> " + failures + " FAILURE" +
                            (failures > 1 ? "S" : "") + " <<<"
            );
            for (String failed : failedTests)
                System.out.println("  " + failed);
        }
    }

    @Override
    public void process(File cFile) {
        try {
            String cName = ClassNameFinder.thisClass(Files.readAllBytes(cFile.toPath()));
            if (!cName.startsWith("public:"))
                return;
            cName = cName.split(":")[1];
            if (!cName.contains("."))
                return; // 忽略未包装的类
            testClass = Class.forName(cName);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
        TestMethods testMethods = new TestMethods();
        Method creator = null;
        Method cleanup = null;
        for (Method m : testClass.getDeclaredMethods()) {
            testMethods.addIfTestMethod(m);
            if (creator == null)
                creator = checkForCreatorMethod(m);
            if (cleanup == null)
                cleanup = checkForCleanupMethod(m);
        }
        if (testMethods.size() > 0) {
            if (creator == null)
                try {
                    if (!Modifier.isPublic(testClass.getDeclaredConstructor().getModifiers())) {
                        System.out.println("Error: " + testClass + " zero-argument constructor must be public");
                        System.exit(1);
                    }
                } catch (NoSuchMethodException e) {
                    // 同步的无参构造器，没有问题
                }
            System.out.println(testClass.getName());
        }
        for (Method m : testMethods) {
            System.out.print("  . " + m.getName() + " ");
            try {
                Object testObject = createTestObject(creator);
                boolean success = false;
                try {
                    if (m.getReturnType().equals(boolean.class))
                        success = (Boolean) m.invoke(testObject);
                    else {
                        m.invoke(testObject);
                        success = true; // 如果没有断言失败
                    }
                } catch (InaccessibleObjectException e) {
                    // 实际的一场在 e 中
                    System.out.println(e.getCause());
                }
                System.out.println(success ? "" : "(failed)");
                testsRun++;
                if (!success) {
                    failures++;
                    failedTests.add(testClass.getName() + ": " + m.getName());
                }
                if (cleanup != null)
                    cleanup.invoke(testObject, testObject);
            } catch (IllegalAccessException |
                     IllegalArgumentException |
                     InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class TestMethods extends ArrayList<Method> {
        void addIfTestMethod(Method m) {
            if (m.getAnnotation(Test.class) == null)
                return;
            if (!(m.getReturnType().equals(boolean.class) ||
                    m.getReturnType().equals(void.class)))
                throw new RuntimeException("@Test method" + " must return boolean or void");
            m.setAccessible(true);  // 如何是 private 的，等等
        }
    }

    private static Method checkForCreatorMethod(Method m) {
        if (m.getAnnotation(TestObjectCreate.class) == null)
            return null;
        if (!m.getReturnType().equals(testClass))
            throw new RuntimeException("@TestObjectCreate " + "must return instance of Class to be tested");
        if ((m.getModifiers() & Modifier.STATIC) < 1)
            throw new RuntimeException("@TestObjectCreate " + "must be static.");
        m.setAccessible(true);
        return m;
    }

    private static Method checkForCleanupMethod(Method m) {
        if (m.getAnnotation(TestObjectCleanup.class) == null)
            return null;
        if (!m.getReturnType().equals(void.class))
            throw new RuntimeException("@TestObjectCleanup " + "must return void");
        if ((m.getModifiers() & Modifier.STATIC) < 1)
            throw new RuntimeException("@TestObjectCleanup must be static.");
        if (m.getParameterTypes().length == 0 ||
                m.getParameterTypes()[0] != testClass)
            throw new RuntimeException("@TestObjectCleanup " + "must take an argument of the tested type.");
        m.setAccessible(true);
        return m;
    }

    private static Object createTestObject(Method createor) {
        if (createor != null) {
            try {
                return createor.invoke(testClass);
            } catch (IllegalAccessException |
                     IllegalArgumentException |
                     InvocationTargetException e) {
                throw new RuntimeException("Couldn't run " + "@TestObject (creator) method.");
            }
        } else { // 使用无参数的构造器
            try {
                return testClass.getConstructor().newInstance();
            } catch (InstantiationException |
                     NoSuchMethodException |
                     InvocationTargetException |
                     IllegalAccessException e) {
                throw new RuntimeException("Couldn't create a test object. " + "Try using a @TestObject method.");
            }
        }
    }
}
