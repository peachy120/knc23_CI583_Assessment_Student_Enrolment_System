import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class priority{

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in Priority is called");

        Comparator<input> priorityComparator = Comparator.comparingInt(value -> value.getProcessPriority()); // JavaSpring.net
        PriorityQueue<input> waitingQueue = new PriorityQueue<>(priorityComparator);
        waitingQueue.addAll(queue);

        System.out.println(waitingQueue);

        while (!waitingQueue.isEmpty()) {
            input value = waitingQueue.poll();
            System.out.println(value);

            Thread thread = new Thread(value);
            Thread.State currentValueState = thread.getState();
            System.out.println(currentValueState);

            thread.start();

            if (currentValueState.equals(Thread.State.NEW)) {
                try {
                    Thread.sleep(20);
                    System.out.println(value + " " + thread.getState());
                    view.runningJLabel.setText(value.getProcessID() + " " + value.getProcessPriority() + thread.getState());
                    model.addToCompletedQueue(value);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            } else {
                model.addToCompletedQueue(value);
            }
        }
    }
}
