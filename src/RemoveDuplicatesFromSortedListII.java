
public class RemoveDuplicatesFromSortedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(2);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		ListNode head = deleteDuplicates(l3);
		//1,1 // 1,1,2 //1,1,2,2 //1,2 // 1,2,2,3
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	/**
	 * Given a sorted linked list, delete all nodes that have duplicate 
	 * numbers, leaving only distinct numbers from the original list.
	 * 
	 * For example,
	 * Given 1->2->3->3->4->4->5, return 1->2->5.
	 * Given 1->1->1->2->3, return 2->3.
	 * 
	 * @param head
	 * @return
	 */
	// Solution 1 308 ms
	// Reference: https://leetcode.com/discuss/37254/java-remove-duplicates-from-sorted-list-ii
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode p = dummy;
	    
	    // know three contiguous numbers each time
	    while(p.next != null && p.next.next != null){
	        if(p.next.val != p.next.next.val){
	            p = p.next;
	        }else{
	        	// given {1,1,1,2,3,4} p.next->1 after else statement p.next->2
	            while(p.next.next != null && p.next.val == p.next.next.val){
	                p.next.next = p.next.next.next;
	            }
	            p.next = p.next.next;
	            // p.next is dummy.next
	        }
	    }

	    return dummy.next;
    }
}
