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

		// find the part to be rotated
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		while (k > 1) {
			// 保证 (dummy, head] 之间有K个node，并且这K个node是需要rotate到list前面去的
			head = head.next;
			k = k - 1;
		}
		// [dummy.next, head] 是rotate 区间
		ListNode prev = dummy;
		while (head.next != null) {
			head = head.next;
			prev = prev.next;
		}

		// [prev.next, head] 是需要rotate的节点
		// do the rotation by reassign pointers
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
