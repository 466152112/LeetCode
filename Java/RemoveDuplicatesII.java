// remove duplicates frequency larger than twice, in the Array
public int removeDuplicates(int[] A) {
    if (A.length < 3)
        return A.length;
    int slow = 0;
    int fast = 2;
    while (fast < A.length) {
        if (A[slow] == A[fast])
            fast++;
        else
            A[++slow + 1] = A[fast++];
    }
    return slow + 2;
}

// remove duplicates numbers at all, in the Linked List
// get stucked in [1,1,2,2] case, oh my gosh, but after drink a cup of water, a brillient idea comes up, i add an else in line 33, accpted!
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null)
        return head;
    // three lines dummy & head exchange
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    // when you check head.next.next, always check head.next first, becaue sometimes you may move two steps ahead inside the loop
    while (head.next != null && head.next.next != null) {
        if (head.next.val == head.next.next.val) {
        	// move to the first one whose value is different with the duplicates
            while (head.next.next != null && head.next.val == head.next.next.val)
                head.next = head.next.next;
            head.next = head.next.next;
        }
        else
            head = head.next;
    }
    return dummy.next;
}

// more efficint way to move cursor over duplicates
public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null)
        return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (head.next != null && head.next.next != null) {
        if (head.next.val == head.next.next.val) {
            int val = head.next.val;
            while (head.next != null && head.next.val == val)
                head.next = head.next.next;
        }
        else
            head = head.next;
    }
    return dummy.next;
}
