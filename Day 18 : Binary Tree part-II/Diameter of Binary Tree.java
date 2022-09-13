// Diameter of Binary Tree 
// Diameter - Longest path between the two nodes
//          - No need that the path will be pass from the root

// Approach 1: Brute Force
// Calculate the Height for at each node left + right and return the max of it

// Time Complexity - O(n*n)
// Space Complexity - O(n)

// Approach 2: Optimal Approach Recursive
// calculate the left + right in same recursion

// Time Complexity  - O(n)
// Space Complexity - O(n)

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
    
    private int findHeight(TreeNode root , int[] diameter ){
        
        if(root==null)  return 0;
        
        int lh = findHeight(root.left , diameter);
        int rh = findHeight(root.right , diameter);
        
        diameter[0] = Math.max(diameter[0] , lh + rh);
        
        return 1 + Math.max(lh , rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root==null)  return 0;
        int[] diameter = new int[1];
        findHeight(root , diameter);
        return diameter[0];
        
    }
}
