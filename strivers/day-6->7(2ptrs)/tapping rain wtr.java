/*
42. Trapping Rain Water
Hard

13156

187

Add to List

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
0 <= n <= 2 * 104
0 <= height[i] <= 105
Accepted
830,825
Submissions
1,571,287

link --> https://leetcode.com/problems/trapping-rain-water/
*/

// Runtime: 1 ms, faster than 84.74% of Java online submissions for Trapping Rain Water.
// Memory Usage: 38.5 MB, less than 74.89% of Java online submissions for Trapping Rain Water.


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] lt = new int[n];
        lt[0] = height[0];
        int water = 0;
        for (int i = 1; i < n; i++){
            lt[i] = Math.max(lt[i - 1], height[i]); 
        }
        int[] rt = new int[n];
        rt[n-1] = height[n-1];
        for (int j = n - 2; j > 0; j--){
            rt[j] = Math.max(rt[j + 1], height[j]); 
        }

        for (int k = 1; k < n - 1; k++){
            water += Math.min(rt[k],lt[k]) - height[k];
            
        }
        return water;
        
    }
}

// 2 ptr approach

class Solution {
    public int trap(int[] height) {
        int l_mx = 0, r_mx = 0;
        int l = 0, r = height.length - 1, water = 0;

        while (l <= r){
            l_mx = Math.max(l_mx, height[l]);
            r_mx = Math.max(r_mx, height[r]);
            if (l_mx < r_mx){
                water += l_mx - height[l];
                l++;
            }else{
                water += r_mx - height[r];
                r--;
            }
        }
        return water;
    }
}


// brute force

class Solution {
    public int trap(int[] A) {
        int volume = 0;
        int left = 0, right = 0;
        for(int i = 0; i < A.length; i++) {
            left = findTallest(0, i-1, A);
            right = findTallest(i+1, A.length-1,A);
            int vol = Math.min(left,right) - A[i];
            if(vol >= 0) {
               volume = volume + vol; 
            }
        }
        return volume;
    }
    
    public int findTallest(int begin, int end, int[]A) {
        int tallest = 0;
        for(int i = begin; i <=end; i++) {
            if(tallest < A[i]) {
                tallest = A[i];
            }
        }
        return tallest;
    }
}