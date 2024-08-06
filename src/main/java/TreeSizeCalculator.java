import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    private Node root;
    private ExecutorService executorService;
    public TreeSizeCalculator(Node root,ExecutorService executorService){
        this.root = root;
        this.executorService = executorService;
    }
    public Integer call() throws Exception{
        if(root == null){
            return -1;
        }
        TreeSizeCalculator leftSize = new TreeSizeCalculator(root.left,executorService);
        TreeSizeCalculator rightSize = new TreeSizeCalculator(root.right,executorService);

        Future<Integer> leftSizeF = executorService.submit(leftSize);
        Future<Integer> rightSizeF = executorService.submit(rightSize);

        Integer l = leftSizeF.get();
        Integer r = rightSizeF.get();

        //tsc(root.left)
        //tsc(root.right)
        return Math.max(l,r)+1;
    }

}