import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class LengthOfLongestSubstring {

	/** 3 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring_1("abcacfd"));
	}
	
	/**
	 * Given a string, find the length of the longest substring
	 * without repeating characters. 
	 * For example, the longest substring without repeating letters 
	 * for "abcabcbb" is "abc", which the length is 3. 
	 * For "bbbbb" the longest substring is "b", with the length of 1.
	 * 
	 * @param s
	 * @return
	 */
	
	// Solution 1 Time limit exceeded
	// "abcacb" need 'start' always larger than the index of previous duplicate
	public static int lengthOfLongestSubstring_1(String s) {
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		int start = 0, longest = 0;
		char c;
		for (int i = 0; i < s.length(); i++){
			c = s.charAt(i);
			if (map.containsKey(c) && map.get(c) >= start)
				start = map.get(c) + 1;
			else 
				longest = longest > (i-start+1) ? longest : (i-start+1);
			map.put(c, i);
		}
		
		return longest;
	}
	
	// Solution 2 436 ms
	// Reference: https://leetcode.com/discuss/40279/my-short-java-soul
	public int lengthOfLongestSubstring_2(String s) {

        Map<Character, Integer> loc = new HashMap<Character, Integer>();
        int max = 0;
        int currHead =0;

        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(loc.containsKey(c) && loc.get(c) >= currHead)
                currHead = loc.get(c)+1;
            else
                max = Math.max(max, i-currHead+1);
            loc.put(c, i);
        }

        return max;
    }
	
	// Solution 3 360 ms
	// Reference: https://leetcode.com/discuss/40966/my-java-solution-with-412-ms
	public int lengthOfLongestSubstring_3(String s) {
	    int[] m = new int[127];
	    char[] ch = s.toCharArray();
	    int max = 0;
	    int start = 0;
	    for (int i = 0; i < m.length; i++) {
	        m[i] = -1;
	    }
	    for (int i = 0; i < ch.length; i++) {
	        if (m[ch[i]] < 0) {
	            m[ch[i]] = i;
	        } else {
	            start = Math.max(start, m[ch[i]] + 1);
	            m[ch[i]] = i;
	        }
	        max = Math.max(max, i - start + 1);
	    }
	    return max;
	}
}
