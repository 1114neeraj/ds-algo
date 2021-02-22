package cc.june20b;

import java.util.Scanner;

public class PRICECON {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			String[] options = scanner.nextLine().split(" ");
			
			int n = Integer.parseInt(options[0]);
			int k = Integer.parseInt(options[1]);
			
			String[] inputArray = scanner.nextLine().split(" ");

			int[] array = new int[n];

			for(int i=0;i<n;i++) {
				array[i] = Integer.parseInt(inputArray[i]);
			}

			System.out.println(solveProblem(array, k));

		}

		scanner.close();
	}

	private static int solveProblem(int[] array, int k) {
		
		int loss = 0;
		
		for(int value : array) {
			
			if(value > k) {
				loss += value - k;
			}
			
		}
		
		return loss;
		
	}

}
