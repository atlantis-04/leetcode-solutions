/* Structure of Doubly Linked List
class Node {
	int data;
	Node next;
	Node prev;
	
	Node(int x) {
		data = x;
		next = null;
		prev = null;
	}
}
*/
// class Solution {
// 	static void remove(Node temp, Node head, int x) {
// 		if (head == null || head.data == x)
// 			return;
// 		// if(temp.val == x){
// 		if (temp.next != null && temp.prev != null) {
// 			temp.prev.next = temp.next;
// 			temp.next.prev = temp.prev;
// 		}
// 		if (temp.next == null) {
// 			temp.prev.next = null;
// 		}
// 		else if (temp.prev == null) {
// 			head = head.next;
// 		}
// 		// }
// 	}
// 	static Node deleteAllOccurOfX(Node head, int x) {
// 		// code here
// 		Node temp = head;
// 		while (temp != null) {
// 		    if(temp.data == x){
// 		        remove(temp,head,x);
		        
// 		    }
// 			temp = temp.next;
			
// 		}
// 		return head;
// 	}
// }

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
