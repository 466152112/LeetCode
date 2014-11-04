// the stop condition, when you move two nodes one time, take care when to stop
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            // point to next next, will point the a null object
            fast = fast.next.next;
        }
        return false;
    }
    
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null)
        return false;
    // set them to the same start, easy to calculater the distance from head, the SAME start
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        // point to next next, will point the a null object
        fast = fast.next.next;            
        if (slow == fast)
            return true;
    }
    return false;
    }
