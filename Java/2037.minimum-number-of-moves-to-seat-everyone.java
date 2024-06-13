
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        List<Integer> seatsSorted = Arrays.stream(seats).boxed().sorted().toList();
        List<Integer> studentsSorted = Arrays.stream(students).boxed().sorted().toList();
        int count = 0;
        for (int i = 0; i < seatsSorted.size(); i++) {
            count += Math.abs(seatsSorted.get(i) - studentsSorted.get(i));
        }
        return count;
    }
}