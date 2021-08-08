/*
41. First Missing Positive
Hard

6493

1082

Add to List

Share
Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
 

Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
Accepted
522,434
Submissions
1,506,437

link --> https://leetcode.com/problems/first-missing-positive/
*/

// unique concept --> https://www.youtube.com/watch?v=-lfHWWMmXXM&ab_channel=RachitJain
// both expalined below

class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0 ; i < nums.length ; i++){
            int a = nums[i] - 1;
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[a])
                {
                int temp = nums[i];
                    nums[i] = nums[a];
                    nums[a]= temp;
                 a = nums[i] - 1;
            }
        }

        for (int i = 0; i < nums.length; i++){
            if (i+1 != nums[i]) return i + 1;
        }
        
        return nums.length + 1;
    }
}

// changing the index in order to get vals.
//  but not applicable if neg. no's are there for that we have to conv. into +ve
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean hasOne = false;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) hasOne = true;
            if (nums[i] <= 0) nums[i] = 1;
        }

        if (!hasOne) return 1;

        for (int i = 0; i < n; i++) {
            int j = Math.abs(nums[i]);
            if (j <= n) nums[j - 1] = -Math.abs(nums[j - 1]);
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i+1;
        }

        return n+1;
    }
}
// using hashset space O(n) and time is aslo O(n)
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet st = new HashSet();
        int mn = 1;
        for (int i = 0; i < nums.length; i++){
            st.add(nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++){
            if (st.contains(mn)){
                mn += 1;
                }}
            return mn;
    }
}