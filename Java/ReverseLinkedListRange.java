// similar with reverse m t on linked list, instead, reverse it repeatly
// make use of inEnd, outStart, etc...
// review them together, take care
public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null || k < 2)
        return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy, fast = head;
    int steps = getLength(head)/k;
    for (int i = 0; i < steps; i++) {
        int count = k;
        ListNode outEnd = slow, inStart = fast;
        while(count-- > 0) {
            ListNode temp = fast.next;
            fast.next = slow;
            slow = fast;
            fast = temp;
        }
        outEnd.next = slow;
        inStart.next = fast;
        if (i == 0)
            dummy.next = slow;
        slow = inStart;       
    }
    return dummy.next;
}
private int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
        head = head.next;
        length++;
    }
    return length;
}
