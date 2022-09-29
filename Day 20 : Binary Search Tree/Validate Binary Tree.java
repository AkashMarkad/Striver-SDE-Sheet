// Validate Binary Tree

// Approach : MIN-MAX Method 
// reursively check the the node is between the range 
// Initial range is [MIN,MAX]
// left  - range is [MIN,root.val]
// right - range is [root.val, MAX]

// if any node violated the condtion then return false
// else return true

// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:

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

    public boolean isValidBST(TreeNode root , long minVal , long maxVal){
        if(root == null)    return true;

        if(root.val >= maxVal || root.val <= minVal)    return false;

        return isValidBST(root.left , minVal , root.val) && isValidBST(root.right , root.val , maxVal);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root , Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
