import java.util.ArrayList;
import java.util.List;

public class model{

    private static List<input> completedQueue = new ArrayList<>();

    // Getter
    // Getting the completedQueue
    public static List<input> getCompletedQueue() {
        return completedQueue;
    }

    // Adding values that have completed the process to completedQueue
    public static void addToCompletedQueue(input value) {
        completedQueue.add(value);
    }

    // Calling startEnrolment method from roundRobin and passing in the queue as parameter
    public static void roundRobin(List<input> queue) {
        //System.out.println("Round Robin in model is called");
        roundRobin.startEnrolment(queue); // Calling startEnrolment method from roundRobin and passing in the queue as parameter
    }

    // Calling startEnrolment method from priority and passing in the queue as parameter
    public static void priority(List<input> queue) {
        //System.out.println("Priority in model is called");

        priority.startEnrolment(queue); // Calling startEnrolment method from priority and passing in the queue as parameter
    }

    // Calling startEnrolment method from mlfq and passing in the queue as parameter
    public static void mlfq(List<input> queue) {
        //System.out.println("MLFQ in model is called");

        mlfq.startEnrolment(queue); // Calling startEnrolment method from mlfq and passing in the queue as parameter
    }
}
