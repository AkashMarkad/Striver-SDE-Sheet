// Check Binary tree of mirror of itself

// Approach : Using level order travrsal swap the left and right node of the each node
// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
               
        Queue<Node> q = new LinkedList<>();
        
        q.offer(node);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                
                Node temp = q.poll();
                
                if(temp != null){
                    Node n = temp.left;
                    temp.left = temp.right;
                    temp.right = n;
                }
                
                if(temp.left != null)   q.offer(temp.left);
                if(temp.right != null)  q.offer(temp.right);
            }
        }
      
    }
}

// Solution 2 -- 

class Solution {
    // Function to convert a binary tree into its mirror tree.
    void mirror(Node node) {
        // Your code here
        
        if(node == null)
        {
            return ;
        }
            
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    
        mirror(node.right);
        mirror(node.left);
      
    }
}
