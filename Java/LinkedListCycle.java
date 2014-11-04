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
