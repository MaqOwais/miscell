"""1323. Maximum 69 Number
Easy

714

98

Add to List

Share
Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

 

Example 1:

Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666. 
The maximum number is 9969.
Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.
 

Constraints:

1 <= num <= 10^4
num's digits are 6 or 9.
Accepted
89,918
Submissions
114,942

link --> https://leetcode.com/problems/maximum-69-number/

"""


class Solution:
    def maximum69Number (self, num: int) -> int:
        nu = list(map(int, str(num)))
        for n in range(len(nu)):
            if nu[n] == 6:
                nu[n] = 9
                break
        res, i = 0, 0
        for n in range(len(nu) - 1, -1, -1):
            res += nu[n]*(10**(i))
            i += 1
        
        return res