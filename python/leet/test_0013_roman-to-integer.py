class Solution:
    def romanToInt(self, s: str) -> int:
        m = {
            'I': 1, 'V': 5, 'X': 10, 'L': 50,
            'C': 100, 'D': 500, 'M': 1000,
            'IV': 4, 'IX': 9, 'XL': 40, 'XC': 90,
            'CD': 400, 'CM': 900 
        }
        i = 0
        sum = 0
        while i < len(s):
            if i + 1 < len(s) and s[i:i+2] in m:
                sum += m[s[i:i+2]]
                i += 2
            else: 
                sum += m[s[i]]
                i += 1
        return sum

def test_solution():
    sol = Solution()
    assert [1,2,3,4,5][2:4] == [3,4]
    assert sol.romanToInt("III") == 3
    assert sol.romanToInt("LVIII") == 58
    assert sol.romanToInt("MCMXCIV") == 1994