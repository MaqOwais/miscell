"""860. Lemonade Change
Easy

941

107

Add to List

Share
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with correct change, or false otherwise.

 

Example 1:

Input: bills = [5,5,5,10,20]
Output: true
Explanation: 
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
Example 2:

Input: bills = [5,5,10,10,20]
Output: false
Explanation: 
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can not give change of $15 back because we only have two $10 bills.
Since not every customer received correct change, the answer is false.
Example 3:

Input: bills = [5,5,10]
Output: true
Example 4:

Input: bills = [10,10]
Output: false
 

Constraints:

1 <= bills.length <= 105
bills[i] is either 5, 10, or 20.
Accepted
78,546
Submissions
151,013

link --> https://leetcode.com/problems/lemonade-change/

"""

class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        change5, change10 = 0, 0
        for col in bills:
            if col == 5: change5 += 1
            elif col == 10:
                change5 -= 1
                change10 += 1
            elif change10 > 0:
                    change5 -= 1
                    change10 -= 1
            else: change5 -= 3
            if (change5 < 0): return False;
        return True
    
    