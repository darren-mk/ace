class Solution:
    def divisorGame(self, n: int) -> bool:
        return n % 2 == 0
    
def test():
    sol = Solution()
    assert sol.divisorGame(1) == False
    assert sol.divisorGame(2) == True
    assert sol.divisorGame(3) == False
    assert sol.divisorGame(4) == True
    assert sol.divisorGame(5) == False
    assert sol.divisorGame(6) == True
    assert sol.divisorGame(7) == False
    assert sol.divisorGame(8) == True
    assert sol.divisorGame(9) == False
    assert sol.divisorGame(10) == True
    assert sol.divisorGame(11) == False
    assert sol.divisorGame(12) == True
    assert sol.divisorGame(13) == False
    assert sol.divisorGame(14) == True
    assert sol.divisorGame(15) == False
    assert sol.divisorGame(16) == True
    assert sol.divisorGame(17) == False
    assert sol.divisorGame(18) == True
    assert sol.divisorGame(19) == False
    assert sol.divisorGame(20) == True