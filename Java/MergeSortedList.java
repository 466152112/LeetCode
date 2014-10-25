// recursive
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null)
        return null;
    else if (l1 == null || l2 == null)
        return l1 == null?l2:l1;
    else {
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l2,l1.next);
            return l1;
        }
        l2.next = mergeTwoLists(l1,l2.next);
        return l2;
    }
}


public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null)
        return null;
    else if (l1 == null || l2 == null)
        return l1 == null?l2:l1;
    else {
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
                temp = temp.next;                     
        }
        if (l1 != null) 
            temp.next = l1;
        else
            temp.next = l2;
        return result.next;
    }
}
