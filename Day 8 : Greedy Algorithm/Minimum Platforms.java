// Minimum Platforms

// Problem Link : 1) https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
//                2) https://www.codingninjas.com/codestudio/problems/799400?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

// Approach:
// steps: 1) Sort the both array individually
//        2) Now use two pinter approach one is used to travrse the arraival array and other is departure array
//        3) if arriavl time is less than the departure time increse the platform count else decrese the platform count
//        4) return the maximum platform count

// Time complexity - O(2NlogN) + O(2N)
// Space Complexity - O(1)

// Code 

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int plat_needed = 1 , result = 1;
        int i = 1 , j = 0;
        
        while(i < n && j < n){
            
            if(arr[i] <= dep[j]){
                plat_needed++;
                i++;
            }
            else {
                plat_needed--;
                j++;
            }
            
            // if(plat_needed > result)
            //     result = plat_needed;
            
            result =  Math.max(result , plat_needed);
        }
        
        return result;
        
    }
    
}
