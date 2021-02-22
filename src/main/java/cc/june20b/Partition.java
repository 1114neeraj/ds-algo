package cc.june20b;

public class Partition {

	public static void main(String[] args) {
		
		int[] array = {3,2,1,5,6,4};
		System.out.println(findKthLargest(array, 0, array.length - 1, 2));
	}
	
	private static int findKthLargest(int[] array, int l, int r, int k) {
		
		if(l == r) {
			return array[l];
		}
		
		int partitionIdx = partition(array, l, r);
		
		int length = r - l + 1;  
		
		if(partitionIdx - l == length - k) {
			return array[partitionIdx];
		}
		else if(partitionIdx - l < length - k) {
			return findKthLargest(array, partitionIdx + 1, r, k);
		}
		
		return findKthLargest(array, l, partitionIdx - 1, k);
		
	}
	
	private static int partition(int[] array, int l, int r) {
		
		int pivot = array[r];
		
		int i=l-1;
		
		for(int j=l;j<r;j++) {
			
			if(array[j] < pivot) {
				i++;
				swap(array, i, j);
			}
			
		}
		
		swap(array, i+1, r);
		return i+1;
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
