"""
Nuts and Bolts Problem 
Medium Accuracy: 52.04% Submissions: 16545 Points: 4
Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.

Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.
The elements should follow the following order ! # $ % & * @ ^ ~ .

Example 1:

Input: 
N = 5
nuts[] = {@, %, $, #, ^}
bolts[] = {%, @, #, $ ^}
Output: 
# $ % @ ^
# $ % @ ^
Example 2:

Input: 
N = 9
nuts[] = {^, &, %, @, #, *, $, ~, !}
bolts[] = {~, #, @, %, &, *, $ ,^, !}
Output: 
! # $ % & * @ ^ ~
! # $ % & * @ ^ ~
Your Task:  
You don't need to read input or print anything. Your task is to complete the function matchPairs() which takes an array of characters nuts[], bolts[] and n as parameters and returns void. You need to change the array itswelf.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 9
Array of Nuts/Bolts can only consist of the following elements:{'@', '#', '$', '%', '^', '&', '~', '*', '!'}.

link --> https://practice.geeksforgeeks.org/problems/nuts-and-bolts-problem0431/1#
"""
class Solution:

	def matchPairs(self, nuts, bolts, n):
        # code here
        hash_tab = {0:'!',1:'#',2:'$', 3:'%',4:'&',5:'*',6:'@',7:'^',8:'~'}
        def get_key(val):
            for key, value in hash_tab.items():
                 if val == value:
                     return key
        li = []
        for i in range(n):
            li.append(get_key(nuts[i]))
        li = sorted(li)
        for i in range(n):
            nuts[i] = bolts[i] = hash_tab[li[i]]
        return nuts, bolts


class Solution:

	def matchPairs(self,nuts, bolts, n):
        st = "!#$%&*@^~"
        c = 0
        for i in range(9):
            for j in range(n):
                if nuts[j] == st[i]:
                    nuts[j], nuts[c] = nuts[c], nuts[j]
                    bolts[c] = nuts[c]
                    c+=1
        return nuts, bolts