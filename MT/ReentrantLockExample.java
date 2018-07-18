import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: 06/08/2018
 * Created By: Shuai Liu
 */
public class ReentrantLockExample {
    public static final long SLEEP_INTERVAL = 5000;
    private final Lock lock = new ReentrantLock();

    public void foo() {
        try {
            lock.lock();
            System.out.println("Inside foo!");
            try {
                Thread.sleep(SLEEP_INTERVAL);
            }
            catch(InterruptedException ie) {
                //
            }
        }
        finally {
            lock.unlock();
        }
    }

    public void bar() {
        try {
            lock.lock();
            System.out.println("Inside bar!");
        }
        finally {
            lock.unlock();
        }
    }

    public void foobar() {
        System.out.println("Inside foobar!");
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample  r = new ReentrantLockExample();
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                r.foo();
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                r.bar();
            }
        });
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run() {
                r.foobar();
            }
        });
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }

}