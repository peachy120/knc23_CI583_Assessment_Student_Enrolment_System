import java.util.*;

public class roundRobin{

    private static int quantum = 1000;

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in Round Robin is called");

        while(!queue.isEmpty()) {
            input value = queue.removeFirst();  // Removes the first value from the queue
            System.out.println(value);

            Thread thread = new Thread(value);  // Creates a new Thread that runs in the code

            long currentValueBurstTime = value.getBurstTime();  // Getting the current burst time storing in input class

            thread.start(); // Starts the thread and runs the run method in input class parallelly

            try {
                Thread.sleep(quantum);

                Thread.State currentValueState = thread.getState();

                if (!currentValueState.equals(Thread.State.TERMINATED)) {

                    thread.interrupt();

                    long afterProcessBurstTime = currentValueBurstTime - quantum;

                    if (afterProcessBurstTime > 0) {
                        value.setBurstTime(afterProcessBurstTime);
                        System.out.println(value);
                        view.runningJLabel.setText(value.getProcessID()  + " | " + value.getBurstTime());
                        queue.add(value);
                    } else {

                        thread.join();

                        model.addToCompletedQueue(value);
                        System.out.println(value + " " + thread.getState());
                        view.runningJLabel.setText(value.getProcessID() + " | " + value.getBurstTime() + " is " + thread.getState());
                    }
                } else {

                    thread.join();

                    model.addToCompletedQueue(value);
                    System.out.println(value + " " + thread.getState());
                    view.runningJLabel.setText(value.getProcessID() + " | " + value.getBurstTime() + " is " + thread.getState());
                }

            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    public void equeue() {

    }

    public void dequeue() {

    }
}
