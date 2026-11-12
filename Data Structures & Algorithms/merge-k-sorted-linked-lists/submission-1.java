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
    
   

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }

        ListNode main = new ListNode();
        ListNode current = main;


        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();

            current.next = smallest;
            current = current.next;

            if (smallest.next != null) heap.add(smallest.next);
        }

        return main.next;
    }
}
