/**
Write a program to find the node at which the intersection of two singly linked lists begins.

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/
public class IntersectionOfTwoLinkedLists {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }

    Set<ListNode> set = new HashSet<>();
    while (headA != null) {
      set.add(headA);
      headA = headA.next;
    }
    while (headB != null) {
      if (set.contains(headB)) {
        return headB;
      }
      headB = headB.next;
    }

    return null;
  }

  // 不用 HashSet 的解法
  public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
      return null;
    }
    int lenA = getLength(headA);
    int lenB = getLength(headB);
    if (lenA > lenB) {
      headA = advanceToRight(headA, lenA - lenB);
    } else {
      headB = advanceToRight(headB, lenB - lenA);
    }
    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    return headA;
  }

  public int getLength(ListNode head) {
    int len = 0;
    while (head != null) {
      len = len + 1;
      head = head.next;
    }
    return len;
  }

  public ListNode advanceToRight(ListNode head, int offset) {
    while (offset > 0 && head != null) {
      head = head.next;
      offset = offset - 1;
    }
    return head;
  }

  // 解法三：
  public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
    ListNode curA = headA;
    ListNode curB = headB;
    while (curA != null || curB != null) {
      if (curA == curB) {
        return curA;
      }
      curA = (curA == null ? headB : curA.next);
      curB = (curB == null ? headA : curB.next);
    }
    return null;
  }
}
