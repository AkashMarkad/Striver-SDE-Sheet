// Merge Overlapping Intervals and return the remaining intervals
// First we have to sort the given Array in Ascending order
// Then compare the end of first with the start of second and merge is less

// Leetcode Problem Link : https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length==0 || intervals == null)
        {
            return res.toArray(new int[0][]);
        }
        
        Arrays.sort(intervals , (a , b) -> a[0]-b[0]);
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int[] i : intervals)
        {
            if(i[0] <= end)
            {
                end = Math.max(end , i[1]);
            }
            else
            {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        
        res.add(new int[]{start , end});
        
        return res.toArray(new int[0][]);
    }
}



// 2nd Solution on CodeStudio
// https://www.codingninjas.com/codestudio/problems/699917?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
// Using Special Data type Interval

/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        // write your code here.
        
         List<Interval> res = new ArrayList<>();
        
        
        Arrays.sort(intervals , (a , b) -> a.start-b.start);
        
        int start = intervals[0].start;
        int end = intervals[0].finish;
        
        for(Interval i : intervals)
        {
            if(i.start <= end)
            {
                end = Math.max(end , i.finish);
            }
            else
            {
                res.add(new Interval(start , end));
                start = i.start;
                end = i.finish;
            }
        }
        
        res.add(new Interval(start , end));
        return res;
    }
}
