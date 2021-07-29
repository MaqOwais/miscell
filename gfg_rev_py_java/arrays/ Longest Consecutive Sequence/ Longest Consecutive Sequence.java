/*
Longest consecutive subsequence 
Medium Accuracy: 48.9% Submissions: 65853 Points: 4
Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 

Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers. 


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).


Constraints:
1 <= N <= 105
0 <= a[i] <= 105

link --> https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1#
*/


// other ways to do this same problem is by sorting then do loop to get req. ans

// this is better approach
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i: nums) hs.add(i);
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            if (!hs.contains(nums[i] -1)){
                int j = nums[i];
                while (hs.contains(j)) j++;
                ans = Math.max(ans, j - nums[i]);
            }
        }
        return ans;   
    }
}

// faster soln of java

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int num: nums) set.add(num);
        int max = 1;
        for(int num: nums) {
            if(set.remove(num)) {//num hasn't been visited
                int val = num;
                int sum = 1;
                while(set.remove(val-1)) val--;
                sum += num - val;
                
                val = num;
                while(set.remove(val+1)) val++;
                sum += val - num;
                
                max = Math.max(max, sum);
            }
        }
        return max;
    }
    }


