/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode reverseLinkedList(ListNode head) {
        ListNode next = head, upcoming, previous = null;

        while (next != null) {
            upcoming = next.next;
            next.next = previous;
            previous = next;
            next = upcoming;
        }

        return previous;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode head1 = head, head2;
        ListNode current = head;

        for (int i = 0; i < k-1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) return head;
        
        head2 = current.next;
        current.next = null;

        head1 = reverseLinkedList(head1);
        head2 = reverseKGroup(head2, k);
        head.next = head2;
        
        return head1;
    }
}
