"""
Longest Palindromic Substring
Medium

Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case)

link --> https://leetcode.com/problems/longest-palindromic-substring/
"""

"""BRUTE FORCE METHOD"""
class Solution:
    def isPalin(self,s):
        return s == s[::-1]
        
    def longestPalindrome(self, s: str) -> str:
        f = 0
        l = len(s)
        if l == 1: return s
        st = ""

        while f < l:
            sc = f + 1
            while sc <= l:
                if self.isPalin(s[f:sc]):
                    if len(st) < len(s[f:sc]):
                        st = s[f:sc]
                sc += 1
            f += 1
                
        return st
        