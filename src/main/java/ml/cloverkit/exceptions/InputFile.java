package ml.cloverkit.exceptions;

// 注意构造器中的异常

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputFile {
    private BufferedReader in;

    public InputFile(String fileName) throws Exception {
        try {
            in = new BufferedReader(new FileReader(fileName));
            // 其他可能过抛出异常的代码
        } catch (FileNotFoundException e) {
            System.out.println("Cloud not open " + fileName);
            // 没有打开是，所以不用关闭
            throw e;
        } catch (Exception e) {
            // 对于其他所有异常，都必须关闭文件
            try {
                in.close();
            } catch (IOException e2) {
                System.out.println("in.close() unsuccessful");
            }
            // 重新抛出
            throw e;
        } finally {
            // 不要在这里关闭 !!!
        }
    }

    public String getLine() {
        String s;
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readline() failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("dispose() successful");
        } catch (IOException e2) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
