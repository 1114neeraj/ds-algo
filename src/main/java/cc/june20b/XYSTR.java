package cc.june20b;

import java.util.Scanner;

public class XYSTR {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			String input = scanner.nextLine();

			System.out.println(solveProblem(input));

		}

		scanner.close();
	}

	private static int solveProblem(String input) {
		int count = 0;
		
		char[] array = input.toCharArray();
		
		if(array.length == 1) {
			return count;
		}
		
		int idx = 1;
		
		while(idx < array.length) {
			
			if(array[idx] != array[idx-1]) {
				count++;
				idx = idx + 2;
			}
			else {
				idx++;
			}
			
		}
		
		return count;
	}
	
}
