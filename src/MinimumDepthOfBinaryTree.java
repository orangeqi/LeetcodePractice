import java.util.ArrayList;


public class MinimumDepthOfBinaryTree {

	/** 111 E
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
		
		System.out.println(minDepth_2(root));
	}
	/**
	 * Given a binary tree, find its minimum depth.
	 * The minimum depth is the number of nodes along 
	 * the shortest path from the root node down to 
	 * the nearest leaf node.
	 * 
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 * @param root
	 * @return
	 */
	
	// Solution 1 recursive 336 ms
	public static int minDepth_1(TreeNode root) {
        if (root == null) return 0;
        
        if (root.left == null) 
        	return 1 + minDepth_1(root.right);
        if (root.right == null) 
        	return 1 + minDepth_1(root.left);
        
        return 1 + Math.min(minDepth_1(root.left), minDepth_1(root.right));
    }

	// Solution 2 recursive 364 ms
	// Reference: https://leetcode.com/discuss/34005/my-recursive-java-solution-255ms
	public static int minDepth_2(TreeNode root) {

	    if(root ==null) return 0;

	    int left = minDepth_1(root.left);
	    int right = minDepth_1(root.right);

	    if(left - right == 0) 
	    	return left + 1;
	    else if(left > 0 && right > 0) 
	    	return Math.min(left,right) + 1;
	    else 
	    	return Math.max(left,right) + 1;
	}
	
	// Solution 3 brute force 356 ms
	// Reference: https://leetcode.com/discuss/43984/java-bfs-solution
	public static int minDepth_3(TreeNode root) {
		if(root == null) return 0;
	    int dep = 1;
	    ArrayList<TreeNode> que = new ArrayList<TreeNode>();
	    que.add(root);
	    while(!que.isEmpty()) {
	        int size = que.size();
	        for(int i = 0; i < size; i++) {
	            TreeNode cur = que.remove(0);
	            if(cur.left == null && cur.right == null) return dep;
	            if(cur.left != null) que.add(cur.left);
	            if(cur.right != null) que.add(cur.right);
	        }
	        dep++;
	    }
	    return dep;
	}
}
