
public class RemoveNthNodeFromEndOfList {

	/** 19 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given a linked list, remove the nth node from the end 
	 * of list and return its head.
	 * 
	 * For example,
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * After removing the second node from the end, the linked list becomes 1->2->3->5.
	 * 
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	// Solution 1 324 ms
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		  if (head == null)
			  return head;
		  
	      ListNode pt0 = new ListNode(0);
	      pt0.next = head;
	      ListNode pt1 = pt0;
	      for (int i = 0; i < n; i++){
	    	  // if (pt1 == null) return null;
    		  pt1 = pt1.next;
    	  }
	      
	      if (pt1.next == null)
	    	  return head.next;
	      
	      while(pt1.next != null){
	    	  pt1 = pt1.next;
	    	  pt0 = pt0.next;
	      }
	      pt0.next = pt0.next.next;
	      return head;
	      
	}
}
