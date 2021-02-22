package leetcode.april30day;

public class Week1_3285 {

	public int maxSubArray(int[] nums) {

		int result = nums[0];
		
		int temp = nums[0];
		
		for(int i=1;i<nums.length;i++) {
			
			if(temp < 0) {
				
				if(nums[i] > temp) {
					temp = nums[i];
					result = temp;
				}
				
			}
			else {
				
				temp += nums[i];
				
				if(temp<0) {
					temp = 0;
				}
				else if(temp >= result) {
					result = temp;
				}
				
			}
			
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		int[] nums = {-2};
		Week1_3285 obj = new Week1_3285();
		System.out.println(obj.maxSubArray(nums));
		
	}

}
