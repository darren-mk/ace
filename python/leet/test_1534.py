from typing import List, Dict, Tuple, Sequence

class SolutionA:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        n = range(len(arr))
        count = 0
        for i in n:
            for j in n:
                for k in n:
                    A = abs(arr[i] - arr[j])
                    B = abs(arr[j] - arr[k])
                    C = abs(arr[i] - arr[k])
                    if i < j < k and A <= a and B <= b and C <= c:
                        count += 1
        return count

# runtime: 5.10%
# memory: 43.34%