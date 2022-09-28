// Maximum Path Between two leaves 

// Approach 1: Same as we find the height of the tree and also check the balanced binary tree
// We find the max of node.val + lh+ rh 
// We when return we return math.max(lh,rh)+node.val


// Code 

// Leetcode

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
    
    private int maxPathDown(TreeNode node , int[] maxValue){
        
        if(node == null)    return 0;
        
        int left = Math.max( 0 , maxPathDown(node.left , maxValue));
        int right = Math.max( 0 , maxPathDown(node.right , maxValue));
        
        maxValue[0] = Math.max(maxValue[0] , left+right+node.val);
        
        return Math.max(left , right) + node.val;
    }
    
    public int maxPathSum(TreeNode root) {
        
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        
        maxPathDown(root , maxValue);
        
        return maxValue[0];
    }
}

//CodingStuio

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the Tree node structure
	
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

************************************************************/

public class Solution {

    private static int maxPathDown(TreeNode node , int[] maxValue){
        
        if(node == null)    return 0;
        
        int left = Math.max( 0 , maxPathDown(node.left , maxValue));
        int right = Math.max( 0 , maxPathDown(node.right , maxValue));
        
        maxValue[0] = Math.max(maxValue[0] , left+right+node.data);
        
        return Math.max(left , right) + node.data;
    }
    
	public static long findMaxSumPath(TreeNode root) {
		// Write your code here.
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        
        maxPathDown(root , maxValue);
        
        return maxValue[0];
	}
}
