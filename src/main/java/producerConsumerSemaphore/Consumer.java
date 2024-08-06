package producerConsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private Queue<Object> queue;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    public Consumer(Queue<Object> queue,Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.queue = queue;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }
    @Override
    public void run() {
        while(true){
            try {
                consumerSemaphore.acquire();
                System.out.println(queue.size()+ " hence removing by "+Thread.currentThread().getName());
                queue.remove();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            producerSemaphore.release();
        }
    }
}
