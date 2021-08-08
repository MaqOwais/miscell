/*
31. Next Permutation
Medium

6488

2138

Add to List

Share
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
Accepted
559,216
Submissions
1,627,817

link --> https://leetcode.com/problems/next-permutation/

link --> https://www.nayuki.io/res/next-lexicographical-permutation-algorithm/next-permutation-algorithm.svg
(for understanding the prob)

*/


class Solution {
    public void nextPermutation(int[] nums) {
        int gold = nums.length - 1;
        while (gold > 0 && nums[gold] <= nums[gold - 1]) gold--;
        if (gold == 0) {
            reverse(nums, 0, nums.length - 1); 
            return;}
        int pre_i = gold - 1;
        for (int k = nums.length - 1; k >=0; k--){
            if (nums[pre_i] < nums[k]){
                swap(nums, k , pre_i);
                break;
            }
        }
        
        reverse(nums, gold, nums.length - 1);
        
    }
    
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
    public void reverse(int[] nums, int m,int n){
        while(m < n){
            swap(nums, m++, n--);
        }
    } 
    
}