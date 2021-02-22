package cc.LTIME84B;

import java.util.Scanner;

public class LOSTWKND {

	private static boolean solve(int[] array) {
		
		int totalHrs = 0;
		
		for(int i=0;i<array.length-1;i++) {
			totalHrs += array[i];
		}
		
		return totalHrs * array[array.length-1] > 120;
		
	}
	
	public static void main (String[] args) throws java.lang.Exception {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			String[] inputArray = scanner.nextLine().split(" ");

			int[] array = new int[6];

			for(int i=0;i<6;i++) {
				array[i] = Integer.parseInt(inputArray[i]);
			}

			System.out.println(solve(array)?"Yes":"No");

		}

		scanner.close();

	}
	
}
