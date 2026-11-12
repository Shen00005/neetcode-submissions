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
    public boolean areListsNotEmpty(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return true;
            }
        }
        return false;
    }
    public int getIndexOfNextMin(ListNode[] lists) {
        int current_min = - 10001, current_index = -1; 

        for (int i = 0; i < lists.length; i++) {
            if (current_min < -10000 && lists[i] != null) {
                current_min = lists[i].val;
                current_index = i;
            }
            if (current_min < -10000 || lists[i] == null) continue;

            if (current_min > lists[i].val) {
                current_min = lists[i].val;
                current_index = i;
            }
        }
        return current_index;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode main = new ListNode();
        ListNode current = main;
        while (areListsNotEmpty(lists)) {
            int minIndex = getIndexOfNextMin(lists);
            if (minIndex == -1) break;

            current.next = new ListNode(lists[minIndex].val);
            current = current.next;

            lists[minIndex] = lists[minIndex].next;
        }

        return main.next;
    }
}
