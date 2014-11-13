// 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head == null || head.next == null)
            return head;
        // get the target location
        ListNode target = getX(head, x);

        while (target!= null && target.next != null) {
            if (target.next.val < x) {
                ListNode temp = target.next;
                target.next = temp.next;
        		// insert the node smaller than target to the front                
                insert(dummy, temp, x);
            }
            else {
                target = target.next;
            }
        }
        return dummy.next;
    }
    
    private void insert(ListNode head, ListNode toDo, int x) {
        while (head.next.val < x) {
            head = head.next;
        }
        ListNode temp = head.next;
        head.next = toDo;
        toDo.next = temp;
    }
    private ListNode getX(ListNode head, int x) {
        while (head != null) {
            if (head.val < x) {
                head = head.next;
            }
            else {
                return head;
            }
        }
        return null;
    }
}
