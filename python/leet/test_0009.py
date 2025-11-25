# https://leetcode.com/problems/palindrome-number/

class SolutionA:
    def isPalindrome(self, x: int) -> bool:
        if x < 0: return False
        if x == 1: return True
        if x > 10 and x % 10 == 0: return False
        i = 1
        num = 0
        while (x / (10 ** i)) > 0.1:
            digit = int((x % (10 ** i)) / (10 ** (i-1)))
            num += digit * (10 ** (len(str(x))-i))
            i += 1
        return x == num

trial = Solution()
trial.isPalindrome(131)

class SolutionB:
    def isPalindrome(self, x: int) -> bool:
        s = str(x)
        return s == s[::-1]

# Runtime Beats 36.37%
# Memory Beats 63.44%