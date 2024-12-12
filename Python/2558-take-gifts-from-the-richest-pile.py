import heapq
import math
from functools import reduce
from typing import List


class Solution:
    def pickGifts(self, gifts: List[int], k: int) -> int:
        h = [i*-1 for i in gifts]
        heapq.heapify(h)
        for _ in range(k):
            max = heapq.heappop(h)
            newVal = math.floor(math.sqrt(math.fabs(max)))
            heapq.heappush(h, -newVal)
        return -reduce(lambda x, y: x + y, h)