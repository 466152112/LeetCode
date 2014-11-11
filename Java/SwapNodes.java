// kinda one pass, except checking next null
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode result = head.next;
    ListNode tail = head.next;
    while (tail.next != null && tail.next.next != null) {
        // swap current pair
        ListNode temp = tail.next;
        tail.next = head;
        head.next = temp.next;
        // go to the next pair
        tail = temp.next;
        head = temp;
    }
    // swap the final pair
    head.next = tail.next;
    tail.next = head;
    return result;
}
