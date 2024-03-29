package ml.cloverkit.concurrent;

import ml.cloverkit.Nap;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class QuittingTasks {
    public static final int COUNT = 150;

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        List<QuittableTask> tasks =
                IntStream.range(1, COUNT)
                        .mapToObj(QuittableTask::new)
                        .peek(es::execute)
                        .toList();
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        es.shutdown();
    }
}
