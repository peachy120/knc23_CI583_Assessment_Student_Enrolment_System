import java.util.ArrayList;
import java.util.List;

public abstract class inputManage{

    private static List<input> waitingQueue = new ArrayList<>();

    // Constructor
    public inputManage(int max) {
        waitingQueue = new ArrayList<>(max);
    }

    // Getter
    public static List<input> getWaitingQueue() {
        return waitingQueue;
    }

    // Setter
    public static void setWaitingQueue(List<input> waitingQueue) {
        inputManage.waitingQueue = waitingQueue;
    }

    public static void addToWaitingQueue(input value) {
        waitingQueue.add(value);
        //System.out.println(value);
    }


}