

class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {

        Node curr = head;

        while (curr != null) {

            Node next = curr.next;   // Save next node

            if (curr.data == x) {

                // If deleting the head
                if (curr.prev == null) {
                    head = curr.next;
                    if (head != null)
                        head.prev = null;
                }
                else {
                    curr.prev.next = curr.next;
                }

                // If not the last node
                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
            }

            curr = next;
        }

        return head;
    }
}
