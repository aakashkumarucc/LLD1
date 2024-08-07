package DeadLockUsingTwoSynchronizedBlocks;

public class Runnable2 implements Runnable{
    private Object lock1;
    private Object lock2;
    public Runnable2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " attempting to lock lock2");
        synchronized (lock2) {
            System.out.println(threadName + " locked Lock2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(threadName + " attempting to lock lock1");
            synchronized (lock1) {
                System.out.println(threadName + " locked Lock1");
                //work

            }
            System.out.println(threadName + " unlocking Lock1");
        }
    }
}
