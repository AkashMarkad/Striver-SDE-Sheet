// Populate Next Right pointers of Tree

// We need attach the nodes on the same level by next pointer is given
    
// Approach 1: Using Level Order Tarversal

// Attach the next pinter to the q.peek() and at the end attach it to null

// Code:

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null)    return null;
        Queue<Node> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            Node curr = null;
            for(int i=0;i<size;i++){
                
                curr = q.poll();
                curr.next = q.peek();
                if(curr.left != null)   q.offer(curr.left);
                if(curr.right != null)  q.offer(curr.right);
            }
            
            curr.next = null;
        }
        
        return root;
    }
}
