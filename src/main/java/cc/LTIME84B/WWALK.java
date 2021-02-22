package cc.LTIME84B;

import java.math.BigInteger;
import java.util.Scanner;

public class WWALK {

	private static BigInteger solve(BigInteger[] arrayA, BigInteger[] arrayB) {
		
		BigInteger distanceCoveredA = BigInteger.ZERO;
		BigInteger distanceCoveredB = BigInteger.ZERO;
		
		BigInteger weiredDistance = BigInteger.ZERO;
		
		for(int i=0;i<arrayA.length;i++) {
			
			if(distanceCoveredA.equals(distanceCoveredB) && arrayA[i].equals(arrayB[i])) {
				weiredDistance = weiredDistance.add(arrayA[i]);
			}
			
			distanceCoveredA = distanceCoveredA.add(arrayA[i]);
			distanceCoveredB = distanceCoveredB.add(arrayB[i]);
			
		}
		
		return weiredDistance;
		
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			int n = Integer.parseInt(scanner.nextLine());

			String[] inputArray = scanner.nextLine().split(" ");
			
			BigInteger[] arrayA = new BigInteger[n];
			BigInteger[] arrayB = new BigInteger[n];

			for(int i=0;i<n;i++) {
				arrayA[i] = new BigInteger(inputArray[i]);
			}
			
			inputArray = scanner.nextLine().split(" ");
			
			for(int i=0;i<n;i++) {
				arrayB[i] = new BigInteger(inputArray[i]);
			}

			System.out.println(solve(arrayA, arrayB));

		}

		scanner.close();

	}
	
}
