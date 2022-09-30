// Pair Sum In BST 

// Given Binary tree and target sum we need to check pair of the nodes of this sum is present or not if present return true else return false

// Apprach 1: Do Inorder Traversal then we will get a sorted array      
//            Now do the two pointer approach to find the two sum
//            return true if exit else return false

// Time Complexity - O(n)+O(n)
// Space Complexity - O(n)

// Code:


import java.util.* ;
import java.io.*; 
/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/
public class Solution {
    
    public static void inorder(BinaryTreeNode root , ArrayList<Integer> arr){
        if(root == null)    return;
        inorder(root.left , arr);
        arr.add(root.data);
        inorder(root.right , arr);
    }
	public static boolean pairSumBst(BinaryTreeNode root, int k) {
		// Write your code here.
        if(root == null || (root.left == null && root.right == null))    return false;
        
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root , arr);
        int low = 0;
        int high = arr.size()-1;
        while(low < high){
            if((arr.get(low)+arr.get(high))==k)    return true;
            else if((arr.get(low)+arr.get(high))<k)    low++;
            else    high--;
        }
        return false;
	}
}




// Approach 2: BST Iterator

// BST Iterator will be return us incerse elemnt and also if we do this in revrse order then it will return decresing elements so we now able to use the two ppointer appaoch on it

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

public class BSTIterator{
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse = true; 

    public BSTIterator(TreeNode root, boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }

    // return whether we have a next smaller number 
    public boolean hasNext(){
        return !st.isEmpty();
    }

    // return the next smallest number 
    public int next(){
        TreeNode temp = st.pop();
        if(reverse == false)    pushAll(temp.right);
        else pushAll(temp.left);
        return temp.val;
    }


    private void pushAll(TreeNode node){
        while(node != null){
            st.push(node);
            if(reverse == true){
                node = node.right;
            }
            else
                node = node.left;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)    return false;
        BSTIterator l = new BSTIterator(root , false);
        BSTIterator r = new BSTIterator(root , true);

        int i= l.next();
        int j = r.next();
        while(i < j){
            if(i + j == k)  return true;
            else if(i + j < k)  i = l.next();
            else    j = r.next();
        }
        return false;
    }
}
