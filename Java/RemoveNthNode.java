// keep two curs, take care of deleting the head node
public ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 0;
    ListNode fast = head, slow = null;
    while (fast.next != null) {
        fast = fast.next;
        count++;
        if (count < n)
            continue;
        else if (count == n)
            slow = head;
        else
            slow = slow.next;
    }
    if (count == n - 1)
        return head.next;
    if (slow != null)
        slow.next = slow.next.next;
    return head;
}
