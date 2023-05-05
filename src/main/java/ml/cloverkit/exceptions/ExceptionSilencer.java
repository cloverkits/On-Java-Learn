package ml.cloverkit.exceptions;

public class ExceptionSilencer {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } finally {
            // 在 finally 块中使用 return
            // 会把任何被抛出的异常都压制下来
            return;
        }
    }
}
