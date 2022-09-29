// Convert Sorted Array to Binary Search Tree

// As we know that the left elements are smaller than the root and right elemnents are greater than the root 
// We need to balnced binary tree i.e no any node have the diff between right and right subtree is more than one

// Approch: 
// mid will be the root and recursively call the function for the left and the right subtree and check update the start and the end index accordingly add the left and the right 

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
    public TreeNode sortedArrayToBST(int[] nums) {
    
        return ConvertBST(nums,0, nums.length-1) ;
    }

    private TreeNode ConvertBST(int[] nums, int left, int right){
        
        if (left > right) return null;
        int mid = (right + left) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = ConvertBST(nums, left, mid - 1);
        root.right = ConvertBST(nums, mid + 1, right);
        
        return root;
    }
}
