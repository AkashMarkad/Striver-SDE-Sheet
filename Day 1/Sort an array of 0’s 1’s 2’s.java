// We can solve this problem using three ways 
// 1. By Brute Force
// 2. By Counting sort - Count number of 0's, 1's and 2's and according to place the elements in the array
// 3. By Dutch National Flag Algorithm - It's Most optimal way to solve the dutch 012 sort. In this algorithm we take low, mid and high pointers. Initially low and mid assighned to 0 index and high assigned to the last index. And swap if mid at 0 then with the low and if mid at 2 then with high And if mid is 1 then increase mid by 1.

//Dutch National Flag Algorithm
public class Solution 
{
    public static void sort012(int[] arr)
    {
        //Write your code here
//         Arrays.sort(arr);
        int low=0,mid=0,high = arr.length-1;
        while(mid<=high){
            switch(arr[mid]){
                case 0:
                    int temp = arr[mid];
                    arr[mid] = arr[low];
                    arr[low] = temp;
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp1 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high]  =temp1;
                    high--;
                    break;
            }
        }
    }
}
