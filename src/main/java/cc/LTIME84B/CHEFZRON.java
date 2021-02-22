package cc.LTIME84B;

import java.util.Scanner;

public class CHEFZRON {

	private static int solve(int[] array) {
		
		int distance = 0;
		
		int lIdx = getLeftIdx(array, 0);
		
		int rIdx = getRightIdx(array, array.length - 1);
		
		if(lIdx == -1 && rIdx == -1) {
			return 0;
		}
		
		if(lIdx == rIdx) {
			return -1;
		}
		
		while(lIdx < rIdx ) {
			
			int nextIdx = -1;
			
			for(int i=lIdx+1; lIdx<=rIdx ;i++) {
				
				if(array[i] == 1) {
					nextIdx = i;
					break;
				}
				
			}
			
			if(nextIdx == -1) {
				break;
			}
			
			if(nextIdx - lIdx < array.length - rIdx + lIdx) {
				distance += nextIdx - lIdx;
				lIdx = getLeftIdx(array, nextIdx);
			}
			else {
				distance += array.length - rIdx + lIdx;
				rIdx = nextIdx;
				rIdx = getRightIdx(array, rIdx);
			}
			
		}
		
		return distance;
		
	}
	
	private static int getLeftIdx(int[] array, int idx) {
		
		for(int i=0;i<array.length;i++) {
			if(array[i] == 1) {
				return i;
			}
		}
		
		return -1;
	}
	
	private static int getRightIdx(int[] array, int idx) {
		
		for(int i=idx;i>=0;i--) {
			if(array[i] == 1) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			int n = Integer.parseInt(scanner.nextLine());

			String[] inputArray = scanner.nextLine().split(" ");

			int[] array = new int[n];

			for(int i=0;i<n;i++) {
				array[i] = Integer.parseInt(inputArray[i]);
			}

			System.out.println(solve(array));

		}

		scanner.close();

	}
	
}
