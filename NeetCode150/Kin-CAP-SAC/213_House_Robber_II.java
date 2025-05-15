// https://leetcode.com/problems/house-robber-ii/?envType=problem-list-v2&envId=plakya4j
class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        if (n == 0) return 0; 
        if (n == 1) return nums[0]; 
        if (n == 2) return Math.max(nums[0], nums[1]); 

        int non_first_rob = robLinear(nums, 1, n - 1); 
        int non_last_rob = robLinear(nums, 0, n - 2); 

        return Math.max(non_first_rob, non_last_rob); 
    }

    private int robLinear(int [] nums, int start, int end) {
        // here we use two pointers to replace dp array to save memory and space 
        int prev1 = 0; 
        int prev2 = 0; 
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]); 
            prev2 = prev1; 
            prev1 = current; 
        }
        
        return Math.max(prev1, prev2); 
    }
}