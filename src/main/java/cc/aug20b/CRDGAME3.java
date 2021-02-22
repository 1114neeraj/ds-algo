package cc.aug20b;

import java.util.Scanner;

public class CRDGAME3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			String[] input = scanner.nextLine().split(" ");

			int pc = Integer.parseInt(input[0]);
			int pr = Integer.parseInt(input[1]);

			solve(pc, pr);

		}

		scanner.close();

	}

	private static void solve(int pc, int pr) {
		
		int pcDigits = getDigits(pc);
		int prDigits = getDigits(pr);
		
		if(pcDigits >= prDigits) {
			System.out.println("1 " + prDigits);
		}
		else {
			System.out.println("0 " + pcDigits);
		}
		
	}
	
	private static int getDigits(int num) {
		if(num % 9 == 0) {
			return num/9;
		}
		
		return num/9 + 1;
	}
	
}
