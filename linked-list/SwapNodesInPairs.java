/*
	Given a linked list, swap every two adjacent nodes and return its head.
	You may not modify the values in the list's nodes, only nodes itself may be changed.

	Example:
	Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
      return head;
    }

    // 1->2->3->4
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode tail = dummy;
    while (head != null && head.next != null) {
			// 这里的关键是：担心丢掉某个节点的引用，所以先用几个变量存关键节点的引用！
			// head 指向 1
			// node1 指向 2
			// node2 指向 3
      ListNode node1 = head.next;
      ListNode node2 = head.next.next;
      tail.next = node1;
      node1.next = head;
      head.next = node2;
      tail = head;
      head = node2;
    }

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
