class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length-count; i++) {
            if (nums[i] == val) {
                while (nums[nums.length-count-1] == val) {
                    if (nums.length-count-1 <= i) return nums.length-count-1;
                    count++;
                }
                nums[i] = nums[nums.length-count-1];
                count++;
            }
        }
        return nums.length - count;
    }
}