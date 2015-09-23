import java.util.ArrayList;


public class PermutationSequence {

	/** 60 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4, 23));
	}
	
	/**
	 * The set [1,2,3,…,n] contains a total of n! 
	 * unique permutations.
	 * 
	 * By listing and labeling all of the permutations in order,
	 * We get the following sequence (ie, for n = 3):
		
		1"123"
		2"132"
		3"213"
		4"231"
		5"312"
		6"321"
		
	 * Given n and k, return the kth permutation sequence.
	 * Note: Given n will be between 1 and 9 inclusive.
	 * 
	 * 1 + (permutations of 2, 3) 
	 * 2 + (permutations of 1, 3) 
	 * 3 + (permutations of 1, 2) 
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	// Solution 1 204 ms
	// Reference: https://leetcode.com/discuss/42700/explain-like-im-five-java-solution-in-o-n
	public static String getPermutation(int n, int k) {
       
	    ArrayList<Integer> numbers = new ArrayList<Integer>();
	    int[] factorial = new int[n+1];
	    StringBuilder sb = new StringBuilder();

	    // create an array of factorial lookup
	    int sum = 1;
	    factorial[0] = 1;
	    for(int i=1; i<=n; i++){
	        sum *= i;
	        factorial[i] = sum;
	    }
	    // factorial[] = {1, 1, 2, 6, 24, ... n!}

	    // create a list of numbers to get indices
	    for(int i=1; i<=n; i++){
	        numbers.add(i);
	    }
	    // numbers = {1, 2, 3, 4}

	    k--;

	    for(int i = 1; i <= n; i++){
	        int index = k/factorial[n-i];
	        sb.append(String.valueOf(numbers.get(index)));
	        //System.out.println(String.valueOf(sb));
	        numbers.remove(index);
	        k-=index*factorial[n-i];
	    }
 
	    return String.valueOf(sb);
		
	}
}
