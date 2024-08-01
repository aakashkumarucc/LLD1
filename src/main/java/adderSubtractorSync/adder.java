package adderSubtractorSync;



public class adder implements Runnable {

    private Count count;
    public adder(Count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 1000000; i++) {
            synchronized (count) {
                count.value  +=1;
            }

        }
    }
}
