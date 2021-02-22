package algo.slidingwindow;

public class MaxSumPair {

	private static int[] solve(int[] array, int sIdx, int eIdx) {
		
		int maxValue = Integer.MIN_VALUE;
		
		int slidingWindowSum = array[sIdx];
		
		int maxSumStartIdx = sIdx;
		
		for(int i = sIdx+1 ; i <= eIdx-1 ; i++) {
			
			slidingWindowSum += array[i];
			
			if(slidingWindowSum >= maxValue) {
				maxValue = slidingWindowSum;
				maxSumStartIdx = i;
			}
			
			slidingWindowSum -= array[i-1];
			
		}
		
		int[] maxSumPairIdx = {maxSumStartIdx-1, maxSumStartIdx};
		
		return maxSumPairIdx;
	}
	
	public static void main(String[] args) {
		
		int[] array = {5,2,4,6,3,1};
		int[] maxSumPairIdx = solve(array, 0, array.length-1);
		System.out.println(array[maxSumPairIdx[0]]+" "+array[maxSumPairIdx[1]]);
		
	}
	
}
