class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (head != null && head.next != null) {
			ListNode p = head;
			ListNode q = head.next;
			head = head.next.next;
			tail.next = q;
			tail.next.next = p;
			tail = p;
		}
		tail.next = head;
		return dummy.next;
	}

	// solution2
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (head != null && head.next != null) {
			// 1 -> 2 -> 3 -> 4
			tail.next = head.next;
			head.next = head.next.next;
			tail.next.next = head;  // don't forget this step
			tail = head;
			head = head.next;
		}
		tail.next = head;
		return dummy.next;
	}
}
