class Solution {
    public void sortColors(int[] nums) {
        int rInd = 0;
        int bInd = 0;
        for (int i = 0; i < nums.length - bInd; i++) {
            if (nums[i] == 1) continue;
            if (nums[i] == 0) {
                if (nums[rInd] == nums[i]) {
                    rInd++;
                    continue;
                }
                int tmp = nums[rInd];
                nums[rInd] = nums[i];
                nums[i] = tmp;
                rInd++;
                i--;
            } else {
                int tmp = nums[nums.length - 1 - bInd];
                nums[nums.length - 1 - bInd] = nums[i];
                nums[i] = tmp;
                bInd++;
                i--;
            }
        }
    }
}