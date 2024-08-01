package adderSubtractorMutexLocks;

import java.util.concurrent.locks.Lock;

public class adder implements Runnable {

    private Count count;
    private Lock lock;

    public adder(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }
    @Override
    public void run() {
        lock.lock();
        for (int i = 1; i <= 1000000; i++) {
            count.value  +=1;
        }
        lock.unlock();
    }
}
