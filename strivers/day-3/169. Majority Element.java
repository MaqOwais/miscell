/*
169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1
 

Follow-up: Could you solve the problem in linear time and in O(1) space?

link --> https://leetcode.com/problems/majority-element/

*/

// Runtime: 1 ms, faster than 99.89% of Java online submissions for Majority Element.
// Memory Usage: 42.4 MB, less than 85.58% of Java online submissions for Majority Element.
// Next challenges:

// best possible soln ( Moore voting algorithm)
class Solution {
    public int majorityElement(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0) ret = num;
            if (num!=ret) count--;
            else count++;
        }
        return ret;
}
}


// using hashmap
class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> mp = new HashMap();
        
        for (int i = 0; i < nums.length; i++){
            if (mp.containsKey(nums[i])){
                int v = mp.get(nums[i]) + 1;
                if (v > nums.length/ 2) return nums[i];
                mp.put(nums[i], v);
                
            }else{
                mp.put(nums[i], 1);
            }
        }
            return 0;
            
    }
}