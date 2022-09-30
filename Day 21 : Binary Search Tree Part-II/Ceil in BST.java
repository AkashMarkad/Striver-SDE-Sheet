// Ceil in BST 

// Ceil in BST - Lowest value which is greater than equal to key

// Problem Link : 1) GFG : https://practice.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
//                2) CodingStudio : https://www.codingninjas.com/codestudio/problems/920464?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

//Code:

import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public  static int findCeil(TreeNode<Integer> root, int x) {

        // Write your code here
        int ceil = -1;
        while(root != null){
            if(root.data == x){
                ceil = root.data;
                return ceil;
            }
            
            if(x < root.data){
                ceil = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceil;

    }
}
