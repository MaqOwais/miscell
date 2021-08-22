/*
242. Valid Anagram
Easy

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

LINK --> https://leetcode.com/problems/valid-anagram/

*/


class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> hs = new HashMap();
        for (int i = 0; i < t.length(); i++) 
            if (! hs.containsKey(t.charAt(i)))
                {hs.put(t.charAt(i), 1);}
            else{
                int val = hs.get(t.charAt(i)) + 1;
                hs.put(t.charAt(i), val);}
        for (int j = 0; j < s.length(); j++)
            if (hs.containsKey(s.charAt(j))) 
                {int v = hs.get(s.charAt(j)) - 1;
                if (v > 0) hs.put(s.charAt(j), v);
                else hs.remove(s.charAt(j));}
        
        return hs.isEmpty();
    }
}
// 80% faster
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) alpha[s.charAt(i) - 'a']++;
        for (int j = 0; j < t.length(); j++) alpha[t.charAt(j) - 'a']--;
        for (int i : alpha) if (i != 0) return false;
        return true;
    }
}