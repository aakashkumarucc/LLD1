package adderSubtractor;

public class client {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        adder addr = new adder(count);
        subtractor sub = new subtractor(count);
        Thread t1 = new Thread(addr);
        Thread t2 = new Thread(sub);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count.value);
    }
}
