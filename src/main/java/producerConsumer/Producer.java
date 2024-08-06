package producerConsumer;

import java.util.Queue;

public class Producer implements Runnable {

    private Queue<Object> queue;
    private int maxSize;
    public Producer(Queue<Object> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue) {
                if(queue.size() <maxSize){
                    System.out.println(queue.size()+ " hence adding by "+Thread.currentThread().getName());
                    queue.add(new Object());
                }
            }
        }
    }
}
