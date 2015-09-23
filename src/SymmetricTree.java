
public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * Given a binary tree, check whether it is a mirror of 
	 * itself (ie, symmetric around its center).
	 * 
	 * For example, this binary tree is symmetric:
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
		56788765
	 * But the following is not:
		    1
		   / \
		  2   2
		   \   \
		   3    3
	 * 
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	// Solution 1 312 ms
    public static boolean isSymmetric(TreeNode root) {
    	if (root == null) return true;
    	return compare(root.left, root.right);
    }
    
    private static boolean compare(TreeNode l, TreeNode r){
    	if (l == null && r == null)
    		return true;
    	else if (l == null && r != null)
    		return false;
    	else if (l != null && r == null)
    		return false;
    	
    	if (l.val != r.val)
    		return false;
    	
    	return compare(l.left, r.right) && compare(l.right, r.left);
    	
    }
}
