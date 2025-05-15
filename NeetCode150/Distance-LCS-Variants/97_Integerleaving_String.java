// https://leetcode.com/problems/interleaving-string/description/?envType=problem-list-v2&envId=plakya4j
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // create dp with len = s2.length(); 
        // dp[j] -> true means s1(j) match s3(i + j - 1)
        // dp[j - 1] -> true means s2(j-1) match s3(i + j - 1)

        if (s1.length() + s2.length() != s3.length())  {
            // length not match cannot be inter-leaving; return false; 
            return false; 
        }

        boolean [] dp = new boolean[s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true; 
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1); 
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1); 
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || 
                            (dp[j-1] && s2.charAt(j-1) == s3.charAt(i + j - 1)); 
                }
            }
        }

        return  dp[s2.length()]; 
    }
}