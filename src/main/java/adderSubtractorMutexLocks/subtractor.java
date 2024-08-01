package adderSubtractorMutexLocks;


import java.util.concurrent.locks.Lock;

public class subtractor implements Runnable {
    private Lock lock;
    private Count count;
    public subtractor(Count count, Lock lock) {
        this.count=count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000000; i++) {
            lock.lock();
            try{
                count.value -=1;
            }finally {
                lock.unlock();
            }
            //Note : unlock statement is always called in finally block to ensure that the lock is released even if an exception is thrown in the method body(try block)

        }
    }
}