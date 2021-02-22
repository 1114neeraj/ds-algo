package leetcode;

public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {

		char[] a = s.toCharArray();
		char[] b = t.toCharArray();

		boolean[][] dp = new boolean[b.length+1][a.length+1];

		for(int i=1;i<dp.length;i++) {
			dp[i][0] = true;
		}

		for(int j=1;j<dp[0].length;j++) {
			dp[0][j] = false;
		}
		
		dp[0][0] = true;
		
		for(int i=1;i<dp.length;i++) {
			for(int j=1;j<dp[0].length;j++) {

				if(a[j-1] == b[i-1]) {
					dp[i][j] = dp[i-1][j-1]; 
				}
				else {
					dp[i][j] = dp[i-1][j]; 
				}

			}
		}

		return dp[b.length][a.length];

	}

	public static void main(String[] args) {
		IsSubsequence obj = new IsSubsequence();
		String text = "ahbgdc";
		
		String[] patterns = {"abc", "axc"};
		
		for(String pattern : patterns) {
			System.out.println(obj.isSubsequence(pattern, text));
		}
		
	}
	
}
