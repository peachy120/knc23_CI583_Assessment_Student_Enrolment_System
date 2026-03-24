import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class mlfq {

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in MLFQ is called");

        Queue<input> youngQueue = new ConcurrentLinkedQueue<>();
        Queue<input> oldQueue = new ConcurrentLinkedQueue<>();

        youngQueue.addAll(queue);

//        System.out.println(youngQueue);
//        System.out.println(oldQueue);

        while (!(youngQueue.isEmpty() && oldQueue.isEmpty())) {

            while (!youngQueue.isEmpty()) {
                input value = youngQueue.poll();
                System.out.println(value);
                queue.removeFirst();

                Thread thread = new Thread(value);
                Thread.State currentValueState = thread.getState();
                System.out.println(currentValueState);

                thread.start();

                if (currentValueState.equals(Thread.State.NEW)) {
                    try {
                        Thread.sleep(20);
                        System.out.println(value + " " + thread.getState());

                        if (!(thread.getState().equals(Thread.State.TERMINATED))) {
                            oldQueue.add(value);
                            queue.addLast(value);
                        }

                        model.addToCompletedQueue(value);
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted: " + e.getMessage());
                    }
                } else {
                    model.addToCompletedQueue(value);
                }
            }
            System.out.println("Young Queue is empty" + youngQueue);

            while (!oldQueue.isEmpty()) {
                input value = oldQueue.poll();
                System.out.println(value);
                queue.removeFirst();

                Thread thread = new Thread(value);
                Thread.State currentValueState = thread.getState();
                System.out.println(currentValueState);

                thread.start();

                if (currentValueState.equals(Thread.State.NEW)) {
                    try {
                        Thread.sleep(20);
                        System.out.println(value + " " + thread.getState());

                        if (!(thread.getState().equals(Thread.State.TERMINATED))) {
                            youngQueue.add(value);
                            queue.addLast(value);
                        }

                        model.addToCompletedQueue(value);
                    } catch (InterruptedException e) {
                        System.out.println("Thread interrupted: " + e.getMessage());
                    }
                } else {
                    model.addToCompletedQueue(value);
                }
            }
            System.out.println("Old Queue is empty" + oldQueue);
        }
        System.out.println("Both Lists are empty");
        System.out.println(youngQueue);
        System.out.println(oldQueue);



    }
}
