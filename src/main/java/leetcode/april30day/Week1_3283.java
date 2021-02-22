package leetcode.april30day;

public class Week1_3283 {

	public int singleNumber(int[] nums) {
		
		int xor = nums[0];
		
		for(int i = 1;i<nums.length;i++) {
			xor = xor ^ nums[i];
		}
		
		return xor;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		Week1_3283 obj = new Week1_3283();
		System.out.println(obj.singleNumber(nums));
	}

}
