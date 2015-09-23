
public class MergeTwoSortedLists {

	/** 21 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		ListNode l1_1 = new ListNode(1);
		ListNode l1_2 = new ListNode(2);
		ListNode l1_3 = new ListNode(5);
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		
		ListNode l2_1 = new ListNode(3);
		ListNode l2_2 = new ListNode(4);
		ListNode l2_3 = new ListNode(6);
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		
		ListNode merge = mergeTwoLists_1(l1_2, l2_1);
		while (merge.next != null){
			System.out.println(merge.val);
			merge = merge.next;
		}
		System.out.println(merge.val);
		
	}
	
	/**
	 * Merge two sorted linked lists and return it as a new list. 
	 * The new list should be made by splicing together the nodes 
	 * of the first two lists.
	 * 
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 *
	 * @param l1
	 * @param l2
	 * @return
	 */
	
	// Solution 1 356 ms
	public static ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode min = head;
		while(l1 != null || l2 != null){
			if (l1 == null) {
				min.next = l2;
				l2 = l2.next;
			}
			else if (l2 != null && l2.val < l1.val) {
				min.next = l2;
				l2 = l2.next;
			}
			else {
				min.next = l1;
				l1 = l1.next;
			}
			min = min.next;
		}
		return head.next;
	}
	
	// Solution 2 308 ms
	// reference: https://leetcode.com/discuss/42591/a-simple-java-solution-not-using-recursion
	public ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null || l2 != null){
            if (l2 == null){
                temp.next = l1;
                l1 = l1.next;
            }
            else if (l1 == null || l1.val > l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else{
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        return head.next;
    }
	
	
	// return a new list 296 ms
	public static ListNode mergeTwoLists_3(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		ListNode pre = null, head = null, min;
		boolean unbalance = false;
		min = l1.val < l2.val ? l1 : l2;
		while(l1.next != null || l2.next != null){
			ListNode cur = new ListNode(min.val);
			if (pre != null) 
				pre.next = cur;
			else
				head = cur;
			pre = cur;
			if (l1.val < l2.val)
				if (l1.next != null){
					l1 = l1.next;
					min = l1.val < l2.val ? l1 : l2;
				}
				else {
					min = l2;
					unbalance = true;
					break;
				}
			else 
				if (l2.next != null) {
					l2 = l2.next;
					min = l1.val < l2.val ? l1 : l2;
				}
				else {
					min = l1;
					unbalance = true;
					break;
				}
		}
		if (pre != null){
			while (min.next != null){
				ListNode cur = new ListNode(min.val);
				pre.next = cur;
				pre = cur;
				min = min.next;
			}
			pre.next = new ListNode(min.val);
		}

		if (!unbalance){
			ListNode cur = new ListNode(min.val);
			if (pre != null)
				pre.next = cur;
			else 
				head = cur;
			min = l1.val > l2.val ? l1 : l2;
			cur.next = new ListNode(min.val);
		}
		
		return head;
	}
}
