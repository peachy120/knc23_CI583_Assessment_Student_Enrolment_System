import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class priority{

    public static void startEnrolment(List<input> queue) {
        System.out.println("Start Enrolment in Priority is called");

    }

    public Comparator<Integer> comparator = (s1, s2) -> {
        if (s1 > s2) {
            return s1;
        } else if(s2 > s1) {
            return s2;
        } else {
            return s1;
        }

    };

}
