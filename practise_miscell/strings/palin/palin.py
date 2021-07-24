"""
Valid Palindrome II
Easy

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false

link: https://leetcode.com/problems/valid-palindrome-ii/
"""

class Solution:
    def validPalindrome(self, s: str) -> bool:
        s1 = s[::-1]
        if s1==s:
            return True
        else:
            j = len(s) - 1
            i = 0
            while (i<j):
                if s[i] != s[j]:
                    p = s[i+1:j+1]
                    q = s[i:j]
                    return p == p[::-1] or q == q[::-1]
                j -= 1
                i += 1