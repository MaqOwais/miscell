/*
560. Subarray Sum Equals K
Medium

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107

*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> dic = new HashMap();
        int cnt = 0;
        int cursum = 0;
        for (int i = 0; i < nums.length; i++){
            cursum += nums[i];
            if (cursum == k) cnt++;
            if (dic.containsKey(cursum - k)) cnt += dic.get(cursum-k);

            if (dic.containsKey(cursum)){
                int val = dic.get(cursum) + 1;
                dic.put(cursum, val);
            }else{
                dic.put(cursum, 1);
            }
        }

        return cnt;
    }
}


