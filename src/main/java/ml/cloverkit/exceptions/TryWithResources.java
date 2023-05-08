package ml.cloverkit.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResources {
    public static void main(String[] args) {
        try (InputStream in = new FileInputStream(new File("TryWithResources.java"))) {
            int contents = in.read();
            // 处理内容
        } catch (IOException e) {
            // 处理错误
        }
    }
}
