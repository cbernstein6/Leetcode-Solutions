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
    public void flatten(TreeNode root) {
        if(root == null) return;

        List<Integer> list = new ArrayList<>();

        helper(root.left,list);
        helper(root.right,list);
        
        while(list.size() > 0){
            root.left = null;
            root.right = new TreeNode(list.get(0));
            root = root.right;
            list.remove(0);
        }
    }
    public void helper(TreeNode root, List<Integer> list){
        if(root == null) return;

        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
    }
}