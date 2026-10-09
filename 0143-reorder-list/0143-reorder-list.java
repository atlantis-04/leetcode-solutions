
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode e = reverseList(slow.next);
        slow.next = null;

        // Step 3: Merge both halves
        ListNode s = head;

        while (e != null) {
            ListNode next1 = s.next;
            ListNode next2 = e.next;

            s.next = e;
            e.next = next1;

            s = next1;
            e = next2;
        }
    }
}
