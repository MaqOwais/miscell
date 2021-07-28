"""
nCr 
Medium Accuracy: 32.71% Submissions: 44759 Points: 4
Given two integers n and r, find nCr. Since the answer may be very large, calculate the answer modulo 109+7.

Example 1:

Input: n = 3, r = 2
Output: 3
Explaination: 3C2 = 3. 

Example 2:

Input: n = 2, r = 4
Output: 0
Explaination: r is greater than n.

Your Task:
You do not need to take input or print anything. Your task is to complete the function nCr() which takes n and r as input parameters and returns nCr modulo 109+7..


Expected Time Complexity: O(n*r)
Expected Auxiliary Space: O(r)


Constraints:
1 ≤ n ≤ 1000
1 ≤ r ≤ 800

link --> https://practice.geeksforgeeks.org/problems/ncr1019/1#
"""
class Solution:
    def nCr(self, n, r):
        if r > n: return 0
        prev = 1
        for i in range(1, n  + 1):
            curr = prev*(n - i + 1)//(i)
            prev = curr
            if i == r: return prev%(10**9+7)
