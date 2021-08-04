/*
15. 3Sum
Medium

12161

1186

Add to List

Share
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
Accepted
1,413,430
Submissions
4,867,971

link --> https://leetcode.com/problems/3sum/

*/

// Runtime: 17 ms, faster than 93.47% of Java online submissions for 3Sum.
// Memory Usage: 42.7 MB, less than 88.09% of Java online submissions for 3Sum.

// 2 pointer plus sorted plus optimal soln.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList();
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int j = i + 1, k = nums.length - 1;  
        int target = -nums[i];
        while (j < k) {
            int req = nums[j] + nums[k];
            if (nums[i] > 0) break;
            if (req == target) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++; k--;
                while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
            } else if (req > target) k--;
              else j++;
        }
    }
    return res;
}
}

// Success
// Details 
// Runtime: 16 ms, faster than 97.61% of Java online submissions for 3Sum.
// Memory Usage: 42.6 MB, less than 93.05% of Java online submissions for 3Sum.

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lis = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1, target = -nums[i];
            while (j < k){
                if (nums[i] > 0) break; // since sorted so removing redundancy
                int req = nums[k] + nums[j];
                if (req == target){
                    lis.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++; k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;}
                else if (req > target) k--;
                else j++;
            }
        }
        return lis;
    }
}

// Runtime: 2296 ms, faster than 5.01% of Java online submissions for 3Sum.
// Memory Usage: 44 MB, less than 25.84% of Java online submissions for 3Sum.

// for loop on 2sum using hashmap
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++){
            int target = - nums[i];
            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
            
            for (int j = i + 1; j < nums.length; j++){
                int req = target - nums[j];
                if (hm.containsKey(req)){
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(nums[i]);
                    li.add(req);
                    li.add(nums[j]);
                    if (!ls.contains(li)) ls.add(li);
                }
                    hm.put(nums[j], 1);
            }
        }
        return ls;
    }
}







// (315 / 318 passed)brute force method
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] + nums [j] + nums[k] == 0){
                        List<Integer> li = new ArrayList<Integer>();
                        li.add(nums[i]);
                        li.add(nums[j]);
                        li.add(nums[k]);
                        if (! ls.contains(li)) ls.add(li);
                    }
                }
            }
        }
        return ls;
    }
}