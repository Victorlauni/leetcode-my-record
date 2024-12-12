from typing import List

class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        bool_list = []
        result = []
        for i in range(0, len(nums)-1):
            if nums[i]%2 == nums[i+1]%2:
                bool_list.append(False)
            else: bool_list.append(True)

        for query in queries:
            query_result = True
            for ind in range(query[0], query[1]):
                if not bool_list[ind]:
                    query_result = False
                    break
                else: continue
            result.append(query_result)
        return result