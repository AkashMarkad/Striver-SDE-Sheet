// Predecessor and Successor

// Predecessor - prev node of key in inorder Traversal
// Successor - next node of key in inorder traversal

// Approach 1:
// Do the Inorder travrsal it will be sorted
// Find the predecessor and successor

// Time Complexity  - O(n*n)
// Space Complexity - O(n)

// Approach 2: Travrse the inorder and find the next and prev node

// Time Complexity - O(n)
// Space Complexity - O(1)

// Approach 3: Binary Search Tree Property
// go according to the left and right node and return ans

// Time Complexity - O(h)
// Space Complexity -  O(1)


// Code

// This function finds predecessor and successor of key in BST.
// It sets pre and succ as predecessor and successor respectively
class GfG
{
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       // add your code here
       
       p.pre = null;
       s.succ = null;
       Node curr = root;
       while(curr != null){
           if(curr.data> key){
               s.succ = curr;
               curr = curr.left;
           }
           else if(curr.data < key){
               p.pre = curr;
               curr = curr.right;
           }
           else{
               if(curr.left != null){
                   p.pre = curr.left;
               }
               if(curr.right != null){
                   s.succ = curr.right;
               }
               curr = curr.left;
           }
       }
    }
}

// CodingStudio Solution : 

import java.util.* ;
import java.io.*; 
/*************************************************************
    Following is the Binary Tree node structure

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
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		// Write your code here.
        
        ArrayList<Integer> arr = new ArrayList<>();
        int pre = -1;
        int suc = -1;
        
        BinaryTreeNode<Integer> temp = root;
        while(temp!= null){
            if(key > temp.data){
                pre = temp.data;
                temp = temp.right;
            }else{
                temp = temp.left;
            }
        }
        
        temp = root;
        while(temp != null){
            if(key >= temp.data){
                temp = temp.right;
            }
            else{
                suc = temp.data;
                temp = temp.left;
            }
        }
        
        arr.add(pre);
        arr.add(suc);
        return arr;
	}
    
    
}
