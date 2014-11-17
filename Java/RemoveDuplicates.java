/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// remove duplicates in Linked List
public class Solution {
    // use two pointers
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow.val == fast.val) {
                slow.next = fast.next;
                fast = fast.next;
            }
            else {
                slow = fast;
                fast = fast.next;
            }
        }
        return head;
    }
    
    // use one pointer
    public ListNode deleteDuplicates9(ListNode head) {
        if (head == null)
            return head;
        ListNode index = head;
        while ( index.next != null) {
            if (index.val == index.next.val) {
                index.next = index.next.next;
            }
            else {
                index = index.next;
            }
        }
        return head;
    }
}

// remove duplicates in the Array
public int removeDuplicates(int[] A) {
    int len = A.length;
    if (len < 2)
        return len;
    int slow = 0, fast = 1;
    for (; fast < len; fast++) {
        if (A[fast] == A[slow])
            continue;
        A[++slow] = A[fast];
    }
    return slow+1;
}
