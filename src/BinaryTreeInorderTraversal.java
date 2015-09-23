import java.util.ArrayList;
import java.util.Stack;


public class BinaryTreeInorderTraversal {

	/**
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
		
		System.out.println(inorderTraversal_1(root));
	}

	/**
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 * 
	 * For example:
	 * Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
	 * return [1,3,2].
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
	// Solution 1 276 ms
    public static ArrayList<Integer> inorderTraversal_1(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	inorder(res, root);
    	return res;
    }
	
    private static void inorder(ArrayList<Integer> res, TreeNode root){
    	if (root == null)
    		return;
    	if (root.left != null)
    		inorder(res, root.left);
    	
    	res.add(root.val);
    	
    	if (root.right != null)
    		inorder(res, root.right);
    	
    }
    
    // Solution 2 Stack 260 ms
    public ArrayList<Integer> inorderTraversal_2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;        
    }
}
