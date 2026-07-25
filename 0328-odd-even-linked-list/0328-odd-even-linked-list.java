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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode evenHead = null, evenTail = null;
        ListNode oddHead = null, oddTail = null;

        ListNode current = head;
        int index = 1;

        while (current != null) {

            ListNode next = current.next; // Save next node

            if (index % 2 == 0) {

                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }

            } else {

                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            }

            current = next;
            index++;
        }

        if (evenHead == null)
            return oddHead;

        if (oddHead == null)
            return evenHead;

        oddTail.next = evenHead;
        evenTail.next = null;

        return oddHead;
    }
}