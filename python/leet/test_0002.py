# https://leetcode.com/problems/add-two-numbers/

from typing import Optional
class ListNode:
    def __init__(self, val:int=0, next: Optional[ListNode]=None):
        self.val = val
        self.next = next

class SolutionA:
    def node_to_reverse_num(self, ln: Optional[ListNode]) -> int:
        if ln is None:
            return 0
        sum: int = 0
        decimal = 1
        cursor = ln
        while cursor:
            sum += cursor.val * decimal
            decimal *= 10
            cursor = cursor.next
        return sum

    def num_to_node(self, n:int) -> Optional[ListNode]:
        if n == 0:
            return ListNode(0)
        node: Optional[ListNode] = None
        digit: int = n % 10
        while digit > 0:
            if node is None:
                node = ListNode(digit)
            else:
                node = ListNode(digit, node)
            n //= 10
            digit = n % 10
        return node

    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        summed = self.node_to_reverse_num(l1) + self.node_to_reverse_num(l2)
        return self.num_to_node(summed)

def test_a():
    sol = SolutionA()
    a: ListNode = ListNode(2, ListNode(4, ListNode(3)))
    b: ListNode = ListNode(5, ListNode(6, ListNode(4)))
    assert sol.node_to_reverse_num(a) == 342
    assert sol.node_to_reverse_num(b) == 465
    assert sol.node_to_reverse_num(sol.num_to_node(465)) == 564
