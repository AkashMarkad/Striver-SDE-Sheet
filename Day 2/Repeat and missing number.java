// In array of n elements one element is repeating and other is missing
// We can find this using Three Approaches
// 1) Using Counting sort method by using extra array and checking the frequency
// 2) By using the Math calculations
// 3) By using XOR

// Below Solution by using extra array and checking frequency
//Problem Link : https://www.codingninjas.com/codestudio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
                
        int len = arr.size();
        int[] temp = new int[len+1];
        int[] ans  = new int[2];
        
        for(int i=0;i<len;i++)
        {
            int val = arr.get(i);
            temp[val] += 1;
        }
      
//         for(int a : temp)
//         {
//             System.out.println(a);
//         }
        
        for(int i=0;i<temp.length;i++)
        {
            if(temp[i]==0)
            {
                ans[0] = i;
            }
            else if(temp[i] > 1)
            {
                ans[1] = i;
            }
        }
        
        return ans;
    }
}
