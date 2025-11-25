
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class SolutionA:
    def extract(self, head: Optional[ListNode]):
        vals = []
        cursor = head
        while cursor:
            vals.append(cursor.val)
            cursor = cursor.next
        return vals
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        vals = self.extract(head)
        left = 0
        right = len(vals) - 1
        while left < right:
            if vals[left] != vals[right]:
                return False
            left += 1
            right -= 1
        return True

def testA():
    true_example = ListNode(1, ListNode(2, ListNode(2, ListNode(1))))
    false_example = ListNode(1, ListNode(2, ListNode(3)))
    sol = SolutionA()
    assert sol.extract(true_example) == [1,2,2,1]
    assert sol.extract(false_example) == [1,2,3]
    assert sol.isPalindrome(true_example) == True
    assert sol.isPalindrome(false_example) == False

# Runtime Beats 42.72%
# Memory Beats 36.40%

class SolutionB:
    def extract(self, head: Optional[ListNode]):
        vals = []
        cursor = head
        while cursor:
            vals.append(cursor.val)
            cursor = cursor.next
        return vals
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        vals = self.extract(head)
        return vals == vals[::-1]

def testB():
    true_example = ListNode(1, ListNode(2, ListNode(2, ListNode(1))))
    false_example = ListNode(1, ListNode(2, ListNode(3)))
    sol = SolutionB()
    assert sol.extract(true_example) == [1,2,2,1]
    assert sol.extract(false_example) == [1,2,3]
    assert sol.isPalindrome(true_example) == True
    assert sol.isPalindrome(false_example) == False

# Runtime Beats 71.90%
# Memory Beats 36.40%