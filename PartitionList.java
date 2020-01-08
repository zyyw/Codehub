class Solution {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy1 = new ListNode(0);
		ListNode tail1 = dummy1;
		ListNode dummy2 = new ListNode(0);
		ListNode tail2 = dummy2;
		
		// iterate the list and partition it
		while (head != null) {
			if (head.val < x) {
				tail1.next = head;
				tail1 = tail1.next;
			} else {
				tail2.next = head;
				tail2 = tail2.next;
			}
			head = head.next;
		}
		tail2.next = null;
		tail1.next = dummy2.next;
		return dummy1.next;
	}
}
