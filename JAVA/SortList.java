public class SortList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(7);
		ListNode move = head;
		int seed;
		for(seed = 14; seed > 0 ; seed--) {
			ListNode tmp = new ListNode(seed);
			move.next = tmp;
			move = move.next;
		}
		
		Solution a = new Solution();
		move = a.sortList(head);
		head = move;
		while(head != null) {
			System.out.println(head.val);
			head = head.next;
		}
		
	}

	
}
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Solution {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMid(head);
		ListNode right, left;
		right = sortList(mid.next);
		mid.next = null;
		left = sortList(head);
		head = merge(left, right);
		return head;
	}

	// find the middle of the linked list
	private ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// merge sort the two linked list
	private ListNode merge(ListNode left, ListNode right) {
		ListNode head = new ListNode(0);
		ListNode tail = head;
		while (left != null && right != null) {
			if (left.val < right.val) {
				tail.next = left;
				left = left.next;
			} else {
				tail.next = right;
				right = right.next;
			}
			tail = tail.next;
		}
		while (left != null) {
			tail.next = left;
			left = left.next;
			tail = tail.next;
		}
		while (right != null) {
			tail.next = right;
			right = right.next;
			tail = tail.next;
		}
		return head.next;
	}
}