/*
416. Partition Equal Subset Sum
Medium

5053

96

Add to List

Share
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

*/

// brute force approach, recursion
class Solution {
    public boolean canPartition(int[] nums) {
        int tot = 0;
        for (int e: nums) tot += e;
        if (tot%2 != 0) return false;

        return canP(nums, tot, 0, 0);
    }
    // https://www.youtube.com/watch?v=3N47yKRDed0&t=380s&ab_channel=KevinNaughtonJr. for exp
    private boolean canP(int[] nums, int total, int index, int sum){
        if (sum*2 == total) return true;
        if (sum > total/2 || index >= nums.length) return false;
        // we here consider taking sum and not taking since we could be in need for skiped no.s also
        // so analogy a tree 
        // time complexity -> O(2**N)
        return canP(nums, total, index + 1, sum)||canP(nums, total, index + 1, sum + nums[index]);
    }
    
}

// dp == recursion without unnecessary calls


class Solution {
    public boolean canPartition(int[] nums) {
        int tot = 0;
        for (int e: nums) tot += e;
        if ((tot & 1) == 1) return false;

        return canP(nums, tot/2, 0, 0, new HashMap<String,Boolean>());
    }
    
    private boolean canP(int[] nums, int total, int index, int sum, HashMap<String, Boolean> state){
        String cur = index + "" + sum;
        if (state.containsKey(cur)) return state.get(cur);
        if (sum == total) return true;
        if (sum > total || index >= nums.length) return false;
        // here by keeping sum + nums[index] we save a lot of time since we dont need to go v. down to acheive the result a lot of times.

        boolean found = canP(nums, total, index + 1, sum + nums[index], state)||canP(nums, total, index + 1, sum, state);
        
        state.put(cur, found);

        return found;
    }
    
}

// making init var.(lil. less efficient) using hashmap
class Solution {
    private HashMap<String, Boolean> state = new HashMap<String, Boolean>();

    public boolean canPartition(int[] nums) {
        int tot = 0;
        for (int e: nums) tot += e;
        if ((tot & 1) == 1) return false;

        return canP(nums, 0, tot/2);
    }
    
    private boolean canP(int[] nums, int index, int sum){
        String cur = index + "" + sum;

        if (this.state.containsKey(cur)) return state.get(cur);
        if (sum == 0) return true;
        if (sum < 0 || index >= nums.length) return false;

        boolean found = canP(nums, index + 1, sum - nums[index]) || canP(nums, index + 1, sum);

        this.state.put(cur, found);

        return found;
    }
}


// using 2 d array (nxt time try delving more into this process)
// 

class Solution {


public boolean canPartition(int[] nums) {
	int total = 0;
	for(int i : nums) total+=i; // compute the total sum of the input array
	if(total%2 != 0) return false; // if the array sum is not even, we cannot partition it into 2 equal subsets 
	int max = total/2; // the maximum for a subset is total/2
	int[][] results = new int[nums.length][max]; // integer matrix to store the results, so we don't have to compute it more than one time
	return isPartitionable(max,0,0,nums,results);
}

public boolean isPartitionable(int max,int curr, int index, int[] nums, int[][] results) {
	if(curr>max || index>nums.length-1) return false; // if we passed the max, or we reached the end of the array, return false
	if(curr==max) return true; // if we reached the goal (total/2) we found a possible partition
	if(results[index][curr]==1) return true; // if we already computed teh result for the index i with the sum current, we retrieve this result (1 for true)
	if(results[index][curr]==2) return false; // if we already computed teh result for the index i with the sum current, we retrieve this result (2 for false)
	boolean res = isPartitionable(max, curr+nums[index], index+1, nums, results) || isPartitionable(max, curr, index+1, nums, results); // else try to find the equal partiion, taking this element, or not taking it
	results[index][curr] = res ? 1 : 2; // store the result for this index and this current sum, to use it in dynamic programming
	return res;
}

}