package leetcode.medium;

public class BinarySearchOnRotatedArray {

	public int findMin(int[] nums) {
		return findMin(nums, 0, nums.length-1);
	}
	
	private int findMin(int[] nums, int sIdx, int eIdx) {
		
		int mid = (sIdx+eIdx)/2;
		
		if(nums[mid-1] > nums[mid] && nums[mid+1] > nums[mid]) {
			return nums[mid];
		}
		
		if(nums[sIdx] < nums[mid-1]) {
			return findMin(nums, mid+1, eIdx);
		}
		else {
			return findMin(nums, sIdx, mid-1);
		}
		
	}
	
	public static void main(String[] args) {
		int[] nums = {2,1};
		BinarySearchOnRotatedArray solution = new BinarySearchOnRotatedArray();
		System.out.println(solution.findMin(nums));
	}
	
}
