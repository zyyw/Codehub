class RemoveNthNodeFromEndOfList {
	public ListNode removeNthNodeFromEndOfList(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		while (n > 1 && head.next != null) {
			head = head.next;
			n = n - 1;
		}
		ListNode prev = dummy;
		while (head.next != null) {
			head = head.next;
			prev = prev.next;
		}

		prev.next = prev.next.next;
		return dummy.next;
	}
}
