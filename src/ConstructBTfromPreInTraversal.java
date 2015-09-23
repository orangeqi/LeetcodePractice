
public class ConstructBTfromPreInTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given preorder and inorder traversal of a tree,
	 * construct the binary tree.
	 * 
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 * 
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder){
		int a = 0, b = inorder.length;
		for (int i = 0; i < preorder.length; i++){
			
		}
	}
	
	private static TreeNode buildTree_helper(int[] preorder, int i, int[] inorder, int j, int k){
		
		TreeNode leftRoot = buildTree_helper(preorder, i+1, inorder, j, k);
		TreeNode rightRoot = buildTree_helper(preorder, i+1, inorder, j, k);
	}

}
