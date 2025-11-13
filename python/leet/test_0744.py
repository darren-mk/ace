from typing import List 

class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        left = 0
        right = len(letters) - 1
        while left <= right:
            mid = (left + right) // 2
            if letters[mid] <= target:
                left = mid + 1
            else:
                right = mid - 1
        return letters[left % len(letters)]

def test():
    assert 'a' < 'b'
    sol = Solution()
    assert sol.nextGreatestLetter(['a','b','c','d'], 'b') == 'c'
    assert sol.nextGreatestLetter(['a','b','c','d','e','f'], 'e') == 'f'
    assert sol.nextGreatestLetter(['a','b','c','d','e','f'], 'd') == 'e'
    assert sol.nextGreatestLetter(["c","f","j"], "a") == "c"
    assert sol.nextGreatestLetter(["c","f","j"], "c") == "f"
    assert sol.nextGreatestLetter(["c","f","j"], "d") == "f"
    assert sol.nextGreatestLetter(["c","f","j"], "g") == "j"
    assert sol.nextGreatestLetter(["x","x","y","y"], "z") == "x"