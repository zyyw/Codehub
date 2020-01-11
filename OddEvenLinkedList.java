/*
Given a singly linked list, group all odd nodes together followed by the even nodes.
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity
and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
*/

public class OddEvenLinkedList {
  public ListNode oddEvenLinkedList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    // 1. 把 odd, even 节点拆开成两个 list
    ListNode dummy1 = new ListNode(0);
    ListNode tail1 = dummy1;
    ListNode dummy2 = new ListNode(0);
    ListNode tail2 = dummy2;
    while (head != null && head.next != null) {
      tail1.next = head;
      tail2.next = head.next;
      head = head.next.next;
      tail1 = tail1.next;
      tail2 = tail2.next;
    }
    if (head != null) {
      tail1.next = head;
      tail1 = tail1.next;
    }
    // tail1.next = null;
    tail2.next = null;

    // 2. 把两个拼成一个 list
    tail1.next = dummy2.next;

    // 3. return
    return dummy1.next;
  }
}
