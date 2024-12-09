from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if n == 0: return

        index1 = m - 1
        index2 = n - 1

        for pointer1 in range(-1, - m - n - 1, -1):
            if index1 >= 0 and (index2 < 0 or nums1[index1] >= nums2[index2]):
                nums1[pointer1] = nums1[index1]
                index1 -= 1
            else:
                nums1[pointer1] = nums2[index2]
                index2 -= 1