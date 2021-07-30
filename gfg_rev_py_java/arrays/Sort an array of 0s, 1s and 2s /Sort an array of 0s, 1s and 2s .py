"""
Sort an array of 0s, 1s and 2s 
Easy Accuracy: 51.36% Submissions: 100k+ Points: 2
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.


Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated 
into ascending order.
Example 2:

Input: 
N = 3
arr[] = {0 1 0}
Output:
0 0 1
Explanation:
0s 1s and 2s are segregated 
into ascending order.

Your Task:
You don't need to read input or print anything. Your task is to complete the function sort012() that takes an array arr and N as input parameters and sorts the array in-place.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)


Constraints:
1 <= N <= 10^6
0 <= A[i] <= 2

link--> https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
"""

""" NOTE: if to get O(n) complexity for THIS sorting algo them IMO u have to keep the no. of pointers equal to that particular diff elements"""

class Solution:
    def sort012(self,arr,n):
        ptL = 0
        ptH = n - 1
        ptM = 0
        
        while ptM <= ptH:
            if arr[ptM] == 0:
                arr[ptL], arr[ptM] = arr[ptM], arr[ptL]
                ptM += 1
                ptL += 1
            elif arr[ptM] == 1:
                ptM += 1
            else:
                arr[ptH], arr[ptM] = arr[ptM], arr[ptH]
                ptH -= 1

        return arr