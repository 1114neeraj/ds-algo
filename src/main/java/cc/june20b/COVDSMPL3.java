package cc.june20b;

import java.util.Scanner;

public class COVDSMPL3 {

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
			tempCount += solveRow(matrix, i, 1, n, -1, scanner);
			
			if(tempCount == totalCount) {
				break;
			}
			
		}
		
		return matrix;
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
}
