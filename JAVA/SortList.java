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
		// set fast to the next of head, so that the middle is the first one in even size situations
		// which is very important to split the list half by half
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
		// just set the tail to the begining of the rest, that's enough
		if (left != null) {
			tail.next = left;
		}
		else if (right != null) {
			tail.next = right;
		}
		return head.next;
	}
}
