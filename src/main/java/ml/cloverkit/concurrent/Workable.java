package ml.cloverkit.concurrent;

import ml.cloverkit.Nap;

import java.util.concurrent.CompletableFuture;

public class Workable {
    String id;
    final double duration;

    public Workable(String id, double duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable[" + id + "]";
    }

    public static Workable work(Workable tt) {
        new Nap(tt.duration);   // 秒
        tt.id = tt.id + "W";
        return tt;
    }

    public static CompletableFuture<Workable> make(String id, double duration) {
        return CompletableFuture.completedFuture(new Workable(id, duration))
                .thenApplyAsync(Workable::work);
    }
}
