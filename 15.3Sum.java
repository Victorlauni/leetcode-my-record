class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<String> dupCheck = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> numList = Arrays.stream(nums)
            .boxed()
            .sorted()
            .collect(Collectors.toList());
        for (int i = 0; i < numList.size()-2; i++) {
            if (numList.get(i) > 0) break;
            int lowPointer = i+1;
            int highPointer = numList.size()-1;

            while (lowPointer < highPointer) {
                int sum = numList.get(i) + numList.get(lowPointer) + numList.get(highPointer);
                if (sum > 0) highPointer--;
                else if (sum < 0) lowPointer++;
                else {
                    String checkString = String.format("%d %d %d", numList.get(i), numList.get(lowPointer), numList.get(highPointer));
                    if (!dupCheck.contains(checkString)) {
                        ans.add(new ArrayList<>(Arrays.asList(numList.get(i), numList.get(lowPointer), numList.get(highPointer))));
                        dupCheck.add(checkString);
                    }
                    highPointer--;
                    lowPointer++;
                }
            }
        }
        return ans;
    }
}