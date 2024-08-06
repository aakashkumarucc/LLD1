package producerConsumerSemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Object> queue;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;
    public Producer (Queue<Object> queue,Semaphore producerSemaphore,Semaphore consumerSemaphore) {
        this.queue = queue;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }
    @Override
    public void run() {
        while(true){
            try{
             producerSemaphore.acquire();
                System.out.println(queue.size()+ " hence adding by "+Thread.currentThread().getName());
                queue.add(new Object());
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            consumerSemaphore.release();
        }
    }
}
