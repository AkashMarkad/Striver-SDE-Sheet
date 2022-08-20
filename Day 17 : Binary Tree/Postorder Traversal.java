// Postorder Traversal
// Input: root = [1,null,2,3]
// Output: [3,2,1]

// Problem LeetCode : https://leetcode.com/problems/binary-tree-postorder-traversal/

// Approach 1: recursive
// Left Right Root

// Time Complexity - O(n)
// Space Complexity - O(n)

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
    
    
    public void postOrder(TreeNode root , List<Integer> ans){
        
        if(root==null)  return;
        
        postOrder(root.left , ans);
        postOrder(root.right , ans);
        ans.add(root.val);
        
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        postOrder(root , ans);
        
        return ans;
    }
}
