"""Longest Substring Without Repeating Characters
Medium

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0

link --> https://leetcode.com/problems/longest-substring-without-repeating-characters/
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        string = ''
        temp_str = ''
        for i in range(len(s)):
            if s[i] not in temp_str:
                temp_str = temp_str + s[i]
                if len(temp_str) > len(string):
                    string = temp_str   
            else:
                temp_str = temp_str[temp_str.index(s[i]) + 1:] + s[i]
        return len(string)