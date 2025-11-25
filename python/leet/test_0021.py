# https://leetcode.com/problems/merge-two-sorted-lists/

from typing import List, Optional

Val = int
Vals = List[Val]

class ListNode:
    def __init__(self, val:Val=0, next:Optional[ListNode]=None):
        self.val = val
        self.next = next

class SolutionA:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        res_node = ListNode(0)
        tail_node = res_node
        while list1 or list2:
            k = 0
            if list1 is None: k = 2
            elif list2 is None: k = 1
            elif list1.val < list2.val: k = 1
            else: k = 2
            if k == 1:
                tail_node.next = ListNode(list1.val)
                list1 = list1.next
            else:
                tail_node.next = ListNode(list2.val)
                list2 = list2.next
            tail_node = tail_node.next
        return res_node.next

def testA():
    def build_list(vals:Vals):
        head = None
        for v in reversed(vals):
            head = ListNode(v, head)
        return head
    def to_list(node:ListNode):
        out: Vals = []
        while node:
            out.append(node.val)
            node = node.next
        return out
    s = SolutionA()
    l1 = build_list([1,2,4]); l2 = build_list([1,3,5])
    assert to_list(s.mergeTwoLists(l1,l2)) == [1,1,2,3,4,5]
    l1 = build_list([]); l2 = build_list([0,7])
    assert to_list(s.mergeTwoLists(l1,l2)) == [0,7]
    l1 = build_list([]); l2 = build_list([])
    assert to_list(s.mergeTwoLists(l1,l2)) == []
    l1 = build_list([2,2,2]); l2 = build_list([2,2])
    assert to_list(s.mergeTwoLists(l1,l2)) == [2,2,2,2,2]
    l1 = build_list([-3,1,4]); l2 = build_list([-2,0,3])
    assert to_list(s.mergeTwoLists(l1,l2)) == [-3,-2,0,1,3,4]

class SolutionB:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        root = ListNode(0)
        cursor = root
        while list1 or list2:
            if (list1 and list2 and (list1.val < list2.val)) \
                or (list2 is None):
                cursor.next = ListNode(list1.val)
                list1 = list1.next
            else:
                cursor.next = ListNode(list2.val)
                list2 = list2.next
            cursor = cursor.next
        return root.next

def testB():
    def build_list(vals:Vals):
        head = None
        for v in reversed(vals):
            head = ListNode(v, head)
        return head
    def to_list(node:ListNode):
        out: Vals = []
        while node:
            out.append(node.val)
            node = node.next
        return out
    s = SolutionB()
    l1 = build_list([1,2,4]); l2 = build_list([1,3,5])
    assert to_list(s.mergeTwoLists(l1,l2)) == [1,1,2,3,4,5]
    l1 = build_list([]); l2 = build_list([0,7])
    assert to_list(s.mergeTwoLists(l1,l2)) == [0,7]
    l1 = build_list([]); l2 = build_list([])
    assert to_list(s.mergeTwoLists(l1,l2)) == []
    l1 = build_list([2,2,2]); l2 = build_list([2,2])
    assert to_list(s.mergeTwoLists(l1,l2)) == [2,2,2,2,2]
    l1 = build_list([-3,1,4]); l2 = build_list([-2,0,3])
    assert to_list(s.mergeTwoLists(l1,l2)) == [-3,-2,0,1,3,4]