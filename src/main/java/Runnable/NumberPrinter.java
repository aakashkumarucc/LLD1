package Runnable;

public class NumberPrinter implements Runnable{

    public int currentNumber;

    public NumberPrinter(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    @Override
    public void run() {
        System.out.println("We are printing "+this.currentNumber+"the thread executing this function is "+Thread.currentThread().getName());
    }
}
