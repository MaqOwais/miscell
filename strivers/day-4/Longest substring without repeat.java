class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> hl = new ArrayList();
        int sz = 0;
        for (int i = 0; i < s.length(); i++){
            if ( hl.contains((s.charAt(i))))  hl.subList(0, hl.indexOf(s.charAt(i)) +1).clear();
            hl.add((s.charAt(i)));
            mx = Math.max(mx, lis.size());
        }
        return sz;
    }
}


// 2 pointer + hashset
// The idea is use a hash set to track the longest substring without repeating characters so far, 
// use a fast pointer j to see if character j is in the hash set or not, if not, great, add it to 
// the hash set, move j forward and update the max length, otherwise, delete from the head by using 
// a slow pointer i until we can put character j to the hash set.
class Solution {
public int lengthOfLongestSubstring(String s) {
    int i = 0, j = 0, max = 0;
    Set<Character> set = new HashSet<>();
    
    while (j < s.length()) {
        if (!set.contains(s.charAt(j))) {
            set.add(s.charAt(j++));
            max = Math.max(max, set.size());
        } else {
            set.remove(s.charAt(i++));
        }
    }
    
    return max;
}
}