/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public int getDifference(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;

        while (headA != null || headB != null) {
            if (headA != null) {
                lenA++;
                headA = headA.next;
            }
            if (headB != null) {
                lenB++;
                headB = headB.next;
            }
        }

        return lenA - lenB;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int diff = getDifference(headA, headB);

        if (diff < 0) {
            while (diff++ != 0) {
                headB = headB.next;
            }
        } else {
            while (diff-- != 0) {
                headA = headA.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}