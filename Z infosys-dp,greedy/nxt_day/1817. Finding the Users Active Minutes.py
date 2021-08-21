"""
1817. Finding the Users Active Minutes
Medium

You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute timei.

Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.

The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode. A minute can only be counted once, even if multiple actions occur during it.

You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.

Return the array answer as described above.

 

Example 1:

Input: logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
Output: [0,2,0,0,0]
Explanation:
The user with ID=0 performed actions at minutes 5, 2, and 5 again. Hence, they have a UAM of 2 (minute 5 is only counted once).
The user with ID=1 performed actions at minutes 2 and 3. Hence, they have a UAM of 2.
Since both users have a UAM of 2, answer[2] is 2, and the remaining answer[j] values are 0.
Example 2:

Input: logs = [[1,1],[2,2],[2,3]], k = 4
Output: [1,1,0,0]
Explanation:
The user with ID=1 performed a single action at minute 1. Hence, they have a UAM of 1.
The user with ID=2 performed actions at minutes 2 and 3. Hence, they have a UAM of 2.
There is one user with a UAM of 1 and one with a UAM of 2.
Hence, answer[1] = 1, answer[2] = 1, and the remaining values are 0.
 

Constraints:

1 <= logs.length <= 104
0 <= IDi <= 109
1 <= timei <= 105
k is in the range [The maximum UAM for a user, 105].
Accepted
16,810
Submissions
21,337

link -> https://leetcode.com/problems/finding-the-users-active-minutes/
"""

class Solution:
    def findingUsersActiveMinutes(self, logs: List[List[int]], k: int) -> List[int]:
    
        res = [0]*k
        hsh = {}
        for i in range(len(logs)):
            u_id = logs[i][0]
            tm = logs[i][1]
            hsh[u_id] = hsh.get(u_id, []) + [tm]        
        
        for uid in hsh:
            uam = len(set(hsh[uid]))
            res[uam - 1] += 1
        
        return res


# Runtime: 976 ms, faster than 91.36% of Python3 online submissions for Finding the Users Active Minutes.
# Memory Usage: 24.8 MB, less than 64.38% of Python3 online submissions for Finding the Users Active Minutes.
class Solution:
    def findingUsersActiveMinutes(self, logs: List[List[int]], k: int) -> List[int]:
        res = [0]*k
        hsh = {}
        for u_id,tm in logs:
            hsh.setdefault(u_id, set()).add(tm) #similar to hsh[key] = hsh.get(hsh[key], []) + [val] in lists add

        for tm in hsh.values():
            res[len(tm) - 1] += 1 # uid = len(tm) and -1 for adjusting acc. to Q

        return res 