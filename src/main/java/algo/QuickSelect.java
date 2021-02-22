package algo;

public class QuickSelect {
	
	private static int quickSelect(int[] array, int sIdx, int eIdx, int k) {
		
		int pivotIdx = Partition.partition(array, sIdx, eIdx);
		
		if(k==pivotIdx+1) {
			return array[pivotIdx];
		}
		else if(k<pivotIdx+1) {
			return quickSelect(array, sIdx, pivotIdx-1, k);
		}
		else {
			return quickSelect(array, pivotIdx+1, eIdx, k);
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {2,5,1,6,4,3};
		int value = quickSelect(array, 0, array.length-1, 1);
		System.out.println(value);
	}
	
}
