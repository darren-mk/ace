# https://leetcode.com/problems/add-two-numbers/

from collections import deque
from typing import Optional
class ListNode:
    def __init__(self, val:int=0, next: Optional[ListNode]=None):
        self.val = val
        self.next = next

class SolutionA:
    def extract(self, l: ListNode) -> int:
        decimal = 1
        acc = 0
        while l:
            acc += l.val * decimal
            decimal *= 10
            l = l.next
        return acc
    def build(self, n:int) -> ListNode:
        nums = []
        for c in str(n):
            nums.append(int(c))
        root = ListNode(0)
        tail = root
        while nums:
            tail.next = ListNode(nums.pop())
            tail = tail.next
        return root.next
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        n1 = self.extract(l1)
        n2 = self.extract(l2)
        n = n1 + n2
        return self.build(n)

def test_a():
    assert str(342) == '342'
    nums = []
    for c in '342':
        nums.append(int(c))
    assert nums ==  [3,4,2]
    sol = SolutionA()
    a: ListNode = ListNode(2, ListNode(4, ListNode(3)))
    b: ListNode = ListNode(5, ListNode(6, ListNode(4)))
    assert sol.extract(a) == 342
    assert sol.extract(b) == 465
    assert sol.extract(sol.build(342)) == 342
    assert sol.extract(sol.build(807)) == 807

# Runtime Beats 72.96%
# Memory Beats 84.58%

class SolutionB:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0)
        tail = dummy
        carry = 0
        while l1 or l2 or carry:
            v1 = l1.val if l1 else 0
            v2 = l2.val if l2 else 0
            s = v1 + v2 + carry
            carry, digit = divmod(s, 10)
            tail.next = ListNode(digit)
            tail = tail.next
            l1 = l1.next if l1 else None
            l2 = l2.next if l2 else None
        return dummy.next

# Runtime Beats 54.83%
# Memory Beats 56.63%