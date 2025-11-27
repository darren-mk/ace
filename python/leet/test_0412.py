from typing import List

class SolutionA:
    def fizzBuzz(self, n: int) -> List[str]:
        acc = []
        for i in range(1, n+1):
            three = i % 3 == 0
            five = i % 5 == 0
            if three and five:
                acc.append("FizzBuzz")
            elif three:
                acc.append("Fizz")
            elif five:
                acc.append("Buzz")
            else:
                acc.append(str(i))
        return acc

def testA():
    sol = SolutionA()
    assert sol.fizzBuzz(3) == ["1","2","Fizz"]
    assert sol.fizzBuzz(5) == ["1","2","Fizz","4","Buzz"]
    assert sol.fizzBuzz(15) == ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

# time: O(n)
# space: O(n)
# runtime: 100.00%
# memory: 25.57%