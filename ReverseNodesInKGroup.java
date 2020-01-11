/**
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5

Note:
Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.
*/

public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k < 2) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (head != null) {
      // 1. count k nodes
      ListNode cur = head;
      int cnt = 1;
      while (cur.next != null && cnt < k) {
        cur = cur.next;
        ++cnt;
      }
      if (cnt < k) {
        break;
      }

      // 2. reverse k nodes
      ListNode head2 = cur.next;
      cur.next = null;
      tail.next = reverse(head)
      tail = head;
      head = head2;
    }
    tail.next = head;

    // return
    return dummy.next;
  }

  public ListNode reverse(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode node = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return node;
  }
}
