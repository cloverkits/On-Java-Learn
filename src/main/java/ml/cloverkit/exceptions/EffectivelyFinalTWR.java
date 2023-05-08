package ml.cloverkit.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EffectivelyFinalTWR {
    static void old() {
        try (InputStream r1 = new FileInputStream(new File("src/main/java/ml/cloverkit/exceptions/TryWithResources.java"));
             InputStream r2 = new FileInputStream(new File("src/main/java/ml/cloverkit/exceptions/EffectivelyFinalTWR.java"))
        ) {
            r1.read();
            r2.read();
        } catch (IOException e) {
            // 处理异常
        }
    }

    static void jdk9() throws IOException {
        final InputStream r1 = new FileInputStream(new File("src/main/java/ml/cloverkit/exceptions/TryWithResources.java"));
        final InputStream r2 = new FileInputStream(new File("src/main/java/ml/cloverkit/exceptions/EffectivelyFinalTWR.java"));
        try (r1; r2) {
            r1.read();
            r2.read();
        }
        // r1 和 r2 仍然在作用域中
        // 访问其中的任意一个都会抛出异常
        r1.read();
        r2.read();
    }

    public static void main(String[] args) {
        old();
        try {
            jdk9();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
