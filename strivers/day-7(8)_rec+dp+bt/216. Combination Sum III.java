/*
216. Combination Sum III
Medium

2077

67

Add to List

Share
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
Example 4:

Input: k = 3, n = 2
Output: []
Explanation: There are no valid combinations.
Example 5:

Input: k = 9, n = 45
Output: [[1,2,3,4,5,6,7,8,9]]
Explanation:
1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 45
There are no other valid combinations.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
Accepted
241,950
Submissions
391,582

link --> https://leetcode.com/problems/combination-sum-iii/
*/

class Solution {
    List<List<Integer>> list = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        bt(k, n, new ArrayList(), 1); // starting with 1 as per q.
        return list;
    }
    private void bt(int k, int remain, List<Integer> cur, int start){
        if (remain == 0 && cur.size() == k) list.add(new ArrayList(cur));
        else if (remain > 0){
            for (int i = start; i < 10; i++){
                cur.add(i);
                bt(k, remain - i, cur, i + 1 ); //here no nums used since aspQ also you may consider i == nums[i] where nums = [1,..,9]
                cur.remove(cur.size() - 1);
            }
        }else return;
    }
}