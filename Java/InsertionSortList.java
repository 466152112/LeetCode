// one pass, DP recursive, assume the next node has been sorted, insert current head into the list
public ListNode insertionSortList(ListNode head) {
    ListNode result = head;        
    if (head == null || head.next == null)
        return result;
    ListNode start = insertionSortList(head.next);
    if (head.val <= start.val) {
        head.next = start;
    }
    else {
        result = start;
        while (start.next != null && start.next.val < head.val) {
            start = start.next;
        }
        ListNode temp = start.next;
        start.next = head;
        head.next = temp;
    }
    return result;
}
