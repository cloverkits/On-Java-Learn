package ml.cloverkit.exceptions;

// “关闭" 检测型异常

import java.io.FileNotFoundException;
import java.io.IOException;

class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0 -> throw new FileNotFoundException();
                case 1 -> throw new IOException();
                case 2 -> throw new RuntimeException("Where am I?");
                default -> {
                    return;
                }
            }
        } catch (IOException | RuntimeException e) {
            // 改变为非检测型异常
            throw new RuntimeException(e);
        }
    }
}

class SomeOtherException extends Exception {}

public class TurnOffChecking {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        // 我们可以不使用 try 块，直接调用 throwRuntimeException(),
        // 让 RuntimeException 离开这个方法:
        wce.throwRuntimeException(3);
        // 或者选择捕获异常
        for (int i = 0; i < 4; i++) {
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new SomeOtherException();
            } catch (SomeOtherException e) {
                System.out.println("SomeOtherException: " + e);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException: " + e);
                } catch (IOException e) {
                    System.out.println("IOException: " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            }
        }
    }
}
