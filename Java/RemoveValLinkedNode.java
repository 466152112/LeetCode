// dummy and fast and slow cursor
public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(Integer.MIN_VALUE);
    dummy.next = head;
    ListNode fast = head, slow = dummy;
    while (fast != null) {
        if (fast.val == val)
            slow.next = fast.next;
        else
            slow = slow.next;
        fast = fast.next;
    }
    return dummy.next;
}
