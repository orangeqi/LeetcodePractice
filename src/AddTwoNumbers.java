
public class AddTwoNumbers {

	/** 2 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1_1 = new ListNode(8);
		ListNode l1_2 = new ListNode(9);
		ListNode l1_3 = new ListNode(5);
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		
		ListNode l2_1 = new ListNode(5);
		ListNode l2_2 = new ListNode(9);
		ListNode l2_3 = new ListNode(5);
		l2_1.next = l2_2;
		l2_2.next = l2_3;
		
		ListNode sum = addTwoNumbers_1(l1_3, l2_3);
		
//		while(l1_1.next != null){
//			System.out.println(l1_1.val);
//			l1_1 = l1_1.next;
//		}
//		System.out.println(l1_1.val);
		
		while (sum != null){
			System.out.println(sum.val);
			sum = sum.next;
		}
	}
	
	/**
	 * You are given two linked lists representing two 
	 * non-negative numbers. The digits are stored in 
	 * reverse order and each of their nodes contain a 
	 * single digit. Add the two numbers and return it 
	 * as a linked list.
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
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
	
	// Solution 1 444 ms
	public static ListNode addTwoNumbers_1(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) return null;
		
		int carryon = 0, sum = 0;
		ListNode pre = null, head = null;
		while (l1 != null || l2 != null){
			ListNode cur;
			if (l1 == null){
				sum = l2.val + carryon;
				cur = new ListNode(sum%10);
				l2 = l2.next;
			}
			else if (l2 == null){
				sum = l1.val + carryon;
				cur = new ListNode(sum%10);
				l1 = l1.next;
			}
			else {
				sum = l1.val + l2.val + carryon;
				cur = new ListNode(sum%10);
				l1 = l1.next;
				l2 = l2.next;
			}
			carryon = sum >= 10 ? 1 : 0;
			if (pre == null) head = cur;
			else pre.next = cur;
			pre = cur;
		}
		if (carryon == 1)
			pre.next = new ListNode(1);
		return head;
	}
	
	// Solution 2 436 ms
	// unequal length => bubble
	// carry on (at tail), only one number in the list
	public static ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
		ListNode sumpre = null, head = null;
		ListNode bubble = new ListNode(0);
		int carryon = 0, sum;
		
        while(l1.next != null || l2.next != null){
        	sum = l1.val + l2.val + carryon;
        	ListNode sumcur = new ListNode(sum%10);
        	carryon = (sum)>9 ? 1:0;
        	if (sumpre != null)
        		sumpre.next = sumcur;
        	else 
        		head = sumcur;
        	sumpre = sumcur;
        	if (l1.next == null)
        		l1 = bubble;
        	else
        		l1 = l1.next;
        	if (l2.next == null)
        		l2 = bubble;
        	else
        		l2 = l2.next;
        }
        sum = l1.val + l2.val + carryon;
        ListNode sumcur = new ListNode(sum%10);
        if (sumpre != null) {
        	sumpre.next = sumcur;
        	if (sum > 9){
            	ListNode sumtail = new ListNode(1);
            	sumcur.next = sumtail;
            }
        	return head;
        }
        else {
        	if (sum > 9){
            	ListNode sumtail = new ListNode(1);
            	sumcur.next = sumtail;
            }
        	return sumcur;
        }
    }
}
