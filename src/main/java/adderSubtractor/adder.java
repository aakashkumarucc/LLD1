package adderSubtractor;

import org.w3c.dom.css.Counter;

public class adder implements Runnable {

    private Count count;
    public adder(Count count) {
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 1000000; i++) {
            count.value  +=1;
        }
    }
}
