/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
*/

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    // 1. 快慢指针取出 list 后半段
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode head2 = slow.next;
    slow.next = null;

    // 2. reverse 取出来的 list 后半段
    head2 = reverse(head2);

    // 3. 同步比较前半段和 reverse 后的后半段
    while (head2 != null) {
      if (head.val != head2.val) {
        return false;
      }
      head = head.next;
      head2 = head2.next;
    }

    return true;
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
