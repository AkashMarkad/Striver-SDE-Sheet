// Nth Root of the number
// Input: n=3, m=27
// Output: 3.000000

// We need find the 3rd root of 27 i.e 27^(1/3)

// Approach: Binary Search
// Steps: low =1.0 and high=m  and find the mid if mid>m then high=mid else low=mid do until the difference between the low and high is less than the 10^-6 

// Time Complexity - O(N*logm^d) d-decomal
// Space Complexity - O(1)

// Code:

public class Solution {
    
    public static double multiply(double num, int n){
        double ans = 1.0;
        for(int i=1;i<=n;i++){
            ans *= num;
        }
        return ans;
    }
    
    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
        double low = 1.0;
        double high = m;
        double eps = 1e-9;
        
        while((high-low)>eps){
            double mid = (low+high)/2.00000;
            if(multiply(mid,n) < (double)m)
                low = mid;
            else 
                high = mid;
        }
        return low;
        
//         It can be one answer
//         return Math.pow(m,(double)(1.0/n));
    }
}
