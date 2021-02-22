package leetcode;

import java.util.Arrays;

public class CoinChange {

	public int change(int amount, int[] coins) {
		int[] dp = new int[amount+1];
		
		dp[0] = 1;
		
		Arrays.sort(coins);
		
		for(int i=1;i<=amount ;i++) {
			for(int j=0;j<coins.length;j++) {
				
				if(i-coins[j] >= 0) {
					dp[i] += dp[i-coins[j]];
				}
				else {
					break;
				}
				
			}
		}
		
		return dp[amount];
	}

}
