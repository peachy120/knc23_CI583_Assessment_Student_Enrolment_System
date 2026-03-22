import java.util.ArrayList;
import java.util.List;

public class model{

    private static List<input> completedQueue = new ArrayList<>();

    public static List<input> getCompletedQueue() {
        return completedQueue;
    }

    public static void addToCompletedQueue(input value) {
        completedQueue.add(value);
    }

    public static void roundRobin(List<input> queue) {
        //System.out.println("Round Robin in model is called");
        roundRobin.startEnrolment(queue);
    }

    public static void priority(List<input> queue) {
        //System.out.println("Priority in model is called");

        priority.startEnrolment(queue);
    }

    public static void mlfq(List<input> queue) {
        //System.out.println("MLFQ in model is called");

        mlfq.startEnrolment(queue);
    }
}
