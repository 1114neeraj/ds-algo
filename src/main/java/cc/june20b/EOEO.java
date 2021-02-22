package cc.june20b;

import java.math.BigInteger;
import java.util.Scanner;

public class EOEO {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {
			BigInteger strength = new BigInteger(scanner.nextLine());
			System.out.println(solveProblem(strength));

		}

		scanner.close();
	}

	private static String solveProblem(BigInteger strength) {
		
		BigInteger two = new BigInteger("2");
		BigInteger zero = BigInteger.ZERO;
		
		if(!strength.mod(two).equals(zero)) {
			return strength.divide(two).toString();
		}
		
		while(strength.mod(two).equals(zero)) {
			strength = strength.divide(two);
		}
		
		return strength.divide(two).toString();
	}
	
}
