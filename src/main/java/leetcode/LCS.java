package leetcode;

public class LCS {

	public int lcs(String word1, String word2) {
		
		char[] arrayA = word1.toCharArray();
		char[] arrayB = word2.toCharArray();
		
		int[][] dp = new int[arrayA.length + 1][arrayB.length + 1];
		
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				
				if(i==0 || j ==0) {
					dp[i][j] = 0;
				}
				else if(arrayA[i-1] == arrayB[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
				}
				
			}
		}
		
		return dp[arrayA.length][arrayB.length];
	}
	
	public int max(int a, int b) {
		return a >=b ? a : b;
	}
	
	public static void main(String[] args) {
		LCS obj = new LCS();
		String word1 = "sea";
		String word2 = "eat";
		System.out.println(obj.lcs(word1, word2));
 	}
	
}
