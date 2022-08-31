// LeftView of Binary Tree 
// Input:
//   1
//  /  \
// 3    2
// Output: 1 3


// Approach 1: Level Order Traversal Using Queue
// Time Complexity - O(n)
// Space Complexity - O(n)

// Approach 2: Recursive
// Recursive call the and also increase the level at the each level 
// if level==ans.size() then add element to ans

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Tree
{
    public static void getLeftView(Node root , ArrayList<Integer> ans , int level){
        
        if(root == null)    return ;
        
        if(level == ans.size())     ans.add(root.data);
        
        getLeftView(root.left , ans , level+1);
        getLeftView(root.right , ans , level+1);
    }
    
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
      // Your code here
      ArrayList<Integer> ans = new ArrayList<>();
      
      getLeftView(root , ans , 0);
      return ans;
    }
}

