// Kth Element of two sorted array 
// Given two Sorted array we need to return the kth element of the array

// Approach 1: Merge Sort
// Use merge sort and return the kth element
// Time Complexity - O(k)
// Space Complexity - O(1)

// Approach 2: Binary Search
// Same as previous proble i.e Median of two sorted array

// Time Complexity - O(log(Math.min(N1,N2)))
// Space Complexity - O(1)

// Code:

class Solution {
    public long kthElement( int nums1[], int nums2[], int n, int m, int k) {
        
        // int i = 0 , j = 0 , l = 0 ;
        
        // int a[] = new int[n+m];
    
        // while(i < n && j < m)
        // {
        //     if(arr1[i] < arr2[j])
        //     {
        //         a[l++] = arr1[i++];
                
        //     }
        //     else
        //     {
        //         a[l++] = arr2[j++];
        //     }
            
        // }
        
        // if(j == m)
        // {
        //     while(i < n)
        //     {
        //         a[l++] = arr1[i++];
        //     }
        // }
        
        // if( i == n)
        // {
        //     while(j < m)
        //     {
        //         a[l++] = arr2[j++];
        //     }
        // }
        
        // Long ans = new Long(a[k-1]);
        
        // return ans;
      
//       ---------------------------------------------------------------------------------------------------------------
      
        if(n>m)
            return kthElement(nums2,nums1,m,n,k);
        
        int low = Math.max(0,k-m);
        int high = Math.min(k,n);
        
        while(low <= high){
            
            int cut1 = (low+high) >> 1;
            int cut2 = k - cut1;
            
            int left1 = (cut1==0) ? Integer.MIN_VALUE: nums1[cut1-1];
            int left2 = (cut2==0) ? Integer.MIN_VALUE: nums2[cut2-1];
            int right1 = (cut1==n) ? Integer.MAX_VALUE: nums1[cut1];
            int right2 = (cut2==m) ? Integer.MAX_VALUE: nums2[cut2];
            
            if((left1<=right2) && (left2<=right1)){
                return Math.max(left1,left2);
            }
            else if(left1 > right2){
                high = cut1-1;
            }
            else{
                low = cut1+1;    
            }
            
        }
        return (long)1;
    }
}
