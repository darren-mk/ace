class SolutionA:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if not stack and c in ')}]':
                return False
            if c in '({[':
                stack.append(c)
                continue
            if c == ')':
                if stack[-1] == '(':
                    stack.pop()
                else:
                    return False
            if c == ']':
                if stack[-1] == '[':
                    stack.pop()
                else:
                    return False
            if c == '}':
                if stack[-1] == '{':
                    stack.pop()
                else:
                    return False
        return not stack

def testA():
    sol = SolutionA()
    sol.isValid("()[]{}") == True

# Runtime Beats 36.07%
# Memory Beats 58.04%