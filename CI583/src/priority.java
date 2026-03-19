import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class priority{

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in Priority is called");

        if (queue.isEmpty()) {
            System.out.println("Waiting Queue is empty");
        }

        for (int i = 0; i < queue.size(); i++) {
            input value = queue.get(i);

            int priority = value.getPriority();

            System.out.println(value);
            System.out.println(priority);

        }
    }

//    public Comparator<Integer> comparator = (s1, s2) -> {
//
//    };

}
