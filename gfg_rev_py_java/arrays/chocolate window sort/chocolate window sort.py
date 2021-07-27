"""
Chocolate Distribution Problem 

Easy Accuracy: 53.25% Submissions: 18753 Points: 2
Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

Example 1:

Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between 
maximum chocolates and minimum chocolates 
is 9 - 3 = 6 by choosing following M packets :
{3, 4, 9, 7, 9}.
Example 2:

Input:
N = 7, M = 3
A = {7, 3, 2, 4, 9, 12, 56}
Output: 2
Explanation: The minimum difference between
maximum chocolates and minimum chocolates
is 4 - 2 = 2 by choosing following M packets :
{3, 2, 4}.
Your Task:
You don't need to take any input or print anything. Your task is to complete the function findMinDiff() which takes array A[ ], N and M as input parameters and returns the minimum possible difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
1 ≤ Ai ≤ 109
1 ≤ M ≤ N

link --> https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1#
"""


class Solution:
    # sorting with dict.items

    def bubble_sort(self, elements, key=None):
        size = len(elements)

        for i in range(size-1):
            swapped = False
            for j in range(size-1-i):
                a = elements[j][key]
                b = elements[j+1][key]
                if a > b:
                    tmp = elements[j]
                    elements[j] = elements[j+1]
                    elements[j+1] = tmp
                    swapped = True

            if not swapped:
                break

# if __name__ == '__main__':
#     elements = [
#         { 'name': 'mona',   'transaction_amount': 1000, 'device': 'iphone-10'},
#         { 'name': 'dhaval', 'transaction_amount': 400,  'device': 'google pixel'},
#         { 'name': 'kathy',  'transaction_amount': 200,  'device': 'vivo'},
#         { 'name': 'aamir',  'transaction_amount': 800,  'device': 'iphone-8'},
#     ]

#     bubble_sort(elements, key='transaction_amount')
#     print(elements)

    def bubble_sort(self, elements):
        ran = len(elements) - 1
        for i in range(ran):
            swapped = False
            for j in range(ran - i):
                if elements[j] > elements[j+1]:
                    tmp = elements[j]
                    elements[j] = elements[j+1]
                    elements[j+1] = tmp
                    swapped = True
            if not swapped:
                break
    # or
    def bubble_sort(self, elements):
        ran = len(elements) - 1
        for i in range(ran):
            for j in range(ran - i):
                if elements[j] > elements[j+1]:
                    tmp = elements[j]
                    elements[j] = elements[j+1]
                    elements[j+1] = tmp



    def findMinDiff(self, A,N,M):
        # if bubble_sort(A) is used then complexity = O(n**2)

        A.sort() 

        dif = A[N - 1] - A[0]
        for i in range(N - M + 1):
            if dif > A[i + M - 1] - A[i]:
                dif = A[i + M - 1] - A[i]
        return dif