"""
Kadane's Algorithm 
Medium Accuracy: 51.0% Submissions: 100k+ Points: 4
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.


Example 1:

Input:
N = 5
arr[] = {1,2,3,-2,5}
Output:
9
Explanation:
Max subarray sum is 9
of elements (1, 2, 3, -2, 5) which 
is a contiguous subarray.
Example 2:

Input:
N = 4
arr[] = {-1,-2,-3,-4}
Output:
-1
Explanation:
Max subarray sum is -1 
of element (-1)

Your Task:
You don't need to read input or print anything. The task is to complete the function maxSubarraySum() which takes arr and N as input parameters and returns the sum of subarray with maximum sum.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 106
-107 ≤ A[i] ≤ 107

link --> https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1#
"""


"""brute force approach"""

def maxSubArraySum(self,a,size):
        ##Your code here
        mx = a[0]
        for i in range(size):
            su = 0
            for j in range(i, size):
                su += a[j]
                mx = max(su, mx)

        return mx

"""kadanes algo"""

class Solution:
    ##Complete this function
    #Function to find the sum of contiguous subarray with maximum sum.
    def maxSubArraySum(self, a, size):
        ##Your code here
        mx = a[0]
        su = 0
        for i in range( size):
            su += a[i]
            mx = max(su, mx)
            su = max(su,0)
        return mx
