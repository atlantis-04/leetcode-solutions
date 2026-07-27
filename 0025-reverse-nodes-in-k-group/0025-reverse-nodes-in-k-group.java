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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode start = head;
        ListNode end = head;
        ListNode prevTail = null;
        ListNode newHead = null;

        while (start != null) {

            // Move end to kth node
            end = start;
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }

            // Less than k nodes left
            if (end == null) {
                if (prevTail != null)
                    prevTail.next = start;
                break;
            }

            ListNode nextGroup = end.next;

            // Reverse current group
            reverse(start, end);

            // First reversed group
            if (newHead == null)
                newHead = end;

            // Connect previous group
            if (prevTail != null)
                prevTail.next = end;

            // Current start becomes tail after reversal
            start.next = nextGroup;
            prevTail = start;

            // Move to next group
            start = nextGroup;
        }

        return newHead == null ? head : newHead;
    }

    private void reverse(ListNode start, ListNode end) {
        ListNode prev = end.next;
        ListNode curr = start;

        while (prev != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}