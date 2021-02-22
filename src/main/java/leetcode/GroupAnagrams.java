package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public static void main(String[] args) {
		
		String abc = "baat";
		char[] array = abc.toCharArray();
		
		int[] count = new int[26];
		
		for(Character ch: array) {
			count[ch-'a']++;
		}
		String key = Arrays.toString(count);
		System.out.println(key);
	}

	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();

		List<List<String>> list = new ArrayList<List<String>>();

		for(String str: strs) {

			char[] array = str.toCharArray();

			Arrays.sort(array);

			StringBuilder builder = new StringBuilder();

			for(Character ch: array) {
				builder.append(ch);
			}

			String key = builder.toString();

			if(map.containsKey(key)) {
				map.get(key).add(str);
				map.put(key, map.get(key));
			}
			else {
				List<String> temp = new ArrayList<>();
				temp.add(str);
				map.put(key, temp);
			}

		}

		for(Map.Entry<String, List<String>> entry: map.entrySet()) {
			list.add(entry.getValue());
		}

		return list;
	}

}
