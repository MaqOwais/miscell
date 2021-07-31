/*
775. Global and Local Inversions
Medium

902

271

Add to List

Share
You are given an integer array nums of length n which represents a permutation of all the integers in the range [0, n - 1].

The number of global inversions is the number of the different pairs (i, j) where:

0 <= i < j < n
nums[i] > nums[j]
The number of local inversions is the number of indices i where:

0 <= i < n - 1
nums[i] > nums[i + 1]
Return true if the number of global inversions is equal to the number of local inversions.

 

Example 1:

Input: nums = [1,0,2]
Output: true
Explanation: There is 1 global inversion and 1 local inversion.
Example 2:

Input: nums = [1,2,0]
Output: false
Explanation: There are 2 global inversions and 1 local inversion.
 

Constraints:

n == nums.length
1 <= n <= 105
0 <= nums[i] < n
All the integers of nums are unique.
nums is a permutation of all the numbers in the range [0, n - 1].
Accepted
50,606
Submissions
110,115

link --> https://leetcode.com/problems/global-and-local-inversions/
https://www.youtube.com/watch?v=vFH3zrUbvD4&ab_channel=NickWhite
*/

// brute force approach
class Solution {
    public boolean isIdealPermutation(int[] nums) {

        int gi = 0, li = 0;

        for (int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]) li += 1;
        }

        for (int l = nums.length - 1; l > 0 ; l-- ){
            for (int m = 0; m < l; m++){
                if (nums[l] < nums[m] )  gi+=1;
            }
        }

        return (gi == li);

    }
}


// here just we have to prove that there exits extra global when compared to local
// all LOCAL INVERSIONS ARE GLOBAL INVERSIONS AND NOT VICE VERSA
// SO FIND GLOBAL INVERSION WHICH IS NOT LOCAL INVERSION

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 2 ; i++){
            max = Math.max(max, nums[i]);
            if (max > nums[i+2]) return false;
        }
        return true;
    }
}