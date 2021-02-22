package cc.june20b;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int n = 2;
		int l = 1;
		int r = n;
		int[] array = new int[n];
		Scanner scanner = new Scanner(System.in);
		solve(array, l, r, -1, scanner);
//		solve2(array, l, r, totalCount, scanner);
		for(int i=0;i<n;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
		scanner.close();
	}
	
	private static int solve(int[] array, int l, int r, int totalCount, Scanner scanner) {
		
		int count = totalCount;
		
		if(totalCount == -1) {
			System.out.println(String.format("%s %s", l, r));
			count = Integer.parseInt(scanner.nextLine());
		}
		
		if(count == 0) {
			return 0;
		}
		
		else if( count == r-l+1) {
			for(int i=l;i<=r;i++) {
				array[i-1] = 1;
			}
			return count;
		}

		int mid = (l+r)/2;

		int leftCount = solve(array, l, mid, -1, scanner);

		if(leftCount + (r-mid) == count) {
			for(int i=mid+1;i<=r;i++) {
				array[i-1] = 1;
			}
			return count;
		}

		int rightCount = count - leftCount;

		if(rightCount > 0) {
			rightCount = solve(array, mid + 1, r, rightCount, scanner);
		}

		return leftCount + rightCount;
	}
	
	private static int solve2(int[] array, int l, int r, int totalCount, Scanner scanner) {
		
		int count = totalCount;
		
		if(r-l+1 != array.length) {
			System.out.println(String.format("%s %s", l, r));
			count = Integer.parseInt(scanner.nextLine());
		}
		
		if(count == 0) {
			return 0;
		}
		else if( count == r-l+1) {
			for(int i=l;i<=r;i++) {
				array[i-1] = 1;
			}
			return count;
		}
		
		int leftCount = solve2(array, l, l+count-1, count, scanner);
		
		int rightCount = 0;
		
		if(leftCount != count) {
			
			if(r-l-count+1 == count - leftCount) {
				for(int i=l+count;i<=r;i++) {
					array[i-1] = 1;
				}
				return count;
			}
			
			rightCount = solve2(array, l+count, r, count - leftCount, scanner);
		}
		
		return leftCount + rightCount;
	}
	
	private static int solve3(int[] array, int l, int r, int totalCount, Scanner scanner) {
		
		int count = totalCount;
		
		if(r != array.length - 1) {
			System.out.println(String.format("%s %s", l, r));
			count = scanner.nextInt();
			
			if(count == 0) {
				return 0;
			}
			else if( count == r-l+1) {
				for(int i=l;i<=r;i++) {
					array[i] = 1;
				}
				return count;
			}
		}
		
		int leftCount = solve3(array, l, r-1, totalCount, scanner);
		
		return count;
	}
	
}
