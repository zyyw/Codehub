class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tail= dummy;
		int d = n - m;
		while (m > 1) {
			tail = tail.next;
			m = m - 1;
		}
		ListNode cur = tail.next;
		while (d > 0) {
			ListNode node = cur.next;
			cur.next = node.next;
			node.next = tail.next;
			tail.next = node;
			d = d - 1;
		}
		return dummy.next;
	}
}
