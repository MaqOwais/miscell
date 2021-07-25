"""Longest Substring Without Repeating Characters
Medium

16038

785

Add to List

Share
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

#include <algorithm>
#include <vector>
class Solution {
    // not used but impo.
    // bool fnd(vector<char> lis,char ele){
    //     for (char c: lis){
    //         if (c == ele){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    
public:
    int lengthOfLongestSubstring(string s) {
        int start = -1, res = 0;
        int n = s.length();
        map<char,int> mp;

        for(int i = 0;i < n;i++)
        {
            if(mp.find(s[i])!=mp.end())
            {
                if(mp[s[i]]>start)
                {
                   start=mp[s[i]];
                }
            }
             mp[s[i]]=i;
             res=max(res, i - start);
        }
    
    
    return res;
    }
};

