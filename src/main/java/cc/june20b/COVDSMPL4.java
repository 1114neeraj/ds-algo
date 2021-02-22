package cc.june20b;

import java.util.Scanner;

import cc.june20b.simulator.guessMatrix.Message;

public class COVDSMPL4 {

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
		
		System.out.println(String.format("%s %s %s %s %s", 1, 1, 1, n, n));
		int totalCount = Integer.parseInt(scanner.nextLine());
		
		int tempCount = 0;
		
		for(int i=1;i<=n;i++) {
			System.out.println(String.format("%s %s %s %s %s", 1, i, 1, i, n));
			int count = Integer.parseInt(scanner.nextLine());
			tempCount += solveRow(matrix, i, 1, n, count, scanner);
			
			if(tempCount == totalCount) {
				break;
			}
			
		}
		
		return matrix;
	}
	
//	private static int solveRow(int[][] array, int i, int l, int r, int totalCount, Scanner scanner) {
//		
//		int count = totalCount;
//		
//		if(r-l+1 != array.length) {
//			System.out.println(String.format("%s %s %s %s %s", 1, i, l, i, r));
//			count = Integer.parseInt(scanner.nextLine());
//			
//			if(count == 0) {
//				return 0;
//			}
//			else if( count == r-l+1) {
//				for(int j=l-1;j<=r-1;j++) {
//					array[i-1][j] = 1;
//				}
//				return count;
//			}
//		}
//		
//		int leftCount = solveRow(array, i, l, l+count-1, count, scanner);
//		
//		if(r-l-count+1 == count - leftCount) {
//			for(int j=l+count-1;j<=r-1;j++) {
//				array[i-1][j] = 1;
//			}
//			return count;
//		}
//		
//		int rightCount = 0;
//		
//		if(leftCount != count) {
//			rightCount = solveRow(array, i, l+count, r, count - leftCount, scanner);
//		}
//		
//		return leftCount + rightCount;
//	}
	
	private static int solveRow(int[][] array, int i, int l, int r, int totalCount, Scanner scanner) {
		
		int count = totalCount;
		
		if(r-l+1 != array.length) {
			System.out.println(String.format("%s %s %s %s %s", 1, i, l, i, r));
			
			count = Integer.parseInt(scanner.nextLine());
			
			if(count == 0) {
				return 0;
			}
			else if( count == r-l+1) {
				for(int j=l-1;j<=r-1;j++) {
					array[i-1][j] = 1;
				}
				return count;
			}
		}
		
		int leftCount = solveRow(array, i, l, l+count-1, count, scanner);
		
		if(r-l-count+1 == count - leftCount) {
			for(int j=l+count-1;j<=r-1;j++) {
				array[i-1][j] = 1;
			}
			return count;
		}
		
		int rightCount = 0;
		
		if(leftCount != count) {
			rightCount = solveRow(array, i, l+count, r, count - leftCount, scanner);
		}
		
		return leftCount + rightCount;
	}
}
