package leetcode.april30day;

public class Fifth {

	public int maxProfit(int[] prices) {
		
		if(prices.length == 0) {
			return 0;
		}
		
		int profit = 0;
		
		int bIdx = -1;
		boolean isRisingStarted = false;
		
		for(int i=1;i<prices.length;i++) {
			
			if(!isRisingStarted && prices[i] >= prices[i-1]) {
				isRisingStarted = true;
				bIdx = i-1;
			}
			else if(prices[i] < prices[i-1] && isRisingStarted) {
				profit += prices[i-1] - prices[bIdx];
				isRisingStarted = false;
			}
			
		}
		
		if(isRisingStarted) {
			profit += prices[prices.length-1] - prices[bIdx];
		}
		
		return profit;
	}

	public static void main(String[] args) {
		int[] nums = {6,1,3,2,4,7};
		Fifth obj = new Fifth();
		System.out.println(obj.maxProfit(nums));
	}
	
}
