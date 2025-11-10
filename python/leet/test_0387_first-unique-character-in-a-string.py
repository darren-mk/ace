class SolutionA:
    def firstUniqChar(self, s: str) -> int:
        appearances = dict()
        for c in s:
            existing_count = appearances.get(c, 0)
            appearances[c] = existing_count + 1
        for i, c in enumerate(s):
            if appearances.get(c) == 1:
                return i
        return -1

def test_solution_a():
    sol = SolutionA()
    assert sol.firstUniqChar("leetcode") == 0
    assert sol.firstUniqChar("loveleetcode") == 2
    assert sol.firstUniqChar("aabb") == -1