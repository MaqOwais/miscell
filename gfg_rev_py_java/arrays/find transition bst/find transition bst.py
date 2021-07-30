"""
Find Transition Point 
Easy Accuracy: 53.15% Submissions: 98855 Points: 2
Given a sorted array containing only 0s and 1s, find the transition point. 


Example 1:

Input:
N = 5
arr[] = {0,0,0,1,1}
Output: 3
Explanation: index 3 is the transition 
point where 1 begins.

Example 2:

Input:
N = 4
arr[] = {0,0,0,0}
Output: -1
Explanation: Since, there is no "1",
the answer is -1.

Your Task:
You don't need to read input or print anything. The task is to complete the function transitionPoint() that takes array and N as input parameters and returns the 0 based index of the position where "0" ends and "1" begins. If array does not have any 1s, return -1. If array does not have any 0s, return 0.


Expected Time Complexity: O(LogN)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ N ≤ 500000
0 ≤ arr[i] ≤ 1

link --> https://practice.geeksforgeeks.org/problems/find-transition-point-1587115620/1#
"""

"""O(n)"""
def transitionPoint(arr, n):
    for i in range(n):
        if arr[i] == 1:
            return i
    return -1

"""using bst takes O(log(n))"""

def transitionPoint(arr, n):
    l = 0
    r = n - 1
    if arr[0] == 1: return 0
    while (l <= r):
        mid = (l + r) // 2 
        if (arr[mid] == 1 and arr[mid-1] == 0): return mid
        elif (arr[mid] == 0):
            l = mid + 1
        else:
            r = mid - 1
    return -1
