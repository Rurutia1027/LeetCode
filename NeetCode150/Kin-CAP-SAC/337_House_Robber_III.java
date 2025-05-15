// https://leetcode.com/problems/house-robber-iii/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * DP + memo 
 */
class Solution {
    public int rob(TreeNode root) {
        int [] ret = dfs(root); 
        return Math.max(ret[0], ret[1]); 
    }



    // return array with length = 2
    // arr[0] means, non-rob current node value max recorder 
    // arr[1] means, rob current node value max recorder 
    private int [] dfs(TreeNode node) {
        if (node == null) {
            return new int[2]; 
        }

        int [] left = dfs(node.left); 
        int [] right = dfs(node.right); 

        // rob current node, left[0] & right[0] means not rob node.left & node.right sub-nodes max value 
        int rob = node.val + left[0] + right[0]; 
        int non_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); 
        
        // return array of rob & non-rob current node 
        return new int []{non_rob, rob}; 
    }
}