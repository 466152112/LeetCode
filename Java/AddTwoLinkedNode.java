// iterative, one pass
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null && l2 == null)
        return null;
    if (l1 == null || l2 == null)
        return (l1 == null)? l2: l1;
    
    int sum = l1.val + l2.val;
    int carry = sum/10;
    sum = sum%10;
    
    ListNode head = new ListNode(sum);
    ListNode move = head;
    l1 = l1.next;
    l2 = l2.next;
    while (l1 != null && l2 != null) {
        sum = l1.val + l2.val + carry;
        carry = sum/10;
        sum = sum%10;
        move.next = new ListNode(sum);
        move = move.next;
        l1 = l1.next;
        l2 = l2.next;            
    }
    while (l1 != null) {
        sum = l1.val + carry;
        carry = sum/10;
        sum = sum%10;
        move.next = new ListNode(sum);
        move = move.next;
        l1 = l1.next;
    }
    while (l2 != null) {
        sum = l2.val + carry;
        carry = sum/10;
        sum = sum%10;
        move.next = new ListNode(sum);
        move = move.next;
        l2 = l2.next;
    }
    if (carry == 1)
        move.next = new ListNode(1);
    return head;
}
