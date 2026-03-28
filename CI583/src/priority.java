import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class priority{

    private static int quantum = 20;

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in Priority is called");

        Comparator<input> priorityComparator = Comparator.comparingInt(value -> value.getProcessPriority()); // JavaSpring.net
        PriorityQueue<input> waitingQueue = new PriorityQueue<>(priorityComparator);
        waitingQueue.addAll(queue);

        System.out.println(waitingQueue);

        while (!waitingQueue.isEmpty()) {
            input value = waitingQueue.poll();
            System.out.println(value);
            queue.remove(value);

            Thread thread = new Thread(value);

            thread.start();

            try {
                Thread.sleep(quantum);

                Thread.State currentValueState = thread.getState();

                if (!currentValueState.equals(Thread.State.TERMINATED)) {

                    thread.interrupt();

                    thread.join();

                    System.out.println(value + " " + thread.getState());
                    view.runningJLabel.setText(value.getProcessID() + " " + value.getProcessPriority() + thread.getState());
                    model.addToCompletedQueue(value);
                } else {
                    model.addToCompletedQueue(value);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}
