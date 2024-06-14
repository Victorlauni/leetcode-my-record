
import java.util.HashMap;
import java.util.List;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        List<Integer> freqMapK = freqMap.keySet().stream().sorted().toList();
        for (Integer fKey : freqMapK) {
            if (freqMap.get(fKey) <= 1) continue;
            int currK = fKey;
            int val = freqMap.get(currK);
            while (val > 1) {
                count += val - 1;
                freqMap.put(currK, 1);
                freqMap.put(currK+1, freqMap.getOrDefault(currK+1, 0) + val - 1);
                currK++;
                val = freqMap.getOrDefault(currK, 0);
            }
        }
        return count;
    }
}