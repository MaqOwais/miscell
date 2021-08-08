/*
46. Permutations
Medium

7016

140

Add to List

Share
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
Accepted
881,649
Submissions
1,284,230

link --> https://leetcode.com/problems/permutations/
*/

class Solution {
    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        bt(nums, new ArrayList());
        return list;}

    private void bt(int[] nums, List<Integer> cur){
        if (nums.length == cur.size()) list.add(new ArrayList(cur));
        for (int i = 0; i < nums.length ; i++){
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            bt(nums, cur);
            cur.remove(cur.size() - 1);
        }
    }
}


