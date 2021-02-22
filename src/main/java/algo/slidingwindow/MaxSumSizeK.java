package algo.slidingwindow;

public class MaxSumSizeK {

	private static int solve(int[] array, int k) {
		
		int result = 0;
		
		if(k > array.length) {
			return -1;
		}
		
		for(int i=0;i<k;i++) {
			result += array[i];
		}
		
		int runningSum = result;
		int resultWindowStartIdx = 0;
		
		for(int i=1;i<=array.length-k;i++) {
			
			runningSum = runningSum - array[i-1] + array[i+k-1];
			
			if(runningSum > result) {
				resultWindowStartIdx = i;
				result = runningSum;
			}
			
		}
		
		System.out.println(resultWindowStartIdx + " " + (resultWindowStartIdx + k - 1));
		
		return result;
		
	}
	
	public static void main(String[] args) {
		
		int[] array = {4, 2, 1, 7, 8, 1, 2, 8, 1, 0};
		int k = 3;
		System.out.println(MaxSumSizeK.solve(array, k));
		
	}
	
}
