package DeadLockUsingTwoSynchronizedBlocks;

import DeadLockUsingTwoLock.Runnable1;
import DeadLockUsingTwoLock.Runnable2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        DeadLockUsingTwoLock.Runnable1 runnable1 = new Runnable1(lock1,lock2);
        DeadLockUsingTwoLock.Runnable2 runnable2 = new Runnable2(lock1,lock2);

        Thread thread1 = new Thread(runnable1,"thread1");
        Thread thread2 = new Thread(runnable2,"thread2");

        thread1.start();
        thread2.start();
    }
}
