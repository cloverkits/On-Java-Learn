package ml.cloverkit.exceptions;

// 需要释放的对象后面必须跟一个 try-finally 块

// 构造不会失败
class NeedsCleanup {
    private static long counter = -1;
    private final long id = counter++;

    public void dispose() {
        System.out.println("NeedsCleanup " + id + " disposed");
    }
}

class ConstructionException extends Exception {}

class NeedsCleanup2 extends NeedsCleanup {
    // 构造可能失败
    NeedsCleanup2() throws ConstructionException {}
}

public class CleanupIdiom {
    public static void main(String[] args) {
        // [1]:
        NeedsCleanup nc1 = new NeedsCleanup();
        try {
            // ...
            ;
        } finally {
            nc1.dispose();
        }

        // [2]:
        // 如果构造不会失败，我们可以将对象组织到一起
        NeedsCleanup nc2 = new NeedsCleanup();
        NeedsCleanup nc3 = new NeedsCleanup();
        try {
            // ...
            ;
        } finally {
            // 以构造相反到顺序释放
            nc3.dispose();
            nc2.dispose();
        }

        // [3]:
        // 如果构造可能失败，我们必须确保每个对象的清理
        try {
            NeedsCleanup2 nc4 = new NeedsCleanup2();
            try {
                NeedsCleanup2 nc5 = new NeedsCleanup2();
                try {
                    // ...
                    ;
                } finally {
                    nc5.dispose();
                }
            } catch (ConstructionException e) {
                // nc5 的构造
                System.out.println(e);
            } finally {
                nc4.dispose();
            }
        }  catch (ConstructionException e) {
            // nc4 的构造
            System.out.println(e);
        }
    }
}
