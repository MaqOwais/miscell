"""/* Handshakes 
Medium Accuracy: 35.85% Submissions: 1859 Points: 4
We have N persons sitting on a round table. Any person can do a handshake with any other person.

     1
2         3
     4

Handshake with 2-3 and 1-4 will cause cross.

In how many ways these N people can make handshakes so that no two handshakes cross each other. N would be even. 
 

Example 1:

Input:
N = 2
Output:
1
Explanation:
{1,2} handshake is
possible.
Example 2:

Input:
N = 4
Output:
2
Explanation:
{{1, 2}, {3, 4}} are the
two handshakes possible.
{{1, 3}, {2, 4}} is another
set of handshakes possible.

Your Task:
You don't need to read input or print anything. Your task is to complete the function count() which takes an integer N as input parameters and returns an integer, the total number of handshakes possible so that no two handshakes cross each other.
 

Expected Time Complexity: O(2N)
Expected Space Complexity: O(1)

link --> https://practice.geeksforgeeks.org/problems/handshakes1303/1#"""


class Solution:
    def count(self, N):
        if not N%2 == 0: return
        def cat(N):
            if N <= 1: return 1
            res = 0
            for i in range(N):
                res += cat(i)*cat(N-(i+1))
            return res

        return cat(N//2)