import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mlfq {

    private static int quantum = 20; // Setting the quantum

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in MLFQ is called");

        Queue<input> youngQueue = new LinkedList<>(); // Creating young queue
        Queue<input> oldQueue = new LinkedList<>(); // Creating old queue

        youngQueue.addAll(queue); // Adding all the elements stored in queue into young queue

        while (!(youngQueue.isEmpty() && oldQueue.isEmpty())) { // Checking are both young queue and old queue empty

            while (!youngQueue.isEmpty()) { // Checking is young queue empty
                input value = youngQueue.poll(); // Getting the first element by returning and removing it
                System.out.println(value);
                queue.remove(value); // This is just for testing part to make sure the queue in inputManage has the same element

                Thread thread = new Thread(value); // Creates a new Thread that runs in the code

                long currentValueBurstTime = value.getBurstTime(); // Getting the current burst time storing in input class

                thread.start();  // Starts the thread and runs the run method in input class parallelly

                try {
                    Thread.sleep(quantum); // Put the to sleep to simulate the work process

                    Thread.State currentValueState = thread.getState(); // Getting the state of the current thread


                    if (!currentValueState.equals(Thread.State.TERMINATED)) { // Checking whether the current state of the input value is not TERMINATED

                        long afterProcessBurstTime = currentValueBurstTime - quantum;  // Calculating the new burst time after the entering into the process
                        value.setBurstTime(afterProcessBurstTime); // Setting the current value burst time to afterProcessBurstTime as it has not been fully process yet

                        if (value.getBurstTime() > 0) {

                            thread.interrupted(); // If a process is waiting for something, we wake it up

                            oldQueue.add(value); // Adding the value into oldQueue as it has not been fully process
                            queue.addLast(value); // This is just for testing part to make sure the queue in inputManage has the same element
                        } else {
                            thread.join(); // Make sure to output the state as TERMINATED when the value has been fully process

                            System.out.println(value + " " + thread.getState());

                            model.addToCompletedQueue(value); // Adding values that have completed the process in to the completed queue in model class
                        }
                    } else {
                        thread.join(); // Make sure to output the state as TERMINATED when the value has been fully process

                        System.out.println(value + " " + thread.getState());

                        model.addToCompletedQueue(value); // Adding values that have completed the process in to the completed queue in model class
                    }

                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }

            }
            System.out.println("Young Queue is empty" + youngQueue);

            while (!oldQueue.isEmpty()) { // Checking is old queue empty
                input value = oldQueue.poll(); // Getting the first element by returning and removing it
                System.out.println(value);
                queue.remove(value); // This is just for testing part to make sure the queue in inputManage has the same element

                Thread thread = new Thread(value); // Creates a new Thread that runs in the code

                long currentValueBurstTime = value.getBurstTime(); // Getting the current burst time storing in input class

                thread.start(); // Starts the thread and runs the run method in input class parallelly

                try {
                    Thread.sleep(20); // Put the to sleep to simulate the work process

                    Thread.State currentValueState = thread.getState(); // Getting the state of the current thread


                    if (!currentValueState.equals(Thread.State.TERMINATED)) { // Checking whether the current state of the input value is not TERMINATED

                        long afterProcessBurstTime = currentValueBurstTime - quantum;  // Calculating the new burst time after the entering into the process
                        value.setBurstTime(afterProcessBurstTime); // Setting the current value burst time to afterProcessBurstTime as it has not been fully process yet

                        if (value.getBurstTime() > 0) {

                            thread.interrupted(); // If a process is waiting for something, we wake it up

                            youngQueue.add(value); // Adding the value into youngQueue as it has not been fully process
                            queue.addLast(value); // This is just for testing part to make sure the queue in inputManage has the same element
                        } else {
                            thread.join(); // Make sure to output the state as TERMINATED when the value has been fully process

                            System.out.println(value + " " + thread.getState());

                            model.addToCompletedQueue(value); // Adding values that have completed the process in to the completed queue in model class
                        }
                    } else {
                        thread.join(); // Make sure to output the state as TERMINATED when the value has been fully process

                        System.out.println(value + " " + thread.getState());

                        model.addToCompletedQueue(value); // Adding values that have completed the process in to the completed queue in model class
                    }

                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }

            }
            System.out.println("Old Queue is empty" + oldQueue);
        }
        System.out.println("Both Lists are empty");
        System.out.println(youngQueue);
        System.out.println(oldQueue);
    }
}
