import java.util.*;

public class roundRobin{

    private static int quantum = 20;  // Setting the quantum

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in Round Robin is called");

        while(!queue.isEmpty()) {
            input value = queue.removeFirst();  // Removes the first value from the queue
            //input value = dequeue();
            System.out.println(value);

            Thread thread = new Thread(value);  // Creates a new Thread that runs in the code

            long currentValueBurstTime = value.getBurstTime();  // Getting the current burst time storing in input class

            thread.start(); // Starts the thread and runs the run method in input class parallelly

            try {
                Thread.sleep(quantum); // Put the to sleep to simulate the work process

                Thread.State currentValueState = thread.getState(); // Getting the state of the current thread

                if (!currentValueState.equals(Thread.State.TERMINATED)) { // Checking whether the current state of the input value is not TERMINATED

                    thread.interrupt(); // If a process is waiting for something, we wake it up

                    long afterProcessBurstTime = currentValueBurstTime - quantum;   // Calculating the new burst time after the entering into the process

                    if (afterProcessBurstTime > 0) {
                        value.setBurstTime(afterProcessBurstTime);  // Setting the current value burst time to afterProcessBurstTime as it has not been fully process yet
                        System.out.println(value);
                        enqueue(value); // Inserting the value at the back of the queue so it can go into the process again
                    } else {

                        thread.join(); // Make sure to output the state as TERMINATED when the value has been fully process

                        value.setBurstTime(0); // To prevent it showing negative numbers

                        model.addToCompletedQueue(value); // Adding values that have completed the process in to the completed queue in model class
                        System.out.println(value + " " + thread.getState());
                    }
                } else {

                    thread.join(); // Make sure to output the state as TERMINATED when the value has been fully process

                    value.setBurstTime(0); // To prevent it showing negative numbers

                    model.addToCompletedQueue(value); // Adding values that have completed the process in to the completed queue in model class
                    System.out.println(value + " " + thread.getState());
                }

            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    public static void enqueue(input value) {
        inputManage.addToWaitingQueue(value); // Adding the value to the end of thw queue
        // System.out.println("In Enqueue method");
    }

    public static void dequeue() {
        inputManage.getWaitingQueue().removeFirst();
    }
}
