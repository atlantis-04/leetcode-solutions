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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        int carry = 0; // This stores carry if sum >= 10

        // Traverse both linked lists
        while (l1 != null || l2 != null) {
            // Get values from l1 and l2 if available, else use 0
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Add the two values and the carry
            int sum = val1 + val2 + carry;

            // Update carry for next addition
            carry = sum / 10;

            // Create new node for the current digit
            current.next = new ListNode(sum % 10);

            // Move current to next
            current = current.next;

            // Move l1 and l2 to next nodes (if they exist)
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If carry is left at the end, create a new node for it
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        // The first node is dummy, so return next
        return dummyHead.next;
    }
}