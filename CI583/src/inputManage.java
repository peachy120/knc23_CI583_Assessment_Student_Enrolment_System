import java.util.ArrayList;
import java.util.List;

public class inputManage {

    static List<input> waitingQueue = new ArrayList<>();

    // Constructor
    public inputManage() {

    }

//    // Getter
//    public static List<String[]> getWaitingQueue() {
//        return waitingQueue;
//    }
//
//    // Setter
//    public static void setWaitingQueue(List<String[]> waitingQueue) {
//        inputManage.waitingQueue = waitingQueue;
//    }

    public static void addToWaitingQueue(input value) {
        waitingQueue.add(value);
    }
}
