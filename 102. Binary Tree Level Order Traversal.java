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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // start list of list
        // create queue for vals and a queue for next
        // add root to queue

        // while queue has vals
        // curr = new list
        // while queue has vals, 
        // node = queue.pop,
        // curr.add(node.val)
        // next.offer(left and right of queue)

        // list.add(new arrlist of curr)
        // queue = next,
        // reset next
        // reset curr

        // return list

        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>(), next = new LinkedList<>();
        queue.add(root);
        
        List<Integer> curr = new ArrayList<>();

        while(!queue.isEmpty()){
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                curr.add(node.val);

                if(node.left != null) next.add(node.left);
                if(node.right != null) next.add(node.right);
            }

            list.add(new ArrayList<>(curr));
            
            while(!next.isEmpty()){
                queue.add(next.poll());
            }

            next.clear();
            curr.clear();
        }

        return list;
    }
}