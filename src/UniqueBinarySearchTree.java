
public class UniqueBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(3));
	}

	/**
	 * Given n, how many structurally unique BST's 
	 * (binary search trees) that store values 1...n?
	 * 
	 * For example,
	 * Given n = 3, there are a total of 5 unique BST's.
	 * 
	 * #nodes 0 1 2 3 4 ...
	 * #tree  1 1 2 5 [5(0,3)+2(1,2)+2(2,1)+5(3,0)]=14
	 * 1,2,...,n
	 * chose one of them each time as a root
	 * possible # of unique trees is sum(m*n)
	 * where m - left subtree, n - right subtree
	 * 
	 * @param n
	 * @return
	 */
	// Solution 1 200 ms
	public static int numTrees(int n){
		int[] res = new int[n+1];
		
		res[0] = 1; // 0 node
		res[1] = 1; // 1 node
		
		for (int i = 2; i < n+1; i++){
			for (int j = 0; j < i; j++){
				res[i] += res[j]*res[i-j-1];
			}
		}
		
		return res[n];
	}
}
