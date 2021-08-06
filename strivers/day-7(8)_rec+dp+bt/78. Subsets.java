/*
78. Subsets
Medium

6656

118

Add to List

Share
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
Accepted
825,797
Submissions
1,227,734

link --> https://leetcode.com/problems/subsets/
*/

// backtrack variation..

class Solution {
    private List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        
        bt(nums, 0, new ArrayList<Integer>());
        return this.res;
    }
    
    private void bt(int[] nums, int start, List<Integer> li){
        this.res.add(new ArrayList<Integer>(li));
        for (int i = start; i < nums.length; i++){
            li.add(nums[i]);
            bt(nums, i + 1, li);
            li.remove(li.size() - 1);
        }
    }
    
}