package cc.dec20b;

import java.math.BigInteger;
import java.util.Scanner;

public class EVENPSUM {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());
		BigInteger two = new BigInteger("2");
		
		while(T-->0) {
			
			String[] inputArray = scanner.nextLine().split(" ");
			BigInteger A = new BigInteger(inputArray[0]);
			BigInteger B = new BigInteger(inputArray[1]);
			
			BigInteger evenPairCount = A.divide(two).multiply(B.divide(two));
			
			BigInteger oddPairCount = evenPairCount;
			
			if(!A.mod(two).equals(BigInteger.ZERO) && !B.mod(two).equals(BigInteger.ZERO)) {
				oddPairCount = (A.divide(two).add(BigInteger.ONE)).multiply(A.divide(two).add(BigInteger.ONE));
			}
			else if(!A.mod(two).equals(BigInteger.ZERO)) {
				oddPairCount = (A.divide(two).add(BigInteger.ONE)).multiply(A.divide(two));
			}
			else if(!B.mod(two).equals(BigInteger.ZERO)) {
				oddPairCount = A.divide(two).multiply(A.divide(two).add(BigInteger.ONE));
			}
			
			System.out.println(evenPairCount.add(oddPairCount).toString());
		}
		
		scanner.close();
	}
	
}
