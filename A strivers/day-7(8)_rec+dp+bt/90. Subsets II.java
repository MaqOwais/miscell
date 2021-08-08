/*
90. Subsets II
Medium

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
Accepted
391,068
Submissions
771,707

link --> https://leetcode.com/problems/subsets-ii/
*/

// Success
// Details 
// Runtime: 1 ms, faster than 99.62% of Java online submissions for Subsets II.
// Memory Usage: 39.2 MB, less than 71.92% of Java online submissions for Subsets II.

// backtrack problem..
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lis = new ArrayList<>();
        bt(nums, 0, lis, new ArrayList<>());
        return lis;
    }
    private void bt(int[] nums, int ind, List<List<Integer>> lis, List<Integer> cur) {
        lis.add(new ArrayList<>(cur));

        for(int i = ind; i < nums.length; i++) {
            if(i > ind && nums[i] == nums[i-1]) continue;   // avoid duplicates
            cur.add(nums[i]);
            bt(nums, i + 1, lis, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
