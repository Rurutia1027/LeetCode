// https://leetcode.com/problems/distinct-subsequences/description/?envType=problem-list-v2&envId=plakya4j

class Solution {
    public int numDistinct(String s, String t) {
        // dp[i][j] = number of distinct sub-sequences of s[0...i-1] that equals t[0...j-1] 

        // if s[i-1] == t[j-1] -> dp [i][j] = dp[i-1][j-1] + dp[i-1][j]

        // dp[0][0] = 1, empty strings also satisify sub-strings
        // dp[i][0] = 1 -> any prefix of s can match t this empty string 
        // dp[0][j > 0] = 0 

        int m = s.length(); 
        int n = t.length(); 

        int [][] dp = new int[m + 1][n + 1]; 

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; 
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i -1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 
                } else {
                    dp[i][j] = dp[i-1][j]; 
                }
            }
        }
        
        return dp[m][n]; 
    }
}