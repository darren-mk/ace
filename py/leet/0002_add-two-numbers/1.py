# https://leetcode.com/problems/add-two-numbers/

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# solution trial
class Solution:        
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        l3 = ListNode()
        l3_roll = l3
        while l1 or l2:
            if l1:
                l3.val += l1.val
                if l1.next:
                    l3.next = ListNode()
                l1 = l1.next
            if l2:
                l3.val += l2.val
                if l2.next:
                    l3.next = ListNode()
                l2 = l2.next
            if l3.val >= 10:
                l3.val = l3.val % 10
                l3.next = ListNode(1)
            l3 = l3.next            
        return l3_roll
        
x = ListNode(2, ListNode(4, ListNode(3)))
y = ListNode(5, ListNode(6, ListNode(4)))
trial = Solution()
a = trial.addTwoNumbers(x, y)
