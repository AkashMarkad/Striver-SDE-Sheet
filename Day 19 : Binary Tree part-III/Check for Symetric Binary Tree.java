// Symetric Binary Tree 
// left subtree mirror image is visible on right subtree
// travrse the left and right subtree of the tree
// if any condition return false 

// Approach :
// Find for each node and return true or false

// Code -

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
    
    private boolean isSymmetricfun(TreeNode left , TreeNode right){
        if(left == null || right == null)   return (left == right);
        
        if(left.val != right.val)   return false;
        
        return isSymmetricfun(left.left , right.right) && isSymmetricfun(left.right , right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetricfun(root.left , root.right);
        
    }
}
