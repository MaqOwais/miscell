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

class Solution {
    public boolean isPalin(String s){
        int i = 0, j = s.length() -1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        String t = "", maxp = "";
        int n = s.length();
        for (int i = 0; i < n; i++ ){
            t += s.charAt(i);
            for (int j = 0; j < t.length(); j++){
                if (t.charAt(j) == s.charAt(i)){
                    String P = s.substring(j, i+1);
                    if (isPalin(P) && P.length() > maxp.length()){
                        maxp = P;
                        break;
                    } 
                }
            }
        }
        return maxp;
    }
}