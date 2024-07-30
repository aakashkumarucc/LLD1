package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) {
        //Use an ExecutorService to submit the Callable task and retrieve the result.
        //Cant use thread

        // Create an ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Create a Callable instance
        Callable<Integer> callableTask = new MyCallable();

        // Submit the Callable task to the ExecutorService
        Future<Integer> future = executor.submit(callableTask);


        try {
            // Retrieve the result of the Callable task
            Integer result = future.get(); // This call blocks until the result is available
            System.out.println("Result from Callable: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the ExecutorService
            executor.shutdown();
        }
    }
}
