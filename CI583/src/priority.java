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
            input value = waitingQueue.poll(); // Getting the first element by returning and removing it
            System.out.println(value);
            queue.remove(value); // This is just for testing part to make sure the queue in inputManage has the same element

            Thread thread = new Thread(value);  // Creates a new Thread that runs in the code

            thread.start(); // Starts the thread and runs the run method in input class parallelly

            try {
                Thread.sleep(quantum); // Put the to sleep to simulate the work process

                Thread.State currentValueState = thread.getState(); // Getting the state of the current thread

                if (!currentValueState.equals(Thread.State.TERMINATED)) { // Checking whether the current state of the input value is not TERMINATED

                    thread.interrupt(); // If a process is waiting for something, we wake it up

                    thread.join(); // Make sure to output the state as TERMINATED when the value has been fully process

                    System.out.println(value + " " + thread.getState());
                    model.addToCompletedQueue(value); // Adding values that have completed the process in to the completed queue in model class
                } else {
                    model.addToCompletedQueue(value); // Adding values that have completed the process in to the completed queue in model class
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}
