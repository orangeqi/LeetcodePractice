
public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		ListNode head = reverseList_2(l4);
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	/**
	 * Reverse a singly linked list.
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
	// Solution 1 340 ms
    public static ListNode reverseList_1(ListNode head) {
    	if (head == null || head.next == null) return head;
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode cur = head;

        while (cur.next != null){ 
        	ListNode temp1 = cur.next.next;
        	ListNode temp2 = dummy.next;
        	dummy.next = cur.next; 
        	cur.next.next = temp2;
        	cur.next = temp1;
        }
        
        return dummy.next;
    }
    
    // Solution 2 280 ms
    // Reference: https://leetcode.com/discuss/48668/my-seven-line-iterative-java-solution
    public static ListNode reverseList_2(ListNode head) {
       ListNode newHead = null;
	   //iterative
       // cut off each node and link it to the current head
	   while(head != null){
	       ListNode tmp = head;
	       head = head.next;
	       tmp.next = newHead;
	       newHead = tmp;
	   }
	   return newHead; 
    }

}
