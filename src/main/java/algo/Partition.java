package algo;

public class Partition {

	public static int partition(int[] array, int sIdx, int eIdx) {

		int pivot = array[eIdx];

		int i = sIdx;

		for(int j=sIdx ; j<eIdx ; j++) {

			if(array[j] <= pivot) {
				swap(array, i, j);
				i++;
			}

		}

		swap(array, i, eIdx);
		System.out.println(i);
		return i;
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
