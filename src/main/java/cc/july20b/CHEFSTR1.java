package cc.july20b;

import java.math.BigInteger;
import java.util.Scanner;

public class CHEFSTR1 {

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
	
	private static String solve(int[] array) {
		
		BigInteger count = BigInteger.ZERO;
		
		for(int i=1;i<array.length;i++) {
			int value = array[i] - array[i-1];
			
			if(value<0) {
				value = -1 * value;
			}
			
			count = count.add(new BigInteger(String.valueOf(value))).subtract(BigInteger.ONE);
		}
		
		return count.toString();
		
	}
	
}
