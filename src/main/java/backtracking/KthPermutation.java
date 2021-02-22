package backtracking;

public class KthPermutation {

	private static boolean permute(char[] array, int idx, int k) {

		if(idx == array.length - 1) {
			return true;
		}

		for(int i=idx;i<array.length;i++) {
			swap(array, i, idx);
			permute(array, idx+1, k);
			swap(array, i, idx);
		}
		
		return false;
	}

	private static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {

		char[] array = {'a', 'b', 'c', 'd'};
		int k = 2;
		permute(array, 0, k);

	}

}
