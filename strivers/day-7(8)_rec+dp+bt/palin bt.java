/*
131. Palindrome Partitioning
Medium

4090

127

Add to List

Share
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
Accepted
338,884
Submissions
622,132

link --> https://leetcode.com/problems/palindrome-partitioning/

*/

class Solution {
    List<List<String>> list = new ArrayList();
    private boolean isPalin(String str){
        int s = 0, e = str.length() - 1;
        if (e== 0) return true;
        while (s < e){
            if (str.charAt(s) != str.charAt(e)) return false;
            s++; e--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        bt(s, 0, new ArrayList());
        return list;
    }
    private void bt(String s, int start, List<String> cur){
        if(start == s.length())  list.add(new ArrayList(cur));
        for (int i = start ; i < s.length() ; i++ ){
            if (isPalin(s.substring(start,i+1))) {
            cur.add(s.substring(start,i+1));
            bt(s, i + 1, cur);
            cur.remove(cur.size() - 1);}
        }
    }
}

