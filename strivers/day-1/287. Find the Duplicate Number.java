/*
287. Find the Duplicate Number
Medium

8550

895

Add to List

Share
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

 

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [1,1]
Output: 1
Example 4:

Input: nums = [1,1,2]
Output: 1
 

Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 

Follow up:

How can we prove that at least one duplicate number must exist in nums?
Can you solve the problem in linear runtime complexity?

link --> https://leetcode.com/problems/find-the-duplicate-number/

*/

// more effective soln. using concept of flipping into neg. no.
// neg. marking tech.
class Solution {
    public int findDuplicate(int[] nums) {
        int k = - 1;
        for (int i = 0; i < nums.length; i++){
            int ind = Math.abs(nums[i]);
            if (nums[ind] < 0) {
                k = ind; 
                break;}
            nums[ind] *= k;
        }
        return k;
    }
}

// less effective
class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap();
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            if (mp.containsKey(nums[i])){
                int val = mp.get(nums[i]) + 1;
                mp.put(nums[i], val);
            }else{
                mp.put(nums[i], 1);
            }
        }
        for (int j = 0; j < nums.length; j++){
            if (mp.get(nums[j]) > 1){
                ans = nums[j];
            }
        }
        return ans;
    }
}

// this problem can also be done by using the concept of teasing [0]*n list and searching of '2' by inc. acc. to index
// 1. also by sorting 3. also by hash set 4. binary search

class Solution {
    public int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int nxt = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = nxt;
        }
        return nums[0];
    }
}