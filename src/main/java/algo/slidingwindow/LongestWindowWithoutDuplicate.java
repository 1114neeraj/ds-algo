package algo.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestWindowWithoutDuplicate {

	public int lengthOfLongestSubstring(String s) {

		int i = 0;
		Set<Character> set = new HashSet<>();

		char[] array = s.toCharArray();

		int j=0;
		int result=0;

		while(j<array.length) {

			char ch = array[j];

			if(set.contains(ch)) {
				set.remove(array[i]);
				i++;
			}
			else {
				set.add(ch);
				result = Math.max(result, j-i+1);
				j++;
			}

		}

		return result;
	}
	
	public static void main(String[] args) {
		String str = "pwwkew";
		LongestWindowWithoutDuplicate obj = new LongestWindowWithoutDuplicate();
		System.out.println(obj.lengthOfLongestSubstring(str));
	}

}
