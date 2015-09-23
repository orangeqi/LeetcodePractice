
public class SwapNodesInPairs {

	/** 24 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1_1 = new ListNode(1);
		ListNode l1_2 = new ListNode(2);
		ListNode l1_3 = new ListNode(3);
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		
		ListNode l2_1 = new ListNode(4);
		ListNode l2_2 = new ListNode(5);
		ListNode l2_3 = new ListNode(6);
		l1_3.next = l2_1;
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		
//		ListNode head = l1_1;
//		while (head != null){
//			System.out.println(head.val);
//			head = head.next;
//		}
		
		ListNode result = swapPairs(l2_1);
		
		while (result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}
	
	/**
	 * Given a linked list, swap every two adjacent nodes 
	 * and return its head.
	 * 
	 * For example,
	 * Given 1->2->3->4, you should return the list as 2->1->4->3.
	 * 
	 * Your algorithm should use only constant space.
	 * You may not modify the values in the list, 
	 * only nodes itself can be changed.
	 * 
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 * 
	 * @param head
	 * @return
	 */
	// Solution 1 316 ms
	public static ListNode swapPairs(ListNode head) {
		if (head == null) return null;
		ListNode newHead;
        if (head.next != null)
        	newHead = head.next;
        else return head;
        ListNode pre = null;
		ListNode cur = head;
        ListNode nex = null;
       
        while (cur != null && cur.next != null){
        	nex = cur.next;
        	cur.next = cur.next.next;
        	nex.next = cur;
        	if (pre != null)
        		pre.next = nex;
        	pre = cur;
        	cur = cur.next;
        }
        return newHead;
    }
}
