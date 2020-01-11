/*
You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/

public class AddTwoNumbers2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    l1 = reverse(l1);
    l2 = reverse(l2);
    ListNode head = addTwoNumbersHelper(l1, l2);
    return reverse(head);
  }

  public ListNode reverse(ListNode head) {
    if (head == null ||  head.next == null) {
      return head;
    }
    ListNode node = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return node;
  }

  public ListNode addTwoNumbersHelper(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    int carry = 0;
    int base = 10;
    int sum = 0;
    while (l1 != null && l2 != null) {
      sum = carry + l1.val + l2.val;
      tail.next = new ListNode(sum % base);
      tail = tail.next;
      carry = sum / base;
      l1 = l1.next;
      l2 = l2.next;
    }
    while (l1 != null) {
      sum = carry + l1.val;
      tail.next = new ListNode(sum % base);
      tail = tail.next;
      carry = sum / base;
      l1 = l1.next;
    }
    while (l2 != null) {
      sum = carry + l2.val;
      tail.next = new ListNode(sum % base);
      tail = tail.next;
      carry = sum / base;
      l2 = l2.next;
    }
    if (carry > 0) {
      tail.next = new ListNode(carry);
    }

    // return
    return dummy.next;
  }
}
