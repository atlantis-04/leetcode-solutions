class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1)
            return null;

        ListNode temp1 = head;
        ListNode temp2 = head;

        int count = 1;
        while (temp1.next != null) {
            count++;
            temp1 = temp1.next;
        }

        if (n == count)
            return head.next;

        int pos = 1;
        while (pos != count - n) {
            pos++;
            temp2 = temp2.next;
        }

        temp2.next = temp2.next.next;

        return head;
    }
}