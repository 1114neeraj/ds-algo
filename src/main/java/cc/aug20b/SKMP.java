package cc.aug20b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SKMP {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {
			
			String text = scanner.nextLine();
			String pattern = scanner.nextLine();

			System.out.println(solve(text, pattern));

		}

		scanner.close();

	}
	
	private static String solve(String text, String pattern) {
		String difference = difference(text, pattern);
		
		char ch = difference.charAt(0);
		
		int idx = -1; 
		
		for(int i=0;i<text.length();i++) {
			
			if(text.charAt(i) )
			
		}
	}

	private static String difference(String strA, String strB) {
		
		Map<Character, Integer> countMap = new HashMap<>();
		
		for(int i=0;i<strA.length();i++) {
			
			char ch = strA.charAt(i);
			
			if(countMap.containsKey(ch)) {
				countMap.put(ch, countMap.get(ch) + 1);
			}
			else {
				countMap.put(ch, 1);
			}
			
		}
		
		for(int i=0;i<strB.length();i++) {
			char ch = strB.charAt(i);
			
			if(countMap.containsKey(ch)) {
				int updatedValue = countMap.get(ch) - 1;
				
				if(updatedValue > 0) {
					countMap.put(ch, updatedValue);
				}
				else {
					countMap.remove(ch);
				}
				
			}
			
		}
		
		StringBuilder builder = new StringBuilder();
		
		for(Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			
			for(int i=0;i<entry.getValue();i++) {
				builder.append(entry.getKey());
			}
			
		}
		
		char[] array = builder.toString().toCharArray();
		
		Arrays.sort(array);
		
		return String.valueOf(array);
	}
	
}
