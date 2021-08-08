"""
416. Partition Equal Subset Sum
Medium

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
Accepted
314,621
Submissions
692,750

link --> https://leetcode.com/problems/partition-equal-subset-sum/

imp. link --> https://leetcode.com/problems/partition-equal-subset-sum/discuss/462699/Whiteboard-Editorial.-All-Approaches-explained.
"""

# Runtime: 172 ms, faster than 90.75% of Python3 online submissions for Partition Equal Subset Sum.
# Memory Usage: 28 MB, less than 53.46% of Python3 online submissions for Partition Equal Subset Sum.

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        hsh = {}
        tot = 0
        for ele in nums: tot += ele
        if (tot % 2 == 1): return False
        return self.canP(nums, 0, tot/2, hsh)
    
    def canP(self,nums, index, Sum, hsh):
        cur = (index, Sum)
        if cur in hsh: return hsh[cur]
        if (Sum == 0): return True
        if (Sum < 0 or index >= len(nums)): return False
        
        found = (self.canP(nums, index + 1, Sum - nums[index], hsh) or 
                    self.canP(nums, index + 1, Sum, hsh) )
        hsh[cur] = found
        return found
