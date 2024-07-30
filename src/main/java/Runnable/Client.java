package Runnable;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        /*
        The main thread is created automatically when our program is started.
        It is the thread from which other “child” threads will be spawned.
        Often, it must be the last thread to finish execution because it performs various shutdown actions
         */

        System.out.println("We are here " + Thread.currentThread().getName());


//        NumberPrinter np = new NumberPrinter(4);
//        Thread t = new Thread(np);
//        t.start();
        //t.start()==> a thread i.e. in new state gets transferred to active state when it invokes start() method(Note: Active state has two states: Runnable and Running)
//        for (int i = 0; i < 1000; i++) {
//            NumberPrinter num = new NumberPrinter(i);
//            Thread t = new Thread(num);
//            t.start();
//        }


        /*
        Understanding Executors
        Java executor framework (java.util.concurrent.Executor), released with the JDK 5 is used to run the Runnable objects without creating new threads every time and mostly re-using the already created threads.
        provide FACTORY methods that are being used to create ThreadPools of worker threads. Thread pools overcome this issue by keeping the threads alive and reusing the threads. Any excess tasks flowing in, that the threads in the pool can’t handle are held in a Queue. Once any of the threads get free, they pick up the next task from this queue. This task queue is essentially unbounded for the out-of-box executors provided by the JDK.

        1. SingleThreadExecutor
        2. FixedThreadPool(n)+
        3. CachedThreadPool
        4. ScheduledExecutor
         */
        Executor executor = Executors.newFixedThreadPool(10);//ab hmlog ko  thread banane ka jarurat nahi hai....jo ki hona v nahi chahiye
        //Executor executor = Executors.newCachedThreadPool();

        for(int i = 0;i <= 100; ++ i) {
            if (i==5 || i==10 || i==15) {
                System.out.println("Stop here");
            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executor.execute(numberPrinter);
        }

        System.out.println("Name of the thread running " + Thread.currentThread().getName());
    }
}
