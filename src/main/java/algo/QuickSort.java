package algo;

import java.util.Arrays;

public class QuickSort {

	private static void quickSort(int[] array, int sIdx, int eIdx) {
		
		if(sIdx >= eIdx) {
			return;
		}
		
		int pivotIdx = Partition.partition(array, sIdx, eIdx);
		// left array quick sort
		quickSort(array, sIdx, pivotIdx-1);
		// right array quick sort
		quickSort(array, pivotIdx+1, eIdx);
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,6,4,5,3};
		quickSort(array, 0, array.length-1);
		Arrays.stream(array).forEach(num -> System.out.print(num+" "));
	}
	
}
