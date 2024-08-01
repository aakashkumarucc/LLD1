package adderSubtractorMutexLocks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Lock lock = new ReentrantLock();
        adder addr = new adder(count,lock);
        subtractor sub = new subtractor(count,lock);
        Thread t1 = new Thread(addr);
        Thread t2 = new Thread(sub);
        t1.start();
        t2.start();


        System.out.println(count.value);
    }
}