package DeadLockPreventionUsingTimeOutBackOff;

import DeadLockUsingTwoLock.Runnable2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Runnable2TimeOut implements Runnable{

    private Lock lock1;
    private Lock lock2;
    public Runnable2TimeOut(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        while (true){
            int failureCount = 0;
            while(!tryLockBothLocks()){
                failureCount++;
                System.err.println(threadName+ " failed to lock both locks. Waiting a bit before retrying [" + failureCount + " tries]");
                sleep((long)(100L*(Math.random())));
            }
            if(failureCount > 0){
                System.out.println(threadName + " succeeded in locking both locks - after "+failureCount+" failures");
            }


            lock2.unlock();
            lock1.unlock();
        }

    }

    private void sleep(long timeMillis){
        try {
            Thread.sleep(timeMillis);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    private boolean tryLockBothLocks(){
        String threadName = Thread.currentThread().getName();


        try {
            boolean lock2Success = lock2.tryLock(1000, TimeUnit.MILLISECONDS);
            if(!lock2Success){
                return false;
            }
        }catch (InterruptedException e){
            System.out.println(threadName + " interrupted trying to lock Lock 2");
            return false;
        }

        try {
            boolean lock1Success = lock1.tryLock(1000,TimeUnit.MILLISECONDS);
            if(!lock1Success){
                //backing off
                lock2.unlock();
                return false;
            }
        } catch (InterruptedException e) {
            System.out.println(threadName + " interrupted trying to lock Lock 1");
            //backing off
            lock2.unlock();
            return false;
        }
        return true;
    }
}
