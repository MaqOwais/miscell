/*
189. Rotate Array
Medium

5187

971

Add to List

Share
Given an array, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
Accepted
735,681
Submissions
1,996,332

link --> https://leetcode.com/problems/rotate-array/

*/

// longest way time complexity = O(n*k) and space O(1)

class Solution {
    public void rotate(int[] nums, int k) {
        int l_ind = nums.length - 1;
        for (int i = 0; i < k; i++){
            
            int l = nums[l_ind];
            for (int j = 0; j <= l_ind ; j++){
                int s = nums[j];
                nums[j] = l;
                l = s;
            }
            
            
        }
    }
}


// using extra space S(n) and time complexity O(n)
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n==1) return;
        k = k % n;
        int[] nums1 = new int[n];
        int j = 0;

        for (int p = n - k; p < n; p++ ) nums1[j++] = nums[p] ; 

        for (int s = 0; s < n - k; s++) nums1[j++] = nums[s];

        for (int z = 0 ; z < n ; z++) nums[z] = nums1[z];
    }
}


// using extra space S(n) and time complexity O(n)

class Solution 
{
public void rotate(int[] nums, int k) 
{   int n = nums.length;
    k %= n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
}

public void reverse(int[] nums, int start, int end) 
{
    while (start < end) 
	{
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
 }
}