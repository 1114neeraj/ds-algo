package cc.feb21c;

import java.util.Scanner;

public class HDIVISR {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		
		for(int i=10;i>=1;i--) {
			if(n%i==0) {
				System.out.println(i);
				break;
			}
		}
		
		scanner.close();
	}
	
}
