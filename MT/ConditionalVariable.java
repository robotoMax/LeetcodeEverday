import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

/**
 * Date: 06/08/2018
 * Created By: Shuai Liu
 */
public class ConditionalVariable {
    private static final long SLEEP_INTERVAL = 3000;
    private boolean running = true;

    public void start() {
        Thread thread = new Thread(new Runnable(){
        
            @Override
            public void run() {
                System.out.println("Hello world!");
                try {
                    Thread.sleep(SLEEP_INTERVAL);
                }
                catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                synchronized(ConditionalVariable.this) {
                    running = false;
                    ConditionalVariable.this.notify();
                }
            }
        });
        thread.start();
    }

    public void join() throws InterruptedException {
    /**
     * Thread acquires the intrinsic lock when it enters a synchronized method. Thread inside the synchronized method is set as the 
     * owner of the lock and is in RUNNABLE state. Any thread that attempts to enter the locked method becomes BLOCKED.
     * 
     * When thread calls wait it releases the current object lock (it keeps all locks from other objects) and than goes to WAITING state.
     * 
     * When some other thread calls notify or notifyAll on that same object the first thread changes state from WAITING to BLOCKED, 
     * Notified thread does NOT automatically reacquire the lock or become RUNNABLE, in fact it must fight for the lock with all other 
     * blocked threads.
     * 
     * WAITING and BLOCKED states both prevent thread from running, but they are very different.
     * 
     * WAITING threads must be explicitly transformed to BLOCKED threads by a notify from some other thread.
     * 
     * WAITING never goes directly to RUNNABLE.
     * 
     * When RUNNABLE thread releases the lock (by leaving monitor or by waiting) one of BLOCKED threads automatically takes its place.
     */
        synchronized(this) {
            while (running) {
                System.out.println("waiting another thread to finish.");
                wait();
            }
            System.out.println("program finishes.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionalVariable c = new ConditionalVariable();
        c.start();
        c.join();
    }

}