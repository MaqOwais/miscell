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

class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> lis = new ArrayList<Character>();
        int mx = 0;
        
        for (int i = 0; i < s.length(); i++){
            if (lis.contains(s.charAt(i))){
                lis.subList(0, lis.indexOf(s.charAt(i)) +1).clear();
            }
            lis.add(s.charAt(i));
            if (mx < lis.size()) {
				mx = lis.size();
			}
        }
        return mx;
        
    }
}