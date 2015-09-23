
public class ValidateBinarySearchTree {

	/** 98 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
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
	// Solution 1 372 ms
	// Reference: https://leetcode.com/discuss/42687/another-passed-java-solution
	public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private static boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
