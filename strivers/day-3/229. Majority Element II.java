/*
229. Majority Element II
Medium

3131

232

Add to List

Share
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109

link --> https://leetcode.com/problems/majority-element-ii/

*/

// big soln. using hash map
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap();
        List<Integer> mp1 = new ArrayList();
        if (nums.length == 1) {mp1.add(nums[0]);}
        else if (nums.length == 2) {
            if (nums[0] != nums[1])
                {mp1.add(nums[0]);
                mp1.add(nums[1]);}
            else {mp1.add(nums[0]);}
        }else
            {for (int i = 0; i < nums.length; i++){
                if (mp.containsKey(nums[i])){
                    int v = mp.get(nums[i]) + 1;
                    mp.put(nums[i], v);

                }else{
                    mp.put(nums[i], 1);}
                }
             
                for (int i: mp.keySet()){
                    if (mp.get(i) > nums.length/3) 
                        mp1.add(i);
                }
            }
            return mp1;
    }
}