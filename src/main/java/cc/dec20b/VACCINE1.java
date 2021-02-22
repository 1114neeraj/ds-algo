package cc.dec20b;

import java.util.Scanner;

public class VACCINE1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[] inputArray = scanner.nextLine().split(" ");

		double n1 = Double.parseDouble(inputArray[0]);
		double p1 = Double.parseDouble(inputArray[1]);
		double n2 = Double.parseDouble(inputArray[2]);
		double p2 = Double.parseDouble(inputArray[3]);
		double P = Double.parseDouble(inputArray[4]);
		
		int days = 0;
		
		if(n1 < n2) {
			days = (int) (Math.ceil((P+p2*(n2-n1))/(p1+p2)) + (n1-1));
		}
		else {
			days = (int) (Math.ceil((P+p1*(n1-n2))/(p1+p2)) + (n2-1));
		}
		
		System.out.println(days);
		
		scanner.close();
	}
	
}
