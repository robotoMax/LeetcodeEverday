/**
 * Date: 06/06/2018
 * Created By: Shuai Liu
 */
public class SynchronizedMethodExample {
    public synchronized void foo() {
        System.out.println("inside foo! ");
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            System.out.println("error");
        }
    }
    public synchronized void bar() {
        System.out.println("inside bar! ");
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            System.out.println("error");
        }
    }
    public void foobar() {
        System.out.println("inside foobar! ");
    }
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        SynchronizedMethodExample s = new SynchronizedMethodExample();
        Thread t1 = new Thread(() -> s.foo());
        Thread t2 = new Thread(() -> s.bar());
        Thread t3 = new Thread(() -> s.foobar());

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}