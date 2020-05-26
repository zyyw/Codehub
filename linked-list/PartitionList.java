/*
	Given a linked list and a value x, partition it such that
	all nodes less than x come before nodes greater than or equal to x.

	You should preserve the original relative order of the nodes
	in each of the two partitions.

	Example:
	Input: head = 1->4->3->2->5->2, x = 3
	Output: 1->2->2->4->3->5
*/
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
