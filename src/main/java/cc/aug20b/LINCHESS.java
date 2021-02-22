package cc.aug20b;

import java.util.Scanner;

public class LINCHESS {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			String[] input = scanner.nextLine().split(" ");

			int n = Integer.parseInt(input[0]);
			int K = Integer.parseInt(input[1]);

			int[] positions = new int[n];

			String[] positionInput = scanner.nextLine().split(" ");

			for(int i=0;i<n;i++) {
				positions[i] = Integer.parseInt(positionInput[i]);
			}

			System.out.println(solve(positions, K));

		}

		scanner.close();

	}

	private static int solve(int[] positions, int K) {

		int j = -1;
		int minValue = Integer.MAX_VALUE;

		for(int i=0;i<positions.length;i++) {

			if(positions[i] <= K && K % positions[i] == 0) {

				int value = K/positions[i] - 1;

				if(value <= minValue) {
					minValue = value;
					j = i;
				}

			}

		}

		return j == -1 ? j : positions[j];
	}

}
