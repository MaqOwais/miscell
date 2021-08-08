"""
409. Longest Palindrome
Easy

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
Accepted
214,157
Submissions
407,942

link --> https://leetcode.com/problems/longest-palindrome/

"""


# some times we have to think in a numerical way...as this one
class Solution:
    def longestPalindrome(self, s: str) -> int:
        if not s: return 0
        hsh = {}
        for i in s:
            hsh[i] = hsh.get(i, 0) + 1
        
        result, odd = 0, 0
        
        for k in hsh:
            if hsh[k]%2 == 0:
                result += hsh[k]
            else:
                result += hsh[k] - 1
                odd += 1
        return result + (1 if odd > 0 else 0)