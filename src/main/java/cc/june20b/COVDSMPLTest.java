package cc.june20b;

import java.util.Scanner;

public class COVDSMPLTest {

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
        int count = Integer.parseInt(scanner.nextLine());
		
		solve(matrix, 1, 1, n, n, count, scanner);
		
		return matrix;
	}
	
	private static int solve(int[][] matrix, int r1, int c1, int r2, int c2, int totalCount, Scanner scanner) {

        int count = totalCount;

        if(r1 == 1 && c1 == 1 && r2 == matrix.length && c2 == matrix[0].length) {}
        else {
            System.out.println(String.format("%s %s %s %s %s", 1, r1, c1, r2, c2));
            count = Integer.parseInt(scanner.nextLine());

            if(count == 0) {
                return 0;
            }
            else if(count == (r2 - r1 + 1) * (c2 - c1 + 1) ) {
                fill(matrix, r1, c1, r2, c2);
                return count;
            }
        }

        int r3 = (r1+r2)/2;
        int c3 = (c1+c2)/2;

        int sizeOfSubMatrix = (r2 - r1 + 1) * (c2 - c1 + 1);

        int topLeftCount = solve(matrix, r1, c1, r3, c3, count, scanner);

        if(topLeftCount + 3*sizeOfSubMatrix == count) {
            fill(matrix, r1, c3 + 1, r3, c2);
            fill(matrix, r3 + 1, c1, r2, c3);
            fill(matrix, r3 + 1, c3 + 1, r2, c2);
            return count;
        }

        if(topLeftCount == count) {
            return count;
        }

        int topRightCount = solve(matrix, r1, c3 + 1, r3, c2, count - topLeftCount, scanner);

        if(topLeftCount + topRightCount + 2*sizeOfSubMatrix == count) {
            fill(matrix, r3 + 1, c1, r2, c3);
            fill(matrix, r3 + 1, c3 + 1, r2, c2);
            return count;
        }

        if(topLeftCount + topRightCount == count) {
            return count;
        }

        int bottomLeftCount = solve(matrix, r3 + 1, c1, r2, c3, count - topLeftCount - topRightCount, scanner);

        if(topLeftCount + topRightCount + bottomLeftCount + sizeOfSubMatrix == count) {
            fill(matrix, r3 + 1, c3 + 1, r2, c2);
            return count;
        }

        if(topLeftCount + topRightCount + bottomLeftCount == count) {
            return count;
        }

        int bottomRightCount = solve(matrix, r3 + 1, c3 + 1, r2, c2,
                count - topLeftCount - topRightCount - bottomLeftCount, scanner);

        return topLeftCount + topRightCount + bottomLeftCount + bottomRightCount;

    }
	
	private static void fill(int[][] matrix, int r1, int c1, int r2, int c2) {
		
		for(int i=r1-1;i<=r2-1;i++) {
			for(int j=c1-1;j<=c2-1;j++) {
				matrix[i][j] = 1;
			}
		}
		
	}
}
