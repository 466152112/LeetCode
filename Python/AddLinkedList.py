# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        if l2 == None:
            return l1
        head = ListNode(-1)
        carry = 0
        result = head
        while l1 != None and l2 != None:
            val = (l1.val + l2.val + carry)%10
            carry = (l1.val + l2.val + carry)/10
            l1 = l1.next
            l2 = l2.next
            head.next = ListNode(val)
            head = head.next
        while l1 != None:
            val = (l1.val + carry)%10
            carry = (l1.val + carry)/10
            l1 = l1.next
            head.next = ListNode(val)
            head = head.next
        while l2 != None:
            val = (l2.val + carry)%10
            carry = (l2.val + carry)/10
            l2 = l2.next
            head.next = ListNode(val)
            head = head.next
        if carry == 1:
            head.next = ListNode(1)
            head = head.next
        return result.next
