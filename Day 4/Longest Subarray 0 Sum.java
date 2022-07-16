// Longest SubArray Having sum is 0
// Problem Link : https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

Approach 1: 
// Find all the Subarrays with 0 sum using Kadanes Algorithm
// Pick the subarray with max length 
// return the max length

// Time Comlexity: O(N^3)

// Approach 2: Optimal Approach
// Use HashMap to store the sum and index and accordingly traverse the array
// If Sum is exist in hahMap then nax = Math.max(i-hm.get(sum));
// Else hm.put(sum,i);
// Return max;

// Time Comlexity: O(N)
// Space Complexity: O(N)

// Code

// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer , Integer> hm = new HashMap<>();
        
        int maxLen = 0;
        int sum = 0;
        hm.put(sum , -1);
        
        for(int i = 0; i < n ; i++)
        {
            sum = sum + arr[i];
            if(!hm.containsKey(sum))
            {
                hm.put(sum , i);
            }
            else
            {
                maxLen = Math.max(maxLen , i-hm.get(sum));
            }
        }
        return maxLen;
    }
}
