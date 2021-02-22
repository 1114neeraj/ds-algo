package cc.july20b;

import java.util.Scanner;

public class CRDGAME {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			int n = Integer.parseInt(scanner.nextLine());

			int[][] cards = new int[n][2];
			
			for(int i=0; i<n; i++) {
				String[] input = scanner.nextLine().split(" ");
				cards[i][0] = Integer.parseInt(input[0]);
				cards[i][1] = Integer.parseInt(input[1]);
			}

			solve(cards);
		}

		scanner.close();
	}

	private static void solve(int[][] cards) {
		
		int scoreA = 0;
		int scoreB = 0;
		
		for(int i=0; i<cards.length; i++) {
			
			int powerA = calculatePower(cards[i][0]);
			int powerB = calculatePower(cards[i][1]);
			
			if(powerA == powerB) {
				scoreA += 1;
				scoreB += 1;
			}
			else if(powerA < powerB) {
				scoreB += 1;
			}
			else {
				scoreA += 1;
			}
			
		}
		
		if(scoreA == scoreB) {
			System.out.println("2 "+scoreA);
		}
		else if(scoreA > scoreB) {
			System.out.println("0 "+scoreA);
		}
		else {
			System.out.println("1 "+scoreB);
		}
		
	}
	
	private static int calculatePower(int num) {
		
		if(num < 10) {
			return num;
		}
		
		int power = 0;
		
		while(num > 0) {
			power += num % 10;
			num = num / 10;
		}
		
		return power;
	}
}
