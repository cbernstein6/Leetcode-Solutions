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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        int sum = root.val;
        if(sum == targetSum && root.left == null && root.right == null){
            list.add(Arrays.asList(sum));
            return list;
        }

        List<Integer> curr = new ArrayList<>();
        curr.add(root.val);

        helper(root.left,list, curr, sum,targetSum);
        helper(root.right,list, curr, sum,targetSum);

        return list;
    }

    public void helper(TreeNode root, List<List<Integer>> list, List<Integer> curr, int sum, int target){
        if(root == null) return;

        sum += root.val;
        curr.add(root.val);

        if(sum == target && root.left == null && root.right == null){
            list.add(new ArrayList<>(curr));
        }

        helper(root.left,list, curr, sum,target);
        helper(root.right,list, curr, sum,target);

        curr.remove(curr.size()-1);
    }
}