// https://leetcode.com/problems/house-robber/description/?envType=problem-list-v2&envId=plakya4j

class Solution1 {
    public int rob(int[] nums) {
        int n = nums.length; 
        if (n == 0) return 0; 
        if (n == 1) return nums[0]; 

        int [] dp = new int [n]; 

        dp[0] = nums[0]; 
        dp[1] = Math.max(nums[0], nums[1]); 

        // let dp[i] represents when rob house(i) the maximum value can retrieve 
        // dp[i] = MAX (rob-i: nums[i] + dp[i-2], not-rob-i: dp[i-1])
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]); 
        }

        return dp[n-1]; 
    }
}

// optimized version 
class Solution2 {
    public int rob(int[] nums) {
        int n = nums.length; 
        if (n == 0) return 0; 
        if (n == 1) return nums[0]; 

        // we use two pointer to replace dp array 
        int prev1 = nums[0]; // dp[0]
        int prev2 = Math.max(nums[0], nums[1]); // dp[1]

        for (int i = 2; i < n; i++) {
            // dp[i] = MAX(dp[i - 2] + nums[i], dp[i - 1])
            int current = Math.max(prev1 + nums[i], prev2); 
            prev1 = prev2; 
            prev2 = current;         
        }

        return Math.max(prev1, prev2); 
    }
}