/*
60. Permutation Sequence
Hard

2620

374

Add to List

Share
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n!
Accepted
236,411
Submissions
585,232

link -->https://leetcode.com/problems/permutation-sequence/

*/


//  using while loop
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
        k = k-1;
        String sb = "";
        for (int i = n; i > 0; i--){
            int ind = k /  fact[i-1];
            k = k % fact[i-1];
            sb += num.get(ind);
            num.remove(ind);
        }
        return sb;
    } 
}





// using fake recursion
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) num.add(i);
        int[] fact = new int[n];  // factorial
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = i*fact[i-1];
        k = k - 1;        
        return helper(fact, "", num, n, k);
    } 
    private String helper(int[] fact,String sb,List<Integer> num, int n, int k){
            if (n == 0) return sb;
            int ind = k / fact[n-1];
            k = k % fact[n-1];
            sb += num.get(ind);
            num.remove(ind);
            return helper(fact, sb, num, n - 1, k);
    }
}




// tried but failed

class Solution {
    public String reverse(String s, int m,int n){
        while(m < n){
            s = swap(s, m, n);
            m++; n--;
        }
        return s;
    } 
    private String swap(String s,int a,int b){
        char[] c = s.toCharArray();

        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;

        String swappedString = new String(c);
        return swappedString;
    }
    public String getPermutation(int n, int k) {
        int[] p = new [n];
        for (int i = 1; i <= n; i++) p[i] = i;
        per(p, k);
        return Integer.toString(p);
    }
    
    private void per(String s,int k){
        
        int gold = s.length() - 1;
        while (gold > 0 && (int)s.charAt(gold) <= (int)s.charAt(gold - 1)) gold--;
        
        if (gold == 0 || k == 0) return;

        int pre = gold - 1;
        for (int i = s.length() - 1; i >= 0; i--){
            if ((int) s.charAt(pre) < (int)s.charAt(i)){
                s = swap(s, i, pre);
                break;
            }
        }
        s = reverse(s, k, s.length() - 1);
        per(s, k - 1);
    }   
}
