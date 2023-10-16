package ml.cloverkit.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableUtilities {
    // 获取并展示 CF 中存储的值
    public static void showr(CompletableFuture<?> c) {
        try {
            System.out.println(c.get());
        } catch (InterruptedException |
                ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    // 针对无值的 CF 操作:
    public static void voidr(CompletableFuture<Void> c) {
        try {
            c.get(); // 返回 Void
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
