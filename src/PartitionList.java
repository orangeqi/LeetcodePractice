
public class PartitionList {

	/** 86 M
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
		
		ListNode head = partition_2(l5, 2);
		// 1(2) // 3,1(2) // 1,1(2)
		while (head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	/**
	 * Given a linked list and a value x, partition it such that 
	 * all nodes less than x come before nodes greater than or equal to x.
	 * You should preserve the original relative order of the nodes in 
	 * each of the two partitions.
	 * 
	 * For example,
	 * Given 1->4->3->2->5->2 and x = 3,
	 * return 1->2->2->4->3->5.
	 * 
	 * @param head
	 * @param x
	 * @return
	 */
	// Solution 1 308 ms
	public static ListNode partition_1(ListNode head, int x){
		ListNode pt1 = new ListNode(0);
		pt1.next = head;
		while (pt1.next != null && pt1.next.val < x)
			pt1 = pt1.next;
		if (pt1.next == null) return head;
		
		ListNode pt2 = pt1.next;
		while (pt2.next != null){
			if (pt2.next.val >= x){
				pt2 = pt2.next;
			}
			else{
				if (pt1.next == head){
					head = pt2.next;
				}
				ListNode temp1 = pt1.next;
				ListNode temp2 = pt2.next.next;
				pt1.next = pt2.next;
				pt2.next.next = temp1;
				pt2.next = temp2;
				
				pt1 = pt1.next;
			}
		}	
		return head;
	}
	
	// Solution 2 312 ms
	// Reference: https://leetcode.com/discuss/47100/simple-java-solution
	public static ListNode partition_2(ListNode head, int x) {
        ListNode fake1 = new ListNode(0);  
        ListNode fake2 = new ListNode(0);  
        ListNode t1 = fake1;
        ListNode t2 = fake2;

        ListNode n = head;
        while (n!=null){
            if (n.val<x){
                t1.next = n;
                t1 = t1.next;
            }
            else{
                t2.next = n;
                t2 = t2.next;
            }
            n = n.next;
        }
        t2.next = null;
        t1.next = fake2.next;
        return fake1.next;
    }
}
