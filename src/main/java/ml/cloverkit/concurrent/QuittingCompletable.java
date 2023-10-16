package ml.cloverkit.concurrent;

import ml.cloverkit.Nap;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class QuittingCompletable {
    public static void main(String[] args) {
        List<QuittableTask> tasks = IntStream.range(1, QuittingTasks.COUNT)
                .mapToObj(QuittableTask::new)
                .toList();
        List<CompletableFuture<Void>> cfutures = tasks.stream()
                .map(CompletableFuture::runAsync)
                .toList();
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        cfutures.forEach(CompletableFuture::join);
    }
}
