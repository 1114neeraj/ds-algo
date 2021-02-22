package cc.june20b;

import java.util.Scanner;

public class CHFICRM {

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

			System.out.println(solveProblem(array)?"YES":"NO");

		}

		scanner.close();
	}

	private static boolean solveProblem(int[] array) {
		
		int[] wallet = new int[2];
		
		for(int cashAmount : array) {
			if(!isFeasible(wallet, cashAmount)) {
				return false;
			}
			updateWallet(wallet, cashAmount);
		}
		
		return true;
		
	}
	
	private static boolean isFeasible(int[] wallet, int cashAmount) {
		
		if(cashAmount == 5) {
			return true;
		}
		else if(cashAmount == 10 && wallet[0] == 0) {
			return false;
		}
		else if(cashAmount == 10 && wallet[0] > 0) {
			return true;
		}
		else if(cashAmount == 15 && (wallet[0] >=2 || wallet[1] >=1)) {
			return true;
		}
		
		return false;
	}

	private static void updateWallet(int[] wallet, int cashAmount) {
		
		if(cashAmount == 5) {
			wallet[0]++;
		}
		else if(cashAmount == 10) {
			wallet[0]--;
			wallet[1]++;
		}
		else if(cashAmount == 15) {
			
			if(wallet[1] >= 1) {
				wallet[1]--;
			}
			else if(wallet[0] >=2 ) {
				wallet[0] = wallet[0] - 2;
			}
			
		}
		
	}
	
}
