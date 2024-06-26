/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // Node copy = new Node(node.val)
        // Queue<Node> queue
        // add node to queue

        // Map<Node,Node> map so that we can point the node val to the copy val, 
        // map.put(node,copy);
        // and check if we have been here


        // while queue isn't empty
        // curr = queue.poll
        
        // copyNode = map.get(curr);

        // for Node n : curr.children
        // copyNode.children.add(new Node(n.val));
        // map.put(n,copyNode.children.get(copyNode.children.length-1));
        // queue.offer(n);
        
        // return copy
        if(node == null) return null;

        Node copy = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        Map<Node,Node> map = new HashMap<>();
        map.put(node,copy);

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            Node copyNode = map.get(curr);

            for(Node n : curr.neighbors){
                if(!map.containsKey(n)){
                    map.put(n,new Node(n.val));
                    queue.offer(n);
                }
                copyNode.neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}