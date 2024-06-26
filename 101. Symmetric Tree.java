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
    public boolean isSymmetric(TreeNode root) {
        // helper call

        // option 1: one of them is null and other isn't, return false
        // option 2: they are not equal
        // option 3: they are both the same

        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null) return root1 == root2;
        if(root1.val != root2.val){
            return false;
        }
        return helper(root1.left,root2.right) && helper(root1.right, root2.left);
    }
}