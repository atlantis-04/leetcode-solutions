class Solution {

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode temp = head;

        while (temp != null && temp.next != null) {

            ListNode agla = temp.next;

            int value = gcd(temp.val, agla.val);

            ListNode gcdNode = new ListNode(value);

            temp.next = gcdNode;
            gcdNode.next = agla;

            temp = agla;
        }

        return head;
    }
}