// if n is large than length , mod it
public ListNode rotateRight(ListNode head, int n) {
    if (head == null)
        return head;
    n = n % getLength(head);
    if (n == 0)
        return head;
    ListNode fast = head;
    ListNode slow = head;
    while (n > 0) {
        // no need to check fast == null, we grantee that n < length
        fast = fast.next;
        n--;
    }
    while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
    }
    ListNode result = slow.next;
    slow.next = null;
    fast.next = head;
    return result;
}

private int getLength(ListNode head) {
    int result = 0;
    while (head != null) {
        result++;
        head = head.next;
    }
    return result;
}
