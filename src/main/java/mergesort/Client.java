package mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> arrayToSort = List.of(10,2,8,11,4,3,9,1);
        ExecutorService es = Executors.newCachedThreadPool();
        Sorter sorter = new Sorter(es,arrayToSort);

        Future<List<Integer>> sortedListFuture  = es.submit(sorter);

        List<Integer> sortedList = sortedListFuture.get();

        for(Integer i : sortedList){
            System.out.println(i);
        }

        es.shutdown();

    }
}
