// https://leetcode.com/problems/longest-common-subsequence/?envType=problem-list-v2&envId=plakya4j

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] represents the longest common subsequence of text1(0...i) and text2(0...j)

        int m = text1.length(); 
        int n = text2.length(); 

        int [][] dp = new int[m + 1][n + 1]; 
        dp[0][0] = 0; 
        dp[1][0] = 0; // because text1(0) and empty char of text2 d o not have common subsequent 
        dp[0][1] = 0; // the same as above 

        // outer loop iterates chars in text1
        for (int i = 1; i <= m; i++) {
            // inner loop iterates chars in text2 
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // have common sub-sequence 
                    dp[i][j] = dp[i-1][j-1] + 1; 
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); 
                }
            }
        }

        return dp[m][n]; 
    }
}