"""Implement strStr()
Easy

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0

link --> https://leetcode.com/problems/implement-strstr/ 
"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        
        if not needle: return 0
        window = len(needle)
        for i in range(len(haystack) - window + 1):
            if needle == haystack[i: i+window]:
                return i
        return -1
        
"""brute force"""
class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        ln = len(needle)
        lh = len(haystack)
        if haystack == needle or ln == 0: 
            return 0
        if ln > lh:
            return -1
    
        i = 0                                   
        while i <= lh - ln:      
            j = 0
            while j < ln:                
                if needle[j] != haystack[i+j]:  
                    break                       
                j += 1                          
            if j == ln:                  
                return i   
            i += 1

        return -1