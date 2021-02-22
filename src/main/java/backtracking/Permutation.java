package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	private static void permute(char[] array, int idx, List<String> permutation) {
		
		if(idx == array.length - 1) {
			StringBuilder builder = new StringBuilder();
			for(Character ch : array) {
				builder.append(ch);
			}
			permutation.add(builder.toString());
		}
		
		for(int i=idx;i<array.length;i++) {
			swap(array, i, idx);
			permute(array, idx+1, permutation);
			swap(array, i, idx);
		}
		
	}
	
	private static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		
		char[] array = {'a', 'b', 'c'};
		List<String> permutation = new ArrayList<>();
		permute(array, 0, permutation);
		
		for(String str: permutation) {
			System.out.println(str);
		}
	}
	
}
