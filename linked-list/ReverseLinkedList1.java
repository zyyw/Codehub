class Solution {
	// iteratively
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		while (head.next != null) {
			ListNode node = head.next;
			head.next = node.next;
			node.next = dummy.next;
			dummy.next = node;
		}
		return dummy.next;
	}

	// recursively
	public ListNode reverseList2(ListNode head) {
		// 递归基
		if (head == null || head.next == null) {
			return head;
		}
		ListNode curHead = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return curHead;
	}
}
