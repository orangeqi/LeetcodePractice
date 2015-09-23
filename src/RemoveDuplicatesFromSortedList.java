
public class RemoveDuplicatesFromSortedList {

	/** 83 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(3);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		ListNode head = deleteDuplicates(l1);
		
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * 
	 * For example,
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 * 
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
	// Solution 1 324 ms
	public static ListNode deleteDuplicates(ListNode head){
		if (head == null || head.next == null)
			return head;
		
		ListNode pt1 = head;
		ListNode pt2 = head.next;
		
		
		while (pt2 != null){
			if (pt1.val == pt2.val){
				pt1.next = pt2.next;
				pt2 = pt2.next;
			}
			else{	
				pt1 = pt1.next;
				pt2 = pt2.next;
			}
		}
		
		return head;
	}

}
