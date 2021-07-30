"""/*Minimum number of jumps 
Medium Accuracy: 32.96% Submissions: 100k+ Points: 4
Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element. Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.
Note: Return -1 if you cant reach the end of the array.


Example 1:

Input:
N = 11 
arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
Output: 3 
Explanation: 
First jump from 1st element to 2nd 
element with value 3. Now, from here 
we jump to 5th element with value 9, 
and from here we will jump to last. 
Example 2:

Input :
N = 6
arr = {1, 4, 3, 2, 6, 7}
Output: 2 
Explanation: 
First we jump from the 1st to 2nd element 
and then jump to the last element.

Your task:
You dont need to read input or print anything. Your task is to complete function minJumps() which takes the array arr and its size N as input parameters and returns the minimum number of jumps. If not possible returns -1.


Expected Time Complexity: O(N)
Expected Space Complexity: O(1)


Constraints:
1 ≤ N ≤ 107
0 ≤ arri ≤ 107

link --> https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#"""

# for explanation see java

# recusive soln. and brute force approach

class Solution:
    def minJ(self,arr, cur, Sum):
        if cur >= len(arr) - 1: return Sum
        if arr[cur] == 0: return -1
        res = float('inf')
        for i in range(1, arr[cur]+1):
            res = min(res, self.minJ(arr, i + cur, Sum + 1))
        return res
    
    def minJumps(self, arr, n):
        return self.minJ(arr, 0, 0)

class Solution:
    def minJumps(self, arr, n):
        if len(arr) <= 1 :return 0
        if arr[0] == 0: return -1

        lad = arr[0]
        stairs = arr[0]
        jump = 1

        for i in range(1, n - 1):
            lad = max(lad, i + arr[i])
            stairs -= 1
            if stairs == 0:
                jump += 1
                stairs = lad - i
                if stairs <= 0: return -1
        return jump