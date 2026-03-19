import java.util.ArrayList;
import java.util.List;

public abstract class inputManage extends Thread{

    private static List<input> waitingQueue = new ArrayList<>();
    private static int noOfElements;

    // Constructor
    public inputManage(int max) {
        waitingQueue = new ArrayList<>(max);
        noOfElements = 0;
    }

    // Getter
    public static List<input> getWaitingQueue() {
        return waitingQueue;
    }

    public static int getNoOfElements() {
        return noOfElements;
    }

    // Setter
    public static void setWaitingQueue(List<input> waitingQueue) {
        inputManage.waitingQueue = waitingQueue;
    }

    public void setNoOfElements(int noOfElements) {
        this.noOfElements = noOfElements;
    }

    public static void addToWaitingQueue(input value) {
        waitingQueue.add(value);
        //System.out.println(value);
        noOfElements++;
        //System.out.println(noOfElements);
    }
}