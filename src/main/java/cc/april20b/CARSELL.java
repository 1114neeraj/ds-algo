package cc.april20b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CARSELL {

	private static int solveProblem(Integer[] array) {
		
		int profit = 0;
		
		Arrays.sort(array, Comparator.reverseOrder());
		
		int mod = (int) (Math.pow(10, 9) + 7);
		
		for(int i=0;i<array.length;i++) {
			
			if(array[i] == 0) {
				break;
			}
			
			profit += ((array[i] - i) % mod);
			profit = profit % mod;
		}
		
		return profit;
	}
	
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

}
