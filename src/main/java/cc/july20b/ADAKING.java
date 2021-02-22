package cc.july20b;

import java.util.Scanner;

public class ADAKING {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			int n = Integer.parseInt(scanner.nextLine());
			solve(n);
		}

		scanner.close();
	}
	
	private static void solve(int num) {
		
		int count=0;
		
		for(int i=0; i<8; i++) {
			
			for(int j=0; j<8; j++) {
				
				if(i==0 && j==0) {
					System.out.print("O");
				}
				else if(count < num) {
					System.out.print(".");
				}
				else {
					System.out.print("X");
				}
				count++;
			}
			
			System.out.println();
		}
		
	}
	
}
