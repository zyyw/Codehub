class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		// input sanity check
		if (head == null || head.next == null || k <= 0) {
			return head;
		}

		// get list length
		int len = getListLength(head);
		k = k % len;
		if (k == 0) {
			return head;
		}

		// get prev node
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		while (k > 1) {
			head = head.next;
			k = k - 1;
		}
		ListNode prev = dummy;
		while (head.next != null) {
			head = head.next;
			prev = prev.next;
		}
		
		// reassign next pointer
		head.next = dummy.next;
		dummy.next = prev.next;
		prev.next = null;
		return dummy.next;
	}

	private int getListLength(ListNode head) {
		int ret = 0;
		while (head != null) {
			ret = ret + 1;
			head = head.next;
		}
		return ret;
	}
}
