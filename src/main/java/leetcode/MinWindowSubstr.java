package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstr {

	public String minWindow(String s, String t) {
		
		char[] array = s.toCharArray();
		char[] uniquerChars = t.toCharArray();
		
		Map<Character, Integer> charMap = initPatternCharMap(uniquerChars);
		Map<Character, Integer> stringCharMap = initStringCharMap(array, charMap);
		
		int sIdx = 0;
		int eIdx = 0;
		
		int minWindowLength = Integer.MAX_VALUE;
		int minWindowStartIdx = 0;
		
		boolean isValid = false;
		
		while(sIdx <= eIdx && eIdx < array.length) {
			
			addCharToMap(stringCharMap, array[eIdx]);
			
			isValid = isValid(stringCharMap, charMap);
			
			if(!isValid) {
				eIdx++;
			}
			else {
				
				if(minWindowLength >= (eIdx - sIdx)) {
					minWindowLength = eIdx - sIdx;
					minWindowStartIdx = sIdx;
				}
				
				removeCharFromMap(stringCharMap, array[sIdx]);
				removeCharFromMap(stringCharMap, array[eIdx]);
				sIdx++;
			}
			
		}
		
		if(minWindowLength == Integer.MAX_VALUE) {
			return "";
		}
		
		return s.substring(minWindowStartIdx, minWindowStartIdx + minWindowLength + 1);
	}
	
	private static Map<Character, Integer> initPatternCharMap(char[] uniquerChars) {
		
		Map<Character, Integer> charMap = new HashMap<>();
		
		for(char ch : uniquerChars) {
			int count = 0;
			if(charMap.containsKey(ch)) {
				count = charMap.get(ch);
			}
			
			charMap.put(ch, count+1);
			
		}
		
		return charMap;
	}
	
	private static Map<Character, Integer> initStringCharMap(char[] array, Map<Character, Integer> charMap) {

		Map<Character, Integer> stringCharMap = new HashMap<>();

		for(char ch : array) {
			
			if(charMap.containsKey(ch)) {
				stringCharMap.put(ch, 0);
			}
			
		}

		return stringCharMap;

	}
	
	private static void addCharToMap(Map<Character, Integer> stringCharMap, char ch) {
		
		if(stringCharMap.containsKey(ch)) {
			int count = stringCharMap.get(ch);
			stringCharMap.put(ch, count+1);
		}
		
	}
	
	private static void removeCharFromMap(Map<Character, Integer> stringCharMap, char ch) {
		
		if(stringCharMap.containsKey(ch)) {
			int count = stringCharMap.get(ch);
			stringCharMap.put(ch, count-1);
		}
		
	}
	
	private static boolean isValid(Map<Character, Integer> stringCharMap, Map<Character, Integer> charMap) {
		
		for(Map.Entry<Character, Integer> entry : charMap.entrySet()) {
			
			int expectedValue = entry.getValue();
			
			if(!stringCharMap.containsKey(entry.getKey())) {
				return false;
			}
			
			int actualValue = stringCharMap.get(entry.getKey());
			
			if(actualValue < expectedValue) {
				return false;
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String S = "a";
		String T = "b";
		MinWindowSubstr app = new MinWindowSubstr();
		System.out.println(app.minWindow(S, T));
	}
}
