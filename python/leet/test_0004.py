# https://leetcode.com/problems/median-of-two-sorted-arrays/

from typing import List

class SolutionA:
    def findMedianSortedArrays(self, nums1, nums2):
        combined_list = nums1 + nums2
        combined_list.sort()
        length = len(combined_list)
        if (length % 2) == 0:
            return (combined_list[int(length/2)-1] + combined_list[int(length/2)])/2
        else:
            return combined_list[int(length/2)]

''' Runtime: 96 ms, faster than 52.29%
Memory Usage: 14.6 MB, less than 55.99% '''

def test():
    sol = SolutionA()
    assert sol.findMedianSortedArrays([1,3], [2]) == 2.0
    assert sol.findMedianSortedArrays([1,2], [3,4]) == 2.5

class SolutionB:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        l = nums1 + nums2
        l.sort()
        n = len(l)
        half_n = int(n / 2)
        if n % 2 == 1:
            return l[half_n]
        else:
            return (l[half_n -1] + l[half_n]) / 2

def testB():
    assert [1,2] + [3,4] == [1,2,3,4]
    sol = SolutionB()
    assert sol.findMedianSortedArrays([1,3], [2]) == 2.0
    assert sol.findMedianSortedArrays([1,2], [3,4]) == 2.5