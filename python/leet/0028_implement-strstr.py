# https://leetcode.com/problems/implement-strstr

# 1
# time
# space
class Solution_01:
    def strStr(self, haystack: str, needle: str) -> int:
        if haystack == "" and needle == "": 
            return 0 
        for i in range(len(haystack)):
            if haystack[i:].startswith(needle):
                return i
        return -1
''' Runtime: 84 ms, faster than 21.12%.
Memory Usage: 14.4 MB, less than 62.23%. '''

# 2
# time
# space
class Solution_02:
    def strStr(self, haystack: str, needle: str) -> int:
        if haystack == "" and needle == "": 
            return 0 
        for i in range(len(haystack)):
            if haystack[i:(i+len(needle))] == needle:
                return i
        return -1
''' Runtime: 56 ms, faster than 42.16%.
Memory Usage: 14.6 MB, less than 33.35%. '''
