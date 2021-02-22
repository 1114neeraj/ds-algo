package cc.june20b;

import java.util.Scanner;

public class COVDSMPL {

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

		solve(matrix, 1, 1, n, n, -1, scanner);

		return matrix;
	}

	private static int solve(int[][] matrix, int r1, int c1, int r2, int c2, int totalCount, Scanner scanner) {

		if(r1==r2) {
			return solveRow(matrix, r1, c1, c2, totalCount, scanner);
		}

		int count = totalCount;

		if(totalCount == -1) {
			System.out.println(String.format("%s %s %s %s %s", 1, r1, c1, r2, c2));
			count = Integer.parseInt(scanner.nextLine());
		}

		if(count == 0) {
			return 0;
		}
		else if(count == (r2 - r1 + 1) * (c2 - c1 + 1) ) {
			fill(matrix, r1, c1, r2, c2);
			return count;
		}

		int r3 = (r1+r2)/2;

		int topHalfCount = solve(matrix, r1, c1, r3, c2, -1, scanner);

		if(topHalfCount + (r2-r3+1) * (c2-c1+1) == count) {
			fill(matrix, r3, c1, r2, c2);
			return count;
		}

		int bottomHalfCount = count - topHalfCount;

		if(bottomHalfCount > 0) {
			bottomHalfCount = solve(matrix, r3+1, c1, r2, c2, bottomHalfCount, scanner);
		}

		return count;
	}

	private static int solveRow(int[][] array, int i, int l, int r, int totalCount, Scanner scanner) {
		
		int count = totalCount;
		
		if(totalCount == -1) {
			System.out.println(String.format("%s %s %s %s %s", 1, i, l, i, r));
			count = Integer.parseInt(scanner.nextLine());
		}
		
		if(count == 0) {
			return 0;
		}
		else if( count == r-l+1) {
			for(int j=l-1;j<=r-1;j++) {
				array[i-1][j] = 1;
			}
			return count;
		}
		
		int mid = (l+r)/2;
		
		int leftCount = solveRow(array, i, l, mid, -1, scanner);
		
		if(leftCount + (r-mid) == count) {
			for(int j=mid;j<=r-1;j++) {
				array[i-1][j] = 1;
			}
			return count;
		}
		
		int rightCount = count - leftCount;
		
		if(rightCount > 0) {
			rightCount = solveRow(array, i, mid + 1, r, rightCount, scanner);
		}
		
		return leftCount + rightCount;
	}

	private static void fill(int[][] matrix, int r1, int c1, int r2, int c2) {

		for(int i=r1-1;i<=r2-1;i++) {
			for(int j=c1-1;j<=c2-1;j++) {
				matrix[i][j] = 1;
			}
		}

	}
}
