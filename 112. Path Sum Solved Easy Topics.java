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
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // dfs through tree, checking path
        // return helper(root.left,sum,targetSum) || helper(root.right,sum,targetSum)
        if(root == null) return false;

        int sum = root.val;
        if(sum == targetSum && root.left == null && root.right == null) return true;

        return (helper(root.left,sum,targetSum) || helper(root.right,sum,targetSum));
    }

    public boolean helper(TreeNode root, int sum, int target){
        if(root == null) return false;

        sum += root.val;
        if(sum == target && root.left == null && root.right == null) return true;
        return (helper(root.left,sum,target) || helper(root.right,sum,target));
    }
}