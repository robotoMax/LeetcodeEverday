import java.util.concurrent.Semaphore;

/**
 * Date: 06/06/2018
 * Created By: Shuai Liu
 */
public class MultiThread1 {
    private static final int NUM_THREADS = 8;
    private static final Semaphore SEMAPHORE = new Semaphore(NUM_THREADS);

    public static void readFile() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(new Runnable(){
            
                @Override
                public void run() {
                    try {
                        SEMAPHORE.acquire();
                        readFile();
                        System.out.println("finish" + Thread.currentThread().getId());
                    } catch (InterruptedException e) {
                        //
                    } finally {
                        SEMAPHORE.release();
                    }
                }
            });
            thread.start();
        }
        while (!SEMAPHORE.tryAcquire(NUM_THREADS));
        long end = System.currentTimeMillis();
        System.out.print(end - start);
    }

}
