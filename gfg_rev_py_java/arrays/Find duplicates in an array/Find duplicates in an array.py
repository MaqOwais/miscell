"""
Find duplicates in an array 
Easy Accuracy: 20.69% Submissions: 100k+ Points: 2
Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array.

Example 1:

Input:
N = 4
a[] = {0,3,1,2}
Output: -1
Explanation: N=4 and all elements from 0
to (N-1 = 3) are present in the given
array. Therefore output is -1.
Example 2:

Input:
N = 5
a[] = {2,3,1,2,3}
Output: 2 3 
Explanation: 2 and 3 occur more than once
in the given array.
Your Task:
Complete the function duplicates() which takes array a[] and n as input as parameters and returns a list of elements that occur more than once in the given array in sorted manner. If no such element is found return -1. 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).
Note : The extra space is only for the array to be returned.
Try and perform all operation withing the provided array. 

Constraints:
1 <= N <= 105
0 <= A[i] <= N-1, for each valid i

"""

"""NAIVE APPROACH: this could be also done by sorting first then CHECK with arr[i] == arr[i+1]"""



"""using hash approach"""
class Solution:
    def duplicates(self, arr, n): 
    	# code here
    	hsh = {}
    	li = []
    	for i in range(n):
    	    hsh[arr[i]] = hsh.get(arr[i], 0) + 1
    	    if hsh[arr[i]] == 2:
    	        li.append(arr[i])
    	return [-1] if len(li) == 0 else sorted(li)

"""2ND APPROACH: this could be also done HAVING A FREQUENCY LIST which takes the extra O(n) space"""


class Solution:
    def duplicates(self, arr, n): 
    	# code here
    	lis = []
    	li = [0]*(n)
    	
    	for i in arr:
    	    li[i] += 1
    	for i in range(n):
    	    if li[i] > 1:
    	        lis.append(i)
    	if not len(lis):
    	    lis.append(-1)
        return lis