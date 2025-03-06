import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static ArrayList<Integer> findOrder(ArrayList<Integer> height, ArrayList<Integer> infront) {
        int n = height.size();
        ArrayList<Integer> result = new ArrayList<>(n);
        List<Person> people = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            people.add(new Person(height.get(i), infront.get(i)));
        }

        people.sort(Comparator.comparingInt(a -> a.height));

        List<Integer> queue = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            queue.add(null); // Initialize with nulls
        }

        for (Person person : people) {
            int count = 0;
            int insertedIndex = -1;
            for (int i = 0; i < n; i++) {
                if (queue.get(i) == null) {
                    if (count == person.infront) {
                        queue.set(i, person.height);
                        insertedIndex = i;
                        break;
                    }
                    count++;
                }
            }
        }

        result.addAll(queue);
        return result;
    }

    static class Person {
        int height;
        int infront;

        public Person(int height, int infront) {
            this.height = height;
            this.infront = infront;
        }
    }
}