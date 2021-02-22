package cc.aug20b;

import java.util.Scanner;

public class CHEFWARS {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = Integer.parseInt(scanner.nextLine());
		
		while(T-->0) {
			
			String[] input = scanner.nextLine().split(" ");
			
			int h = Integer.parseInt(input[0]);
			int p = Integer.parseInt(input[1]);
			
			if(p <= h/2) {
				System.out.println("0");
			}
			else {
				System.out.println("1");
			}
			
		}
		
		scanner.close();
		
	}
	
}
