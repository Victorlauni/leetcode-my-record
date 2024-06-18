import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        HashMap<Integer, Integer> maxProfitByDiff = new HashMap<>();
        HashMap<Integer, Integer> diffProfitMap = new HashMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            diffProfitMap.put(difficulty[i], Math.max(diffProfitMap.getOrDefault(difficulty[i], 0), profit[i]));
        }

        var diffProfitMapSorted = diffProfitMap.entrySet().stream()
            .sorted((a, b) -> a.getKey() - b.getKey())
            .iterator();

        int lastProfit = 0;
        while (diffProfitMapSorted.hasNext()) {
            var curr = diffProfitMapSorted.next();
            if (curr.getValue() > lastProfit) {
                lastProfit = curr.getValue();
                maxProfitByDiff.put(curr.getKey(), curr.getValue());
                
            }
        }

        List<Integer> diffKeys = maxProfitByDiff.keySet().stream().sorted().toList();
        int result = 0;
        for (int i = 0; i < worker.length; i++) {
            int diffInd = Collections.binarySearch(diffKeys, worker[i]);
            if (diffInd == -1) return 0;
            if (diffInd < 0) diffInd = - diffInd - 2;
            result += maxProfitByDiff.get(diffKeys.get(diffInd));
        }
        return result;
    }
}