from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class SolutionA:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        temp = ListNode(0)
        cursor = temp
        while head:
            if head.val != val:
                cursor.next = ListNode(head.val)
                cursor = cursor.next
            head = head.next
        return temp.next

# Runtime Beats 8.69%
# Memory Beats 5.40%

class SolutionB:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        prev, cur = dummy, head
        while cur:
            if cur.val == val:
                prev.next = cur.next
            else:
                prev = cur
            cur = cur.next
        return dummy.next

# Runtime Beats 100.00%
# Memory Beats 40.53%