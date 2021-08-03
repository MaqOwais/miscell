/*
1. Two Sum
Easy

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 1;
        HashMap<Integer, Integer> di = new HashMap<Integer, Integer>();
        di.put(nums[0],0);
        int[] vr = {0};
        while (i < nums.length){
            int comp = target - nums[i];
            if (di.containsKey(comp)){
                int j = di.get(comp);
                int[] k = {i, j};
                return k;
            }
            di.put(nums[i],i);
            ++i;
        }
        return vr;
    }
}


// other way (see it some other time)

/* Java, O(nlogn), beats  98.85%

// link --> https://leetcode.com/problems/two-sum/discuss/7/Java-O(nlogn)-beats-98.85

The general idea is:

step1 : copy an array, and sort it using quick sort, O(nlogn)

step2 : using start and end points to find a, b which satifys a+b==target, O(n)

step3 : find the index of a, b from origin array, O(n)

note: in step3, you should judge whethour a==b, if true, you must find the second index of b.

if you have any higher efficiency solution, contact me, please.
https://github.com/yangliguang

As follows:
*/
//O(nlogn)
class Solution {
        public int[] twoSum_n2(int[] nums, int target) {
	    	if(nums == null)
	    		return null;
	    	int[] nums2 = Arrays.copyOf(nums, nums.length);
	    	Arrays.sort(nums2);
	    	int a = 0, b = 0;
	    	int start = 0, end = nums2.length-1;
	    	//find two nums
	    	while(start<end){
	    		int sum = nums2[start] + nums2[end];
	    		if(sum < target)
	    			start++;
	    		else if(sum > target)
	    			end--;
	    		else{
	    			a = nums2[start]; b = nums2[end];
	    			break;
	    		}
	    	}
	    	//find the index of two numbers
	    	int[] res = new int[2];
	    	for(int i = 0; i < nums.length; i++){
	    		if(nums[i] == a){
	    			res[0] = i;
	    			break;
	    		}
	    	}
	    	if(a != b){
	    		for(int i = 0; i < nums.length; i++){
		    		if(nums[i] == b){
		    			res[1] = i;
		    			break;
		    		}
		    	}
	    	} else{
	    		for(int i = 0; i < nums.length; i++){
		    		if(nums[i] == b && i != res[0]){
		    			res[1] = i;
		    			break;
		    		}
		    	}
	    	}
	    	
	    	return res;
	    }