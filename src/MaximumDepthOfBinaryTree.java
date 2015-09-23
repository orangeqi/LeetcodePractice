
public class MaximumDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	// Solution 1 372 ms
    public static int maxDepth_1(TreeNode root) {
    	return maxDep(root, 0);
    }
    
    private static int maxDep(TreeNode root, int dep){
    	if (root == null)
        	return dep;
    	else
    		dep++;
    	
        return Math.max(maxDep(root.left, dep), 
        		maxDep(root.right, dep));
        
    }
    
    // Solution 2 332 ms
    public int maxDepth_2(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth_2(root.left), maxDepth_2(root.right)) + 1;
    }

}
