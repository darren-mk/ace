class SolutionA:
    def scoreOfString(self, s: str) -> int:
        chars = list(s)
        summed = 0
        for i in range(len(chars)-1):
            summed += abs(ord(chars[i]) - ord(chars[i+1]))
        return summed

# runtime: 100.00%
# memory: 47.27%