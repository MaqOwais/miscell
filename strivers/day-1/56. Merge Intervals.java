/*
56. Merge Intervals
Medium

8531

409

Add to List

Share
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

link--> https://leetcode.com/problems/merge-intervals/

*/

// took lot of efforts to get it.
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> li  = new ArrayList();

        li.add(intervals[0]);
        int j = 1; 
        int t = 0;

        while (j < intervals.length){
            if (li.get(t)[1] < intervals[j][0])
                 {li.add(intervals[j]);
                t++;}
            else 
               { li.get(t)[1] = Math.max(li.get(t)[1], intervals[j][1]);
                 j++;}
        }

        int[][] ret = new int[t + 1][1];
        for (int i = 0; i <=t ; i++) ret[i] = li.get(i);

        return ret;
     }
 }