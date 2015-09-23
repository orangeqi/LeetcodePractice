
public class ReverseLinkedListII {

	/** 92 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(1);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		
		ListNode head = reverseBetween_1(l4, 2, 3);
		// 1(2) // 3,1(2) // 1,1(2)
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	/**
	 * Reverse a linked list from position m to n. 
	 * Do it in-place and in one-pass.
	 * 
	 * For example:
	 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note:
	 * Given m, n satisfy the following condition:
	 * 1 <= m <= n <= length of list.
	 * 
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 * 
     * @param head
     * @param m
     * @param n
     * @return
     */
	// Solution 268 ms
    public static ListNode reverseBetween_1(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null) 
        	return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int start = m;
        while (start > 1){
        	dummy = dummy.next;
        	start--;
        }
        
        ListNode pt1 = dummy.next;
        
        ListNode pt3 = pt1.next;
        int end = n-m;
        while (end > 0){
        	pt3 = pt3.next;
        	end--;
        }
        
        ListNode front = pt3;
        while (pt1 != pt3){
        	ListNode pt2 = pt1;
        	pt1 = pt1.next;
        	pt2.next = front;
        	front = pt2;
        }
        
        dummy.next = front;
        if (m == 1) return front;
        return head;
    }
    
    // Solution 2 268 ms
    // Reference : https://leetcode.com/discuss/35440/240ms-java-solution
    public static ListNode reverseBetween_2(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy; //pre is the node before orignal M
        ListNode M=head;    //M is after pre

        for(int i=1;i<m;i++){ //Move pre and M to orignal place
            pre=pre.next;
            M=M.next;
        }

        for(int i=0;i<n-m;i++){ 
            ListNode current=M.next; //Both pre and M are all fixed, only current is assigned every time to M.next. M is pushed back everytime
            M.next=current.next;     //Move current to the position after pre
            current.next=pre.next;
            pre.next=current;
        }

        return dummy.next;
    }

}
