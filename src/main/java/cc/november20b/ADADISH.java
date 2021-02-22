package cc.november20b;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ADADISH {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			int n = Integer.parseInt(scanner.nextLine());

			String[] inputArray = scanner.nextLine().split(" ");

			Integer[] array = new Integer[n];

			for(int i=0;i<n;i++) {
				array[i] = Integer.parseInt(inputArray[i]);
			}

			System.out.println(solveProblem(array));
		}

		scanner.close();
	}

	private static int solveProblem(Integer[] array) {
		
		Arrays.sort(array, Collections.reverseOrder());
		
		int leftSum = 0;
		int rightSum = 0;
		
		boolean addToLeft = true;
		
		for(int value: array) {
			
			if(addToLeft)  {
				leftSum += value;
			}
			else {
				rightSum += value;
			}
			
			addToLeft = leftSum >= rightSum ? false: true;
			
		}
		
		return leftSum >= rightSum? leftSum: rightSum; 
	}
	
}
