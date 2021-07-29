"""/*
Longest consecutive subsequence 
Medium Accuracy: 48.9% Submissions: 65853 Points: 4
Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 

Example 1:

Input:
N = 7
a[] = {2,6,1,9,4,5,3}
Output:
6
Explanation:
The consecutive numbers here
are 1, 2, 3, 4, 5, 6. These 6 
numbers form the longest consecutive
subsquence.
Example 2:

Input:
N = 7
a[] = {1,9,3,10,4,20,2}
Output:
4
Explanation:
1, 2, 3, 4 is the longest
consecutive subsequence.

Your Task:
You don't need to read input or print anything. Your task is to complete the function findLongestConseqSubseq() which takes the array arr[] and the size of the array as inputs and returns the length of the longest subsequence of consecutive integers. 


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).


Constraints:
1 <= N <= 105
0 <= a[i] <= 105

link --> https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1#
*/
"""

# // other ways to do this same problem is by sorting then do loop to get req. ans

# // this is better approach
class Solution:
    
    # arr[] : the input array
    # N : size of the array arr[]
    
    #Function to return length of longest subsequence of consecutive integers.
    def findLongestConseqSubseq(self,arr, N):
        hs = set(arr)
        ans = 0
        for i in range(N):
            if arr[i] - 1 not in hs:
                j = arr[i]
                while (j in hs): j+=1
                ans = max(ans, j - arr[i])
        return ans