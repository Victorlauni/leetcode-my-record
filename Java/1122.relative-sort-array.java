import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            freqMap.put(arr1[i], freqMap.getOrDefault(arr1[i], 0)+1);
        }
        ArrayList<Integer> out = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            if (freqMap.containsKey(arr2[i])) {
                out.addAll(Collections.nCopies(freqMap.get(arr2[i]), arr2[i]));
                freqMap.remove(arr2[i]);
            }
        }
        freqMap.keySet().stream().sorted().forEach(key -> {
            out.addAll(Collections.nCopies(freqMap.get(key), key));
        });
        return out.stream().mapToInt(i -> i).toArray();
    }
}