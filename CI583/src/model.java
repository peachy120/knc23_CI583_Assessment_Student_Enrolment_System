import java.util.ArrayList;
import java.util.List;

public class model extends Thread{

    private static List<input> completedQueue = new ArrayList<>();

    public static void roundRobin(List<input> queue) {
        System.out.println("Round Robin in model is called");

        for (int i = 0; i < queue.size(); i++) {

            //System.out.println(Thread.currentThread().getName() + Thread.currentThread().getState() + " printing: " + i);

            //if (Thread.currentThread().getState().equals(State.NEW)) {
                try {
                    Thread.sleep(20); // Simulate work with a delay

                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }

                inputManage.addToWaitingQueue(queue.get(i));
                System.out.println(inputManage.waitingQueue);

            //} else if (Thread.currentThread().getState().equals(State.TERMINATED)) {
                //completedQueue.add(queue.get(i));
                //System.out.println(completedQueue);
            //}

        }

    }

    public static void priority(List<input> queue) {
        System.out.println("Priority in model is called");
    }

    public static void mlfq(List<input> queue) {
        System.out.println("MLFQ in model is called");
    }
}
