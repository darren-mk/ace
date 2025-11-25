import sys
from typing import List

class SolutionA:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0: return ''
        if len(strs) == 1: return strs[0]
        i = 0
        common_prefix = ''
        check = set()
        lengths = []
        for s in strs:
            lengths.append(len(s))
        l = min(lengths)
        for i in range(l):
            for s in strs:
                check.add(s[i])
            if len(check) == 1:
                common_prefix += list(check)[0]
                check.clear()
            else:
                return common_prefix
        return common_prefix

def testA():
    sol = SolutionA()
    assert sol.longestCommonPrefix(["flower","flow","flight"]) == "fl"
    assert sol.longestCommonPrefix(["dog","racecar","car"]) == ""
    assert sol.longestCommonPrefix(["aaa","aaa","aaa"]) == "aaa"
    assert sol.longestCommonPrefix(["interspecies","inter","interstellar"]) == "inter"
    assert sol.longestCommonPrefix(["single"]) == "single"
    assert sol.longestCommonPrefix(["","b","c"]) == ""
    assert sol.longestCommonPrefix(["","",""]) == ""
    assert sol.longestCommonPrefix(["cir","car"]) == "c"
    assert sol.longestCommonPrefix(["a","b"]) == ""
    assert sol.longestCommonPrefix(["ab", "a"]) == "a"
    assert sol.longestCommonPrefix(["abc", "abd", "abf", "ab"]) == "ab"

# Runtime Beats 35.14%
# Memory Beats 29.93%

class SolutionB:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        ind = 0
        size = sys.maxsize
        for s in strs:
            size = min(size, len(s))
        population = len(strs)
        for i in range(size + 1):
            cursor = ''
            for j in range(population):
                if cursor == '':
                    cursor = strs[j][:i]
                elif cursor != strs[j][:i]:
                    break
                if j == population - 1:
                    cursor = ''
                    ind = i
        return strs[0][:ind]

def testB():
    sol = SolutionB()
    assert sol.longestCommonPrefix(["flower","flow","flight"]) == "fl"
    assert sol.longestCommonPrefix(["dog","racecar","car"]) == ""
    assert sol.longestCommonPrefix(["aaa","aaa","aaa"]) == "aaa"
    assert sol.longestCommonPrefix(["interspecies","inter","interstellar"]) == "inter"
    assert sol.longestCommonPrefix(["single"]) == "single"
    assert sol.longestCommonPrefix(["","b","c"]) == ""
    assert sol.longestCommonPrefix(["","",""]) == ""
    assert sol.longestCommonPrefix(["cir","car"]) == "c"
    assert sol.longestCommonPrefix(["a","b"]) == ""
    assert sol.longestCommonPrefix(["ab", "a"]) == "a"
    assert sol.longestCommonPrefix(["abc", "abd", "abf", "ab"]) == "ab"


class SolutionC:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        prefix = strs[0] if strs else ""
        for s in strs:
            while not s.startswith(prefix):
                prefix = prefix[:-1]
        return prefix

def testC():
    assert "abcd".startswith("ab") == True
    assert "abcd"[:-1] == "abc"
    sol = SolutionC()
    assert sol.longestCommonPrefix(["flower","flow","flight"]) == "fl"
    assert sol.longestCommonPrefix(["dog","racecar","car"]) == ""
    assert sol.longestCommonPrefix(["aaa","aaa","aaa"]) == "aaa"
    assert sol.longestCommonPrefix(["interspecies","inter","interstellar"]) == "inter"
    assert sol.longestCommonPrefix(["single"]) == "single"
    assert sol.longestCommonPrefix(["","b","c"]) == ""
    assert sol.longestCommonPrefix(["","",""]) == ""
    assert sol.longestCommonPrefix(["cir","car"]) == "c"
    assert sol.longestCommonPrefix(["a","b"]) == ""
    assert sol.longestCommonPrefix(["ab", "a"]) == "a"
    assert sol.longestCommonPrefix(["abc", "abd", "abf", "ab"]) == "ab"

# Runtime Beats 100.00%
# Memory Beats 78.28%