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
    public boolean isValidBST(TreeNode root) {
        // for dfs tree, 
        // if not null,helper(root.left,val,integer.minval)
        // if not null,helper(root.right,integer.maxval,val)
        // if we go left, update max with min of max,val
        // likewise with right
        if(root == null) return false;
        return (helper(root.left,root.val, Long.MIN_VALUE) && helper(root.right, Long.MAX_VALUE, root.val));
    }

    public boolean helper(TreeNode root, long max, long min){
        if(root == null) return true;
        long val = root.val;
        if(val >= max || val <= min){
            // System.out.println(val+" "+max+" "+min);
            return false;
        }

        return (helper(root.left,Math.min(val,max), min) && helper(root.right, max, Math.max(min,val)));
    }
}