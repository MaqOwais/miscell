/*
26. Remove Duplicates from Sorted Array
Easy

4463

7683

Add to List

Share
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

0 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.
Accepted
1,577,318
Submissions
3,327,487

link --> https://leetcode.com/problems/remove-duplicates-from-sorted-array/

*/

// optimal soln. 
// Runtime: 1 ms, faster than 66.69% of Java online submissions for Remove Duplicates from Sorted Array.
// Memory Usage: 40.4 MB, less than 62.07% of Java online submissions for Remove Duplicates from Sorted Array.


class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 0) return 0;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i - 1] != nums[i]){
                nums[cnt] = nums[i];
                cnt++;
            }
        }
        return cnt;
    }
}

// burte force
// Runtime: 385 ms, faster than 5.04% of Java online submissions for Remove Duplicates from Sorted Array.
// Memory Usage: 40.7 MB, less than 31.88% of Java online submissions for Remove Duplicates from Sorted Array.

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 0) return 0;
        int l = 1, r = nums.length;
        int cnt = r;
        while (l < r){
            if (nums[l - 1] == nums[l]){
                cnt -= 1;
                for(int i = l; i < r - 1; i++) nums[i] = nums[i + 1];
                nums[r - 1] = nums[l];
                r--;
            }else l++;

        }
        return cnt;
    }
}