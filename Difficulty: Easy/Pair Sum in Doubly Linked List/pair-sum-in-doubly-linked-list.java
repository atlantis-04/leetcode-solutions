/* Structure of Doubly Linked List Node
class Node {
	public int data;
	public Node next;
	public Node prev;
	
	public Node(int val) {
		data = val;
		next = null;
		prev = null;
	}
}; */

class Solution {
	public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
		// code her
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		if (head == null)
			return ans;
		
		Node left = head;
		Node right = head;
		
		// Move right to the last node
		while (right.next != null) {
			right = right.next;
		}
		
		while (left != right && left.prev != right) {
			int sum = left.data + right.data;
			
			if (sum == target) {
				ArrayList<Integer> pair = new ArrayList<>();
				pair.add(left.data);
				pair.add(right.data);
				ans.add(pair);
				
				left = left.next;
				right = right.prev;
			}
			else if (sum < target) {
				left = left.next;
			}
			else {
				right = right.prev;
			}
		}
		
		return ans;
	}
}
