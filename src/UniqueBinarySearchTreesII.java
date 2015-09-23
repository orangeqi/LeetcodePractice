import java.util.ArrayList;


public class UniqueBinarySearchTreesII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<TreeNode> res = generateTrees(3);
		for (TreeNode root : res){
			System.out.println(root.val);
		}
	}
	
	/**
	 * Given n, generate all structurally unique BST's 
	 * (binary search trees) that store values 1...n.
	 * 
	 * For example,
	 * Given n = 3, your program should return all 5 
	 * unique BST's shown below.

		   1         3     3      2      1
		    \       /     /      / \      \
		     3     2     1      1   3      2
		    /     /       \                 \
		   2     1         2                 3
		   
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	// Solution 1 252 ms
    public static ArrayList<TreeNode> generateTrees(int n) {
        return tree_helper(1, n);
    }
    
    private static ArrayList<TreeNode> tree_helper(int start, int end){
    	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    	if (start > end){
    		res.add(null);
    		return res;
    	}
    	for (int i = start; i <= end; i++){
    		ArrayList<TreeNode> leftSubtrees = tree_helper(start, i-1);
    		ArrayList<TreeNode> rightSubtrees = tree_helper(i+1, end);
    	
    		for (TreeNode leftSubtree : leftSubtrees){
    			for (TreeNode rightSubtree : rightSubtrees){
    				TreeNode root = new TreeNode(i);
    				root.left = leftSubtree;
    				root.right = rightSubtree;
    				res.add(root);
    			}
    		}
    	}
    	return res;
    }
	

}
