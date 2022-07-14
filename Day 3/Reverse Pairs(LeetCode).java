// Reverse the pairs such as condition is nums[i]>2*nums[j]
// Problem Link:- https://leetcode.com/problems/reverse-pairs/

// Approch 1: - Brute force 
// using two nested loop check for each elemnts and return count of satisfying conditions
// Ṭime Complexity:- o(n*n)
// Space Complexity:- O(n)

// Approach 2: using Merge sort
// Optimal Approach
// We can use merge sort technique to check whether first element satisfying condition after this all the elements satisfying conditon because we have to sort it

class Solution {
    
    int merge(int[] nums , int low , int mid , int high)
    {
        int cnt = 0;
        int j = mid+1;
        
        for(int i=low ; i <=mid ; i++)
        {
            while(j <= high && nums[i] > ( 2 * (long) nums[j]))
            {
                j++;
            }
            
            cnt += (j-(mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        int left = low , right = mid+1;
        
        while(left <= mid && right <= high)
        {
            if(nums[left] <= nums[right])
            {
                temp.add(nums[left++]);
            }
            else 
            {
                temp.add(nums[right++]);
            }
        }
        
        while(left <= mid)
        {
            temp.add(nums[left++]);
        }
        
        while(right <= high)
        {
            temp.add(nums[right++]);
        }
        
        for(int i= low ; i <= high ; i++)
        {
            nums[i] = temp.get(i-low);
        }
        
        return cnt;
    }
    
    int mergeSort(int[] nums , int low , int high)
    {
        if(low >= high) return 0;
        int mid = (low + high)/2;
        
        int inv = mergeSort(nums , low , mid);
        inv += mergeSort(nums , mid+1 , high);
        inv += merge(nums , low , mid , high);
        
        return inv;
    }
  
    public int reversePairs(int[] nums) {
       return mergeSort(nums , 0 , nums.length-1);
    }
} 


// Same Code but using ArrayList on the CodingStudio
// Problem Link : https://www.codingninjas.com/codestudio/problems/1112652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    static int merge(ArrayList<Integer> arr , int low , int mid , int high)
    {
        int cnt = 0;
        int j = mid+1;
        
        for(int i=low ; i <= mid ;i++)
        {
            while(j <= high && arr.get(i) > (2 * (long) arr.get(j)))
            {
                j++;
            }
           cnt += (j - (mid+1));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int left = low , right = mid+1;
        
        while(left <= mid && right <= high)
        {
            if(arr.get(left) <= arr.get(right))
            {
                ans.add(arr.get(left++));
            }
            else
            {
                ans.add(arr.get(right++));
            }
        }
        
        while(left <= mid)
        {
            ans.add(arr.get(left++));
        }
        
        while(right <= high)
        {
            ans.add(arr.get(right++));
        }
        
        for(int i=low ; i <= high ; i++)
        {
            arr.set(i , ans.get(i-low));
        }
        
        return cnt;
    }
    static int mergeSort(ArrayList<Integer> arr , int low , int high)
    {
        if(low >= high)    return 0;
        int mid = (low + high)/2;
        
        int inv = mergeSort(arr , low ,  mid);
        inv += mergeSort(arr , mid+1 , high);
        inv += merge(arr , low , mid , high);
        
        return inv;
    }
    
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        // Write your code here.
        
        return mergeSort(arr , 0 , arr.size()-1);
    }
}

// Time Complexity:- O(nlogn)
// Sapce Complexity:- O(n)
