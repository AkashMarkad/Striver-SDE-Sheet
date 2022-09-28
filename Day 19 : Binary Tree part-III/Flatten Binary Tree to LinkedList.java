// Flatten Binary Tree to LinkedList

// Approach 1 - Recursive

// Time Complexity --> O(N)
// Space Complexity --> O(N)

// LeetCode Solution :

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
    
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        
        if(root==null)
            return;
        
        flatten(root.right);    //traverse till right most.
        flatten(root.left);     //go to left of right most
        root.left=null;         //Set left as null
        root.right=pre;         //set right to previously traversed node
        pre=root;               //set prev to current node.
    }
}

// Appeoach 2 - Stack
// Simillar to above approach

// Approach 3 : Morris Traversal

// Time Complexity --> O(N)
// Space Complexity --> O(1)
// Code : 

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
        
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode pred = curr.left;
                while(pred.right != null){
                    pred = pred.right;
                }
                pred.right = curr.right;
                curr.right = curr.left;
            }
            curr = curr.right;
        }
       
        curr = root;
        while(curr != null){
            curr.left = null;
            curr = curr.right;
        }
    }
}
