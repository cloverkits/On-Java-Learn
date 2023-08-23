package ml.cloverkit.annotations.atunit;

import ml.cloverkit.ProcessFiles;

import java.io.File;
import java.io.IOException;
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

    }
}
