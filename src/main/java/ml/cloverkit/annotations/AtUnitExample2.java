package ml.cloverkit.annotations;

import onjava.atunit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class AtUnitExample2 {
    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("this is methodTwo");
        return 2;
    }

    @Test
    void assertExample() {
        assert methodOne().equals("This is methodOne");
    }

    @Test
    void assertFailureExample() {
        assert 1 == 2: "What a surprise!";
    }

    @Test
    void exceptionExample() throws IOException {
        try (FileInputStream fis = new FileInputStream("nofile.txt")) {}    // 抛出
    }

    @Test
    boolean assertAndReturn() {
        // 附带消息的断言:
        assert methodTwo() == 2: "methodTwo must equal 2";
        return methodOne().equals("This is methodOne");
    }
}
