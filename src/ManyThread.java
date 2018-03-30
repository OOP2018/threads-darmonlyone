import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ManyThread {
    public static void main(String[] args) {
        final int LIMIT = 1000000;
        Counter[] counterArrays = {new Counter(), new CounterWithLock(), new SynchronousCounter(), new AtomicCounter()};
        for (Counter counter: counterArrays)
        runThreads(5, counter, LIMIT );
    }

    public static void runThreads( int nThread, Counter counter, final int limit ){
      ExecutorService executorService = Executors.newFixedThreadPool(2 * nThread);

        System.out.println("Starting tasks");
        long startTime = System.nanoTime();

        for (int i = 0 ; i < nThread ; i++) {
            Runnable asstask = () -> {
                for (int k = 1; k <= limit; k++) counter.add(k);

            };
            Runnable subtask = () -> {
                for (int k = 1; k <= limit; k++) counter.add(-k);
            };
            executorService.submit(asstask);
            executorService.submit(subtask);
        }
        executorService.shutdown();
        // wait for threads to finish
        try {
            executorService.awaitTermination(1,TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("all down");
        double elapsed = 1.0E-9*( System.nanoTime() - startTime );
        System.out.printf("Count 1 to %,d in %.6f sec\n", limit, elapsed);
        // the sum should be 0. Is it?
        System.out.printf("Counter total is %d\n", counter.get() );
    }
}
