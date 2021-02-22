package leetcode;

public class BuySellStock_3 {

	public int maxProfit(int[] prices) {

		int[] maxProfitArray = new int[2];

		int bIdx = -1;

		boolean isRisingStarted = false;

		for(int i=1;i<prices.length;i++) {

			if(!isRisingStarted && prices[i] >= prices[i-1]) {
				isRisingStarted = true;
				bIdx = i-1;
			}
			else if(prices[i] < prices[i-1] && isRisingStarted) {
				updateProfitArray(maxProfitArray, prices[i-1] - prices[bIdx]);
				isRisingStarted = false;
			}

		}
		
		if(isRisingStarted) {
			updateProfitArray(maxProfitArray, prices[prices.length-1] - prices[bIdx]);
		}

		return maxProfitArray[1] + maxProfitArray[0];

	}

	private void updateProfitArray(int[] maxProfitArray, int profit) {

		if(profit > maxProfitArray[0]) {
			int temp = maxProfitArray[0];
			maxProfitArray[1] = temp;
			maxProfitArray[0] = profit;
		}
		else if(profit > maxProfitArray[1]){
			maxProfitArray[1] = profit;
		}

	}
	
	public static void main(String[] args) {
		int[] nums = {7,6,4,3,1};
		BuySellStock_3 obj = new BuySellStock_3();
		System.out.println(obj.maxProfit(nums));
	}

}
