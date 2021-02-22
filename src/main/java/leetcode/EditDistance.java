package leetcode;

public class EditDistance {

	public int min(int a, int b, int c) {
		
		if(a<=b && a<=c) {
			return a;
		}
		else if(b<=a && b<=c) {
			return b;
		}
		
		return c;
		
	}
	
	public int minDistance(String word1, String word2) {
		
		char[] arrayA = word1.toCharArray();
		char[] arrayB = word2.toCharArray();
		
		int[][] dp = new int[arrayA.length + 1][arrayB.length + 1];
		
		for(int i=0;i<dp.length;i++) {
			
			for(int j=0;j<dp[0].length;j++) {
				
				if(i == 0) {
					dp[i][j] = j;
				}
				else if(j == 0) {
					dp[i][j] = i;
				}
				else if(arrayA[i-1] == arrayB[j-1]) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1;
				}
				
			}
			
		}
		
		return dp[arrayA.length][arrayB.length];
    }
	
	public static void main(String[] args) {
		EditDistance obj = new EditDistance();
		String word1 = "intention";
		String word2 = "execution";
		System.out.println(obj.minDistance(word1, word2));
	}
	
}
