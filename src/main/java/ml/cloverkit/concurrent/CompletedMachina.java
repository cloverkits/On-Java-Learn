package ml.cloverkit.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletedMachina {
    public static void main(String[] args) {
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));

        try {
            Machina m = cf.get();  // 不会阻塞
        } catch (InterruptedException |
                ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
