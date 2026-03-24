import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class mlfq {

    private static int quantum = 1000;

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in MLFQ is called");

        Queue<input> youngQueue = new LinkedList<>();
        Queue<input> oldQueue = new LinkedList<>();

        youngQueue.addAll(queue);

//        System.out.println(youngQueue);
//        System.out.println(oldQueue);

//        while (!(youngQueue.isEmpty() && oldQueue.isEmpty())) {
//
//            while (!youngQueue.isEmpty()) {
//                input value = youngQueue.poll();
//                System.out.println(value);
//                queue.removeFirst();
//
//                Thread thread = new Thread(value);
//                Thread.State currentValueState = thread.getState();
//                System.out.println(currentValueState);
//
//                thread.start();
//
//                if (currentValueState.equals(Thread.State.NEW)) {
//                    try {
//                        Thread.sleep(20);
//                        System.out.println(value + " " + thread.getState());
//
//                        if (!(thread.getState().equals(Thread.State.TERMINATED))) {
//                            oldQueue.add(value);
//                            queue.addLast(value);
//                        } else {
//                            model.addToCompletedQueue(value);
//                        }
//
//                    } catch (InterruptedException e) {
//                        System.out.println("Thread interrupted: " + e.getMessage());
//                    }
//                } else {
//                    model.addToCompletedQueue(value);
//                }
//            }
//            System.out.println("Young Queue is empty" + youngQueue);
//
//            while (!oldQueue.isEmpty()) {
//                input value = oldQueue.poll();
//                System.out.println(value);
//                queue.removeFirst();
//
//                Thread thread = new Thread(value);
//                Thread.State currentValueState = thread.getState();
//                System.out.println(currentValueState);
//
//                thread.start();
//
//                if (currentValueState.equals(Thread.State.NEW)) {
//                    try {
//                        Thread.sleep(20);
//                        System.out.println(value + " " + thread.getState());
//
//                        if (!(thread.getState().equals(Thread.State.TERMINATED))) {
//                            youngQueue.add(value);
//                            queue.addLast(value);
//                        } else {
//                            model.addToCompletedQueue(value);
//                        }
//
//                    } catch (InterruptedException e) {
//                        System.out.println("Thread interrupted: " + e.getMessage());
//                    }
//                } else {
//                    model.addToCompletedQueue(value);
//                }
//            }
//            System.out.println("Old Queue is empty" + oldQueue);
//        }
//        System.out.println("Both Lists are empty");
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

                long currentValueBurstTime = value.getBurstTime();

                thread.start();

                if (currentValueState.equals(Thread.State.NEW)) {
                    try {
                        Thread.sleep(20);

                        long afterProcessBurstTime = currentValueBurstTime - quantum;

                        if (afterProcessBurstTime > 0) {
                            value.setBurstTime(afterProcessBurstTime);
                            System.out.println(value);
                            oldQueue.add(value);
                            queue.addLast(value);
                        } else {
                            model.addToCompletedQueue(value);
                            System.out.println(value + " " + thread.getState());
                            view.runningJLabel.setText(value.getProcessID() + " | " + value.getBurstTime() + " is " + thread.getState());
                        }

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

                long currentValueBurstTime = value.getBurstTime();

                thread.start();

                if (currentValueState.equals(Thread.State.NEW)) {
                    try {
                        Thread.sleep(20);

                        long afterProcessBurstTime = currentValueBurstTime - quantum;

                        if (afterProcessBurstTime > 0) {
                            value.setBurstTime(afterProcessBurstTime);
                            System.out.println(value);
                            youngQueue.add(value);
                            queue.addLast(value);
                        } else {
                            model.addToCompletedQueue(value);
                            System.out.println(value + " " + thread.getState());
                            view.runningJLabel.setText(value.getProcessID() + " | " + value.getBurstTime() + " is " + thread.getState());
                        }

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
