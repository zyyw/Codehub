/**

Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 类似题：
 * LC234, Palindrome linked list
 */

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		// 1. 快慢指针取出后半段 list
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode head2 = slow.next;
		slow.next = null;

		// 2. reverse 后半段 list
		head2 = reverse(head2);

		// 3. interplace reverse 后的后半段 list 进前半段list
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (head2 != null) {
			tail.next = head;
			head = head.next;
			tail.next.next = head2;
			head2 = head2.next;
			tail = tail.next.next;
		}
		if (head != null) {
			tail.next = head;
		}
	}

	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
   	}
}
