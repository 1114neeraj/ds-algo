package leetcode.april30day;

public class Fourth {

	public void moveZeroes(int[] nums) {

		 if(nums.length==1) {
	            return;
	        }
	        
	        int zeroIdx = -1;
	        boolean isZeroFound = false;
	        
	        for(int i=0;i<nums.length;i++) {
	            
	            if(nums[i] == 0 && !isZeroFound) {
	                zeroIdx = i;
	                isZeroFound = true;
	            }  
	            else if(nums[i] !=0 && isZeroFound) {
	                swap(nums, i, zeroIdx);
	                zeroIdx++;
	            }
	            
	        }
	        

	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		Fourth obj = new Fourth();
		obj.moveZeroes(nums);
		for(int i : nums) {
			System.out.println(i);
		}
	}

}
