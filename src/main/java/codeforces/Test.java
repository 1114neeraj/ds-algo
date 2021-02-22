package codeforces;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			String[] inputArray = scanner.nextLine().split(" ");

			int a = Integer.parseInt(inputArray[0]);
			int b = Integer.parseInt(inputArray[1]);

			System.out.println(min((a+b)/3, min(a, b)));

		}

		scanner.close();
	}
	
	private static int min(int a, int b) {
		return a>=b?b:a;
	}
	
}
