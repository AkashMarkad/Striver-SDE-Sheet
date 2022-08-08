// Alloacate Minimum number of Pages
// Number of students and books array are given having pages
// We need to return minimum number of pages

// Condition: One book assigned to only one student
//            Books should be allocted contiguously

// Approach : Binary Search
// initailaly our search space will be low  = minimum element from the array and high = sum of element of array
// Accordingly calculate the mid and check is possible to alloacate the books to M student by considering the barrier

// Time Complexity - O(N*logN)
// Space Complexity - O(1)

//Code:

import java.util.*;

public class Solution {
    
    static boolean allocationIsPossible(int barrier, int[] A , int n){
        
        int allocatedStudent = 1;
        int pages = 0;
        
        for(int i=0;i<A.length;i++){
            if(barrier<A[i])    return false;
            if(pages+A[i] > barrier){
                allocatedStudent++;
                pages = A[i];
            }else{
                pages += A[i];
            }
        }
        if(allocatedStudent > n)    return false;
        else     return true;
        
    }
    
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        // Write your code here.
        int low = Integer.MAX_VALUE;
        int high = 0;
        int res = -1;
        
        for(int i=0;i<time.length;i++){
            if(low > time[i])    low = time[i];
            high += time[i];
        }
        
        while(low <= high){
            int mid = (low+high) >> 1;
            if(allocationIsPossible(mid,time,m)){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return res;
    }
}
