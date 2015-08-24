class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        if lists == None or len(lists) < 1:
            return None
        while len(lists) > 1:
            first = 0
            last = len(lists) - 1
            while first < last:
                if lists[first] == None:
                    lists.pop(first)
                    last -= 1
                    continue
                if lists[last] == None:
                    lists.pop(last)                    
                    last -= 1
                    continue                
                lists[first] = self.merge_two(lists[first], lists[last])
                first += 1
                last -= 1
                lists.pop(-1)
        return lists[0]

    def merge_two(self, first, last):
        head = ListNode(-1)
        runner = ListNode(-1)
        if first.val <= last.val:
            head.next = first
        else:
            head.next = last
        while first != None and last != None:
            if first.val <= last.val:
                runner.next = first
                runner = first
                first = first.next
            else:
                runner.next = last
                runner = last
                last = last.next
        if first != None:
            runner.next = first
        elif last != None:
            runner.next = last
        return head.next
