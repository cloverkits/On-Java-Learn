package ml.cloverkit.exceptions;

// 异常可能丢失的情况
class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception1";
    }
}

class HoHomException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHomException {
        throw new HoHomException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                lm.dispose();
            }
        } catch (VeryImportantException | HoHomException e) {
            System.out.println(e);
        }
    }
}
