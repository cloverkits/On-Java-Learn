// 基于 javac 的注解处理
package ml.cloverkit.annotations.ifx;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Elements;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SupportedAnnotationTypes("ml.cloverkit.annotations.ifx.ExtractInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class IfaceExtractorProcessor extends AbstractProcessor {
    private final ArrayList<Element> interfaceMethods = new ArrayList<>();
    Elements elementUtils;
    private ProcessingEnvironment processingEnv;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        this.processingEnv = processingEnv;
        elementUtils = processingEnv.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element elem : roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {
            String interfaceName = elem.getAnnotation(ExtractInterface.class).interfaceName();
            for (Element enclosed : elem.getEnclosedElements()) {
                if (enclosed.getKind().equals(ElementKind.METHOD)
                        && enclosed.getModifiers().contains(Modifier.PUBLIC)
                        && !enclosed.getModifiers().contains(Modifier.STATIC)) {
                    interfaceMethods.add(enclosed);
                }
            }
            if (!interfaceMethods.isEmpty())
                writeInterfaceFile(interfaceName);
        }
        return false;
    }

    private void writeInterfaceFile(String interfaceName) {
        try (Writer writer = processingEnv.getFiler().createSourceFile(interfaceName).openWriter()) {
            String packageName = elementUtils.getPackageOf(interfaceMethods.get(0)).toString();
            if (packageName.equalsIgnoreCase("unnamed")) {
                writer.write("package " + packageName + ";\n");
            }
            writer.write("public interface " + interfaceName + " {\n");
            for (Element elem : interfaceMethods) {
                ExecutableElement method = (ExecutableElement) elem;
                String singature = "    public ";
                singature += method.getReturnType() + " ";
                singature += method.getSimpleName();
                singature += createArgList(method.getParameters());
                System.out.println(singature);
                writer.write(singature + ";\n");
            }
            writer.write("}");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String createArgList(List<? extends VariableElement> parameters) {
        String args = parameters.stream()
                .map(p -> p.asType() + " " + p.getSimpleName())
                .collect(Collectors.joining(", "));
        return "(" + args + ")";
    }
}