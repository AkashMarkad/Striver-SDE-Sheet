// Kth Largest Element form BST 

// Approach 1: Do recursive travrsal but go on right if right is null go on left maintain counter if count==k return element

// Time Complexity - O(n)
// Space Complexity - O(n)

// code:


import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Search Tree node structure

	class TreeNode<T> {
	    public T data;
	    public TreeNode<T> left;
	    public TreeNode<T> right;

	    TreeNode(T data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

*************************************************************/

import java.util.ArrayList;

public class Solution {
    
    public static int find(TreeNode<Integer> root , int[] k){
        if(root == null)    return -1;
        
        int right = find(root.right , k);
        
        if(right != -1)    return right;
        
        k[0]--;
        if(k[0]==0)    return root.data;
        
        return find(root.left , k);
    }
    
	public static int KthLargestNumber(TreeNode<Integer> root, int k) {
		// Write your code here.
        
        return find(root , new int[]{k});
	}
}





