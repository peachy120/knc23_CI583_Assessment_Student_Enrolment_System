import java.util.ArrayList;
import java.util.List;

public abstract class inputManage{

    private static List<input> waitingQueue = new ArrayList<>();

    // Constructor
    public inputManage(int max) {
        waitingQueue = new ArrayList<>(max);
    }

    // Getter
    // Getting the waitingQueue
    public static List<input> getWaitingQueue() {
        return waitingQueue;
    }

    // Adding value into the waitingQueueso the queue can be pass as parameters in other classes
    public static void addToWaitingQueue(input value) {
        waitingQueue.add(value);
        //System.out.println(value);
    }


}