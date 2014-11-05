// basic reverse
public ListNode reverse(ListNode head) {
    ListNode previous = null;
    while (head != null) {
        ListNode temp = head.next;
        head.next = previous;
        previous = head;
        head = temp;
    }
    return previous;
}

// range reverse
public ListNode reverseBetween(ListNode head, int m, int n) {
    // because current head is not alway the head of the result, use dummy.next to store the ture head of result
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // outStart.next point to the end of the range
    // outEnd is the pointing node of inEnd
    // inStart is the end of the range
    // inEnd is the begin of the range, it's next is the outEnd
    // edge case: outStart is dummy, outEnd is null, inStart is head, inEnd is tail
    ListNode outStart = dummy, outEnd = null, inStart = null, inEnd = null;
    int index = 1;
    while (index < m) {
        head = head.next;
        outStart = outStart.next;
        index++;
    }
    inEnd = head;
    ListNode previous = null;
    // reverse the range
    while (index <= n) {
        ListNode temp = head.next;
        head.next = previous;
        previous = head;
        head = temp;
        index++;
    }
    outEnd = head;
    inStart = previous;
    outStart.next = inStart;
    inEnd.next = outEnd;
    return dummy.next;
}


// another funny way
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null) return head;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode outStart = newhead;
        int k = 1;
        while(k++<m) outStart = outStart.next;
        ListNode inEnd = outStart.next;
        ListNode cur = inEnd;
        // move the next pointer with the cursor
        while(m++<n) {
            cur = inEnd.next;
            inEnd.next = cur.next;
            cur.next = outStart.next;
            outStart.next = cur;
        }
        return newhead.next;
    }
