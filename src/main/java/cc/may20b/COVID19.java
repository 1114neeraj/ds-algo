package cc.may20b;

import java.util.Scanner;

public class COVID19 {

	private static void solveProblem(int[] array) {
		
		int minCount = Integer.MAX_VALUE;
		int maxCount = Integer.MIN_VALUE;
		int tempCount = 1;
		boolean isEvaulated = false;
		
		
		for(int i=1; i<array.length; i++) {
			
			if(array[i] - array[i-1] <=2) {
				isEvaulated = false;
				tempCount++;
			}
			else {
				
				if(tempCount<=minCount) {
					minCount = tempCount;
				}
				
				if(tempCount>=maxCount) {
					maxCount = tempCount;
				}
				
				tempCount = 1;
				isEvaulated = true;
			}
			
		}
		
		if(!isEvaulated) {
			
			if(tempCount<=minCount) {
				minCount = tempCount;
			}
			
			if(tempCount>=maxCount) {
				maxCount = tempCount;
			}
			
		}
		
		System.out.println(minCount + " " + maxCount);
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

			solveProblem(array);

		}

		scanner.close();
	}
	
}
