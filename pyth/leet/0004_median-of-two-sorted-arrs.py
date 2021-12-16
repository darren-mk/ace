# https://leetcode.com/problems/median-of-two-sorted-arrays/

# 1
class Solution_01:
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