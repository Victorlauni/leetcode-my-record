from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        val_count = 0
        for index in range(len(nums)):
            if nums[index] != val:
                nums[index - val_count] = nums[index]
            else:
                val_count += 1
        return len(nums) - val_count