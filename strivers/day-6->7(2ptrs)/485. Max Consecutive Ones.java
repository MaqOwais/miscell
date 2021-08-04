/*
485. Max Consecutive Ones
Easy

1567

389

Add to List

Share
Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
Accepted
459,196
Submissions
861,352

link --> https://leetcode.com/problems/max-consecutive-ones/
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int mx = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1) cnt++;
            else cnt = 0;
            if (cnt > mx) mx = cnt;
        }
        return mx;
    }
}


// compressed way

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0 ,current_ones =0; 
        for(int n : nums)
            max=Math.max(max,current_ones = n ==0 ? 0 : current_ones + 1);
        return max;
    }
}