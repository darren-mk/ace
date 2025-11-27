class SolutionA:
    def addBinary(self, a: str, b: str) -> str:
        return bin(int(a,2) + int(b,2))[2:]

def testA():
    assert int('11', 2) == 3
    sol = SolutionA()
    assert sol.addBinary('11', '1') == '100'
    assert sol.addBinary('1010', '1011') == '10101'

# time: O(m + n)
# space: O(m + n)
# runtime: 17.53%
# memory: 52.55%

class SolutionB:
    def addBinary(self, a: str, b: str) -> str:
        i = len(a) - 1
        j = len(b) - 1
        res = []
        carry = 0
        while i >= 0 or j >= 0 or carry:
            x = int(a[i]) if i >= 0 else 0
            y = int(b[j]) if j >= 0 else 0
            total = x + y + carry
            res.append(str(total % 2))
            carry = total // 2
            i -= 1
            j -= 1
        return ''.join(reversed(res))

def testB():
    assert int('11') == 11
    assert int('11',2) == 3
    sol = SolutionB()
    assert sol.addBinary('11', '1') == '100'
    assert sol.addBinary('1010', '1011') == '10101'

# time: O(n)
# space: O(n)
# runtime: 8.37%
# memory: 13.07%