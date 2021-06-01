# https://leetcode.com/problems/palindrome-number/

class Solution:
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
