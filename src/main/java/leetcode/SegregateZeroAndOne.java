package leetcode;

public class SegregateZeroAndOne {

	public static void main(String[] args) {
		int[] array = {1,0,1,0,1,0,1};
		solve(array);
		
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
	}
	
	private static void solve(int[] array) {
		
		int l = 0;
		int r = array.length - 1;
		
		while(l < r) {
			
			while(l < r && array[l] == 0) {
				l++;
				break;
			}
			
			while(l < r && array[r] == 1) {
				r--;
				break;
			}
			
			if(l < r) {
				array[l++] = 0;
				array[r--] = 1;
			}
			
		}
		
	}
	
}
