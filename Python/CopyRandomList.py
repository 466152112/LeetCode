# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        if head == None:
            return None
        dummy = RandomListNode(-1)
        dummy.next = head
        # deep copy labels
        while head != None:
            newNode = RandomListNode(head.label)
            # associate the newNode to the original list
            tmp = head.next
            head.next = newNode
            newNode.next = tmp
            head = tmp
        # deep copy random point
        head = dummy.next
        while head != None:
            if head.random != None:
                head.next.random = head.random.next
            head = head.next.next
        # deep copy next point
        head = dummy.next
        result = head.next
        while head.next.next != None:
            tmp = head.next.next
            head.next.next = tmp.next
            head.next = tmp
            head = tmp
        head.next = None # restore last next pointer
        return result
