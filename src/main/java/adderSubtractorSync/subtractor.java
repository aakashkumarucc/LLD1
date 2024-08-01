package adderSubtractorSync;



public class subtractor implements Runnable {
    private Count count;
    public subtractor(Count count) {
        this.count=count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000000; i++) {
            synchronized (count) {
                count.value -=1;
            }

        }
    }
}