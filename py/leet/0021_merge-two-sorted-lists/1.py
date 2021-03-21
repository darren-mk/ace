# https://leetcode.com/problems/merge-two-sorted-lists/


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:        
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:

        def count_listnode(ln):
            counter = 0
            while ln:
                counter += 1
                ln = ln.next 
            return counter

        if count_listnode(l1) == 0 and count_listnode(l2) == 0: return []
        if count_listnode(l1) == 0: return l2
        if count_listnode(l2) == 0: return l1
        vals = []
        while l1:
            vals.append(l1.val)
            l1 = l1.next
        while l2:
            vals.append(l2.val)
            l2 = l2.next
        vals.sort()
        vals.reverse()
        nodes = ListNode(vals[0])
        for i in range(1, len(vals)):
            nodes = ListNode(vals[i], nodes)
        return nodes

