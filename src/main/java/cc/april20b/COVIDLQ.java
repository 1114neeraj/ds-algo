package cc.april20b;

import java.util.Scanner;

public class COVIDLQ {

	public static boolean solveProblem(char[] array) {
		
		int prevIdx = -1;
		
		for(int i=0;i<array.length;i++) {
			
			if(prevIdx != -1 && array[i] == '1') {
				
				if((i-prevIdx) < 6) {
					return false;
				}
				else {
					prevIdx = i;
				}
				
			}
			else if(prevIdx == -1 && array[i] == '1') {
				prevIdx = i;
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = Integer.parseInt(scanner.nextLine());
		
		while(T-->0) {
			
			int n = Integer.parseInt(scanner.nextLine());
			
			char[] inputArray = scanner.nextLine().toCharArray();
			
			char[] array = new char[n];
			
			int count = 0;
			
			for(char ch : inputArray) {
				if(ch != ' ') {
					array[count++] = ch;
				}
			}
			
			System.out.println(solveProblem(array)?"YES":"NO");
			
		}
		
		scanner.close();
		
	}
	
}
