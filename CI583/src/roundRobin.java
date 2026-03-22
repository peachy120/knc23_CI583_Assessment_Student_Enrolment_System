import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class roundRobin{

    private static int quantum = 1000;

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in Round Robin is called");

        while(!queue.isEmpty()) {
            input value = queue.removeFirst();
            System.out.println(value);

            Thread thread = new Thread(value);
            Thread.State currentValueState = thread.getState();
            System.out.println(currentValueState);

            long currentValueBurstTime = value.getBurstTime();

            thread.start();

            if (currentValueState.equals(Thread.State.NEW)) {
                try {
                    Thread.sleep(20);

                    long afterProcessBurstTime = currentValueBurstTime - quantum;
                    if (afterProcessBurstTime > 0) {
                        value.setBurstTime(afterProcessBurstTime);
                        System.out.println(value);
                        queue.add(value);
                    } else {
                        model.addToCompletedQueue(value);
                        System.out.println(value + " " + thread.getState());
                    }

                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            } else {
                model.addToCompletedQueue(value);
            }

        }

    }

    public void equeue() {

    }

    public void dequeue() {

    }
}
