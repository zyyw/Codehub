/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
