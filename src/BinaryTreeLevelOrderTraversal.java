import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {

	/** 102 E
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		TreeNode left2 = new TreeNode(4);
		root.left = left;
		root.right = right;
		left.left = left2;
		
		System.out.println(levelOrder_1(root));
	}
	
	/**
	 * Given a binary tree, return the level order traversal 
	 * of its nodes' values. (ie, from left to right, level by level).
	 * 
	 * For example:
	 * Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
	* return its level order traversal as:
		[
		  [3],
		  [9,20],
		  [15,7]
		]
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 * 
	 * @param root
	 * @return
	 */
	// Solution 1 316 ms
	public static ArrayList<ArrayList<Integer>> levelOrder_1(TreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		level_helper(res, 0, root);
		return res;
	}
	
	private static void level_helper(ArrayList<ArrayList<Integer>> res, int level, TreeNode root){
		if (root == null)
			return;
		
		if (res.size() == level){
			res.add(new ArrayList<Integer>());
		}
		res.get(level).add(root.val);
		
		level_helper(res, level+1, root.left);
		level_helper(res, level+1, root.right);
	}
	
	// Solution 2 320 ms
	//Reference: https://leetcode.com/discuss/35552/share-my-clean-and-easy-java-solution
	 public ArrayList<ArrayList<Integer>> levelOrder_2(TreeNode root) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	       if(root == null){
	          return result;
	       }

	       Queue<TreeNode> queue = new LinkedList<TreeNode>();
	       queue.offer(root);

	       int curL = 0;
	       while(!queue.isEmpty()){
	           ArrayList<Integer> levelRs = new ArrayList<Integer>(); 
	           curL = queue.size();
	           for(int i=0;i<curL;i++){
	               TreeNode peek = queue.poll();
	               levelRs.add(peek.val);
	               if(peek.left!=null){
	                   queue.offer(peek.left);
	               }
	               if(peek.right!=null){
	                   queue.offer(peek.right);
	               }
	           }
	           result.add(levelRs);
	       }

	       return result;
	   }  
}
