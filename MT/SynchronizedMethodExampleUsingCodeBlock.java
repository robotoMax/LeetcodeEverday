/**
 * Date: 06/06/2018
 * Created By: Shuai Liu
 */
public class SynchronizedMethodExampleUsingCodeBlock {
    private Object lock = new Object();
    private Object lock2 = new Object();
    /**
     * A thread that needs exclusive and consistent access to an object's fields has to acquire the object's 
     * intrinsic lock before accessing them, and then release the intrinsic lock when it's done with them.
     */
    public void foo() {
        //Unlike synchronized methods, synchronized statements must specify the object that provides the intrinsic lock.
        synchronized(lock) {
            System.out.println("inside foo! ");
            try {
                Thread.sleep(3000);
            } catch(InterruptedException ie) {
                System.out.println("error!");
            }
        }
    }
    public void bar() {
        // Outside the synchronized code block.  
        // System.out.println("outside synchronized code block in BAR!");
        synchronized(this) {
            System.out.println("inside bar! ");
            try {
                Thread.sleep(3000);
            } catch(InterruptedException ie) {
                System.out.println("error!");
            }
        }
    }
    public void foobar() {
        synchronized(lock2) {
            System.out.println("inside foobar! ");
            try {
                Thread.sleep(3000);
            } catch(InterruptedException ie) {
                System.out.println("error!");
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        SynchronizedMethodExampleUsingCodeBlock s = new SynchronizedMethodExampleUsingCodeBlock();
        Thread t1 = new Thread(() -> s.foo());
        Thread t2 = new Thread(() -> s.bar());
        Thread t3 = new Thread(() -> s.foobar());

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}