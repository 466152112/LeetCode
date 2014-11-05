public class Solution {
  public void reorderList(ListNode head) {
      if (head == null)
          return;
      // the first two functions have return values
      ListNode mid = halfTheList(head);
      mid = reverse(mid);
      // this one doesn't have return value
      merge(head, mid);
  }
  
  private ListNode reverse(ListNode head) {
      ListNode previous = null;
      // reverse you need keep track of the previous and the next
      while (head != null) {
          ListNode next = head.next;
          head.next = previous;
          previous = head;
          head = next;
      }
      return previous;
  }
  
  // get the mid of linked list, set the end of the first half to null
  private ListNode halfTheList(ListNode head) {
      // when use fast and slow, think about the first mid or the second mid you want
      // in this case, we need the first mid, because we should set the next to null (also return the next as the second half)
      ListNode fast = head.next, slow = head, mid = null;
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
      }
      // return the node after the mid
      mid = slow.next;
      slow.next = null;
      return mid;
  }
  
  private void merge(ListNode one, ListNode two) {
      while (two != null) {
          ListNode temp1 = one.next, temp2 = two.next;
          one.next = two;
          two.next = temp1;
          one = temp1;
          two = temp2;
      }
  }
}
