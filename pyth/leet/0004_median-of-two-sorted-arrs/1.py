# https://leetcode.com/problems/median-of-two-sorted-arrays/

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        combined_list = nums1 + nums2
        combined_list.sort()
        length = len(combined_list)
        if (length % 2) == 0:
            return (combined_list[int(length/2)-1] + combined_list[int(length/2)])/2
        else:
            return combined_list[int(length/2)]

trial = Solution()
trial.findMedianSortedArrays([1,3], [2])
trial.findMedianSortedArrays([1,2], [3,4])   
