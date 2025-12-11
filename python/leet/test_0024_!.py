from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class SolutionA:
    def go(self, parent: Optional[ListNode], child: Optional[ListNode]):
        if child is None: return
        if parent is None:
            self.go(child, child.next)
        else:
            parent.val, child.val = child.val, parent.val
            self.go(None, child.next)
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        self.go(None, head)
        return head

# time: O(n)
# space: O(n)
# runtime: 100.00%
# memory: 53.44%
# should replace nodes themselves, not their values.