package leetcode;

public class SegregateZeroOneAndTwo {

	public static void main(String[] args) {
		
		int[] array = {2,0,1};
		solve(array);
		
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		
	}
	
	private static void solve(int[] nums) {
		
		int l = 0;
		int m = 0;
		int r = nums.length - 1; 
		
		while(m<=r) {
			
			if(nums[m] == 0) {
				swap(nums, l, m);
				l++;
				m++;
			}
			else if(nums[m] == 1) {
				m++;
			}
			else {
				swap(nums, r, m);
				r--;
			}
			
		}
		
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
