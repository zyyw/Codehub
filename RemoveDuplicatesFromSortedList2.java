class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tail = dummy;
		while (head != null && head.next != null) {
			while (head.val == head.next.val) {
				head = head.next;
				if (head.next == null) {
					break;
				}
			}
			if (tail.next == head) {
				// no duplicate
				tail = tail.next;
				head = head.next;
			} else {
				// has duplicate
				tail.next = head.next;
				head = head.next;
			}
		}
		return dummy.next;
	}
}
