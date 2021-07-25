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

class Solution {
public:
    int strStr(string haystack, string needle) {
        int window = needle.size();
        int hay_l = haystack.size();
        if (window > hay_l){ return -1;}
        if (window == 0){ return 0;}
        int i = 0;
        while (i <= hay_l - window){
            int j = 0;
            while (j < window){
                if (needle[j] != haystack[i+j]){
                    break;
                }
                j++;
            }
            if (j == window){
                return i;
            }
            i++;
        }
        return -1;
    }
};