package cc.november20b;

import java.util.Scanner;

public class FEMA2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {
			
			String[] inputArray = scanner.nextLine().split(" ");
			
			int N = Integer.parseInt(inputArray[0]);
			int K = Integer.parseInt(inputArray[1]);
			
			char[] array = scanner.nextLine().toCharArray();

			System.out.println(solveProblem(array, K));
		}

		scanner.close();
	}
	
	private static int solveProblem(char[] array, int K) {
		
		int magnetIdx = -1;
		int ironIdx = -1;
		int sheetCount = 0;
		
		int count = 0;
		
		
		for(int i = 0; i < array.length; i++) {
			
			if(array[i] == 'M') {
				magnetIdx = i;
			}
			else if(array[i] == 'I') {
				ironIdx = i;
			}
			else if( array[i] == ':' && ((magnetIdx != -1 && ironIdx == -1) || (magnetIdx == -1 && ironIdx != -1))) {
				sheetCount++;
			}
			
			if(magnetIdx != -1 && ironIdx != -1) {
				
				if(isValid(ironIdx, magnetIdx, K, sheetCount)) {
					count++;
					magnetIdx = -1;
					ironIdx = -1;
					sheetCount = -1;
				}
				else if(magnetIdx > ironIdx) {
					ironIdx = -1;
					sheetCount = -1;
				}
				else if(magnetIdx < ironIdx) {
					magnetIdx = -1;
					sheetCount = -1;
				}
				
			}
			
			if(array[i] == 'X') {
				magnetIdx = -1;
				ironIdx = -1;
				sheetCount = -1;
			}
			
		}
		
		return count;
	}
	
	private static boolean isValid(int ironIdx, int magnetIdx, int K, int sheetCount) {
		return (K + 1 - Math.abs(magnetIdx - ironIdx) - sheetCount) > 0;
	}

}
