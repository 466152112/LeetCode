// keep two cursor, take care of deleting the head node
public ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;
    ListNode fast = head, slow = null;
    while (fast.next != null) {
        fast = fast.next;
        count++;
        // nothing to delete
        if (count < n)
            continue;
        // delete the head
        else if (count == n)
            slow = head;
        // move to the next
        else
            slow = slow.next;
    }
    if (count == n - 1)
        return head.next;
    if (slow != null)
        slow.next = slow.next.next;
    return head;
}

// use a dummy node to point to the head
// move N node first, then move delete cursor
public ListNode removeNthFromEnd(ListNode head, int n) {
    if (n < 1)
        return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    for (int i = 0; i < n; i++) {
        if (head != null)
            head = head.next;
        else
            return dummy.next;
    }
    ListNode preDelete = dummy;
    while (head != null) {
        head = head.next;
        preDelete = preDelete.next;
    }
    preDelete.next = preDelete.next.next;
    return dummy.next;
}
