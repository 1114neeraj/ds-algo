package techgig;

import java.math.BigInteger;
import java.util.Scanner;

public class P1 {

	private static long solveProblem(BigInteger[] requirementArray, BigInteger[] capacityArray) {
		
		int n = requirementArray.length;
		
		BigInteger min = capacityArray[0].divide(requirementArray[0]);
		
		for(int i=1 ; i<n; i++) {
			BigInteger count = capacityArray[1].divide(requirementArray[1]);
			
			if(count.compareTo(min)<=0) {
				min = count;
			}
			
		}
		
		return min.longValue();
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());
		
		BigInteger[] requirementArray = new BigInteger[n];
		BigInteger[] capacityArray = new BigInteger[n];
		
		String[] arrayA = scanner.nextLine().split(" ");
		
		for(int i=0;i<n;i++) {
			requirementArray[i] = new BigInteger(arrayA[i]);
		}
		
		String[] arrayB = scanner.nextLine().split(" ");
		
		for(int i=0;i<n;i++) {
			capacityArray[i] = new BigInteger(arrayB[i]);
		}
		
		System.out.println(solveProblem(requirementArray, capacityArray));
		
		scanner.close();
	}
	
}
