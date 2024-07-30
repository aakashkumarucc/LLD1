package Runnable;

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
        for (int i = 0; i < 1000; i++) {
            NumberPrinter num = new NumberPrinter(i);
            Thread t = new Thread(num);
            t.start();
        }


        System.out.println("Name of the thread running " + Thread.currentThread().getName());
    }
}
