package ml.cloverkit.housekeeping;

import javax.swing.plaf.TableHeaderUI;
import java.security.spec.NamedParameterSpec;

class Book {
    boolean checkedOut = false;

    public Book(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    void checkIn() {
        checkedOut = false;
    }

    @Override
    @SuppressWarnings("deprecation")
    protected void finalize() throws Throwable {
        if (checkedOut) {
            System.out.println("Error: checked out");
        }
        super.finalize();
    }
}
public class TerminationCondition {

    public static void main(String[] args) {
        Book novel = new Book(true);
        // 正确清理
        novel.checkIn();
        // 没有清理就丢掉了该对象的引用
        new Book(true);
        // 强制垃圾收集和终结操作
        System.gc();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
