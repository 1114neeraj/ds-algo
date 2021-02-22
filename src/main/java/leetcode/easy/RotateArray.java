package leetcode.easy;

public class RotateArray {

	public void rotate(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        
        rotate(nums, 0, l-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, l-1);
        
    }
	
	private void rotate(int[] nums, int sIdx, int eIdx) {
		
		int temp = 0;
		
		while(sIdx < eIdx) {
			temp = nums[sIdx];
			nums[sIdx] = nums[eIdx];
			nums[eIdx] = temp;
			sIdx++;
			eIdx--;
		}
		
	}
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4,5,6};
		int k = 2;
		RotateArray solution = new RotateArray();
		solution.rotate(nums, k);
		
	}
	
}
