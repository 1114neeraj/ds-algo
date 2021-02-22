package cc.june20b;

import java.util.Scanner;

public class COVDSMPL2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = Integer.parseInt(scanner.nextLine());

		while(T-->0) {

			String[] options = scanner.nextLine().split(" ");
			
			int n = Integer.parseInt(options[0]);
			int p = Integer.parseInt(options[1]);
			
			int[][] matrix = solveProblem(n, p, scanner);
			
			System.out.println("2");
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(matrix[i][j]);
					if(j != n-1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			
			int result = Integer.parseInt(scanner.nextLine());
			
			if(result == -1) {
				break;
			}

		}

		scanner.close();
	}
	
	private static int[][] solveProblem(int n, int p, Scanner scanner) {
		
		int[][] matrix = new int[n][n];
		
		int count = (p * n * n)/100;
		System.out.println(count);
		int value = 0;
		int tempCount = 0;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.println(String.format("%s %s %s %s %s", 1, i, j, i, j));
				System.out.flush();
				
				value = Integer.parseInt(scanner.nextLine());
				matrix[i-1][j-1] = value;
				tempCount += value;
				
				if(tempCount == count) {
					return matrix;
				}
			}
		}
		
		return matrix;
	}
}
