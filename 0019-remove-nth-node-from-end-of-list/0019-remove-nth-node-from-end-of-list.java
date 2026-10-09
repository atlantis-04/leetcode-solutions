
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode temp = head;
        int length = 0;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int index = length - n + 1;

        // If the head needs to be removed
        if (index == 1) {
            return head.next;
        }

        ListNode temp2 = head;
        int count = 1;

        // Reach the node before the node to delete
        while (count < index - 1) {
            temp2 = temp2.next;
            count++;
        }

        temp2.next = temp2.next.next;

        return head;
    }
}
