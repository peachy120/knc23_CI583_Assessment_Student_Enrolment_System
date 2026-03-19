import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class roundRobin{

    static int quantum = 1000;

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in Round Robin is called");

        for (int i = 0; i < queue.size(); i++) {
            input value = queue.get(i);

            int burstTime = value.getBurstTime();

            System.out.println(value);
            System.out.println(burstTime);

            int afterProcessBurstTime = burstTime - quantum;

            if (afterProcessBurstTime > 0) {
                value.setBurstTime(afterProcessBurstTime);
                enqueue(value);
            } else {
                dequeue(value);
            }
        }

    }

    public static void enqueue(input value) {
        inputManage.addToWaitingQueue(value);
    }

    public static void dequeue(input value) {
        model.addToCompletedQueue(value);
        System.out.println(value.getProcessID() + " is terminated");
    }
}
