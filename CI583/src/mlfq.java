import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mlfq {

    private static int quantum = 20;

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in MLFQ is called");

        Queue<input> youngQueue = new LinkedList<>();
        Queue<input> oldQueue = new LinkedList<>();

        youngQueue.addAll(queue);

        while (!(youngQueue.isEmpty() && oldQueue.isEmpty())) {

            while (!youngQueue.isEmpty()) {
                input value = youngQueue.poll();
                System.out.println(value);
                queue.remove(value);

                Thread thread = new Thread(value);

                long currentValueBurstTime = value.getBurstTime();

                thread.start();

                try {
                    Thread.sleep(quantum);

                    Thread.State currentValueState = thread.getState();

                    long afterProcessBurstTime = currentValueBurstTime - quantum;
                    value.setBurstTime(afterProcessBurstTime);

                    if (!currentValueState.equals(Thread.State.TERMINATED)) {
                        if (value.getBurstTime() > 0) {
                            thread.interrupted();

                            oldQueue.add(value);
                            queue.addLast(value);
                        } else {
                            thread.join();

                            System.out.println(value + " " + thread.getState());

                            model.addToCompletedQueue(value);
                        }
                    } else {
                        thread.join();

                        System.out.println(value + " " + thread.getState());

                        model.addToCompletedQueue(value);
                    }

                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }

            }
            System.out.println("Young Queue is empty" + youngQueue);

            while (!oldQueue.isEmpty()) {
                input value = oldQueue.poll();
                System.out.println(value);
                queue.remove(value);

                Thread thread = new Thread(value);

                long currentValueBurstTime = value.getBurstTime();

                thread.start();

                try {
                    Thread.sleep(20);

                    Thread.State currentValueState = thread.getState();

                    long afterProcessBurstTime = currentValueBurstTime - quantum;
                    value.setBurstTime(afterProcessBurstTime);

                    if (!currentValueState.equals(Thread.State.TERMINATED)) {
                        if (value.getBurstTime() > 0) {

                            thread.interrupted();

                            youngQueue.add(value);
                            queue.addLast(value);
                        } else {
                            thread.join();

                            System.out.println(value + " " + thread.getState());

                            model.addToCompletedQueue(value);
                        }
                    } else {
                        thread.join();

                        System.out.println(value + " " + thread.getState());

                        model.addToCompletedQueue(value);
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
