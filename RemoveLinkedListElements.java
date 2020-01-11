/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 public class RemoveLinkedListElements {
   public ListNode removeElements(ListNode head, int val) {
     ListNode dummy = new ListNode(0);
     dummy.next = head;
     ListNode prev = dummy;
     while (prev.next != null) {
       if (prev.next.val == val) {
         // remove this node
         prev.next = prev.next.next;
       } else {
         prev = prev.next;
       }
     }

     return dummy.next;
   }
 }
