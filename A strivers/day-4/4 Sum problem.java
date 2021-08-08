/*

18. 4Sum
Medium

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

link --> https://leetcode.com/problems/4sum/submissions/

*/
// brute force approach
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> liofli = new ArrayList();
    
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                for (int k = j + 1; k < nums.length; k++){
                    for (int l = k + 1; l < nums.length; l++){
                         int p = nums[i] + nums[j] + nums[k] + nums[l];
                         if ((p) == target){
                                List<Integer> li = new ArrayList();
                                li.add(nums[i]);
                                li.add(nums[j]);
                                li.add(nums[k]);
                                li.add(nums[l]);
                             if (! liofli.contains(li)) liofli.add(li);
                        }
                    }
                }   
            }
        }
        return liofli;
    }
}


// Clean accepted java O(n^3) solution based on 3sum
// https://leetcode.com/problems/4sum/discuss/8575/Clean-accepted-java-O(n3)-solution-based-on-3sum
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length; j++){
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int t = target - nums[i] - nums[j];
                int m = j+1, n = nums.length-1;
                while(m < n){
                    if(nums[m]+nums[n] == t){
                        Integer[] temp = {nums[i], nums[j], nums[m], nums[n]};
                        res.add(Arrays.asList(temp));
                        m++;
                        n--;
                        while(m < nums.length && nums[m] == nums[m-1]) m++;
                        while(n >= 0 && nums[n] == nums[n+1]) n--;
                    } else if(nums[m]+nums[n] < t){
                        m++;
                    } else n--;
                }
            }
        }
        return res;
    }
}

