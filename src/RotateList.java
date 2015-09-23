
public class RotateList {

	/** 61 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;		
		
		ListNode head = rotateRight_1(n1, 2);
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	/**
	 * Given a list, rotate the list to the right by k places, 
	 * where k is non-negative.
	 * 
	 * For example:
	 * Given 1->2->3->4->5->NULL and k = 2,
	 * return 4->5->1->2->3->NULL.
	 * 
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	// Solution 1 348 ms
	public static ListNode rotateRight_1(ListNode head, int k) { 
		if (head == null) return null;
        ListNode pt0 = new ListNode(0);
		pt0.next = head;
		ListNode pt1 = new ListNode(0);
		pt1.next = head;
		
		int count = 0;
		while (pt0.next != null){
			pt0 = pt0.next;
			count++;
		}
		
		k = k%count;
		if (k == 0) return head;
		
		for (int i = 0; i < count - k; i++){
			pt1 = pt1.next;
		}
	
		ListNode newHead = pt1.next;
		pt1.next = null;
		pt0.next = head;
		return newHead;
	}
	
	// Solution 2  308 ms
	 public ListNode rotateRight_2(ListNode head, int k) {
	        if (head == null) return head;
	    k = k % getLen(head);
	    ListNode p1 = new ListNode(0);
	    ListNode p2 = new ListNode(0);
	    p1.next = head;
	    p2.next = head;
	    for (int i = 0; i < k; i++) {
	        p2 = p2.next;
	    }
	    while (p2.next != null) {
	        p1 = p1.next;
	        p2 = p2.next;
	    }
	    p2.next = head;
	    ListNode res = p1.next;
	    p1.next = null;
	    return res;
	}

	private int getLen(ListNode node) {
	    int count = 0;
	    while (node != null) {
	        count++;
	        node = node.next;
	    }
	    return count;
	    }
}
