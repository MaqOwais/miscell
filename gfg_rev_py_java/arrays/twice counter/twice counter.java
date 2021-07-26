"""
Twice Counter 

Easy Accuracy: 63.91% Submissions: 7662 Points: 2
Given a list of N words. Count the number of words that appear exactly twice in the list.

Example 1:

Input:
N = 3
list = {Geeks, For, Geeks}
Output: 1
Explanation: 'Geeks' is the only word that 
appears twice. 
Example 2:

Input:
N = 8
list = {Tom, Jerry, Thomas, Tom, Jerry, 
Courage, Tom, Courage}
Output: 2
Explanation: 'Jerry' and 'Courage' are the 
only words that appears twice. 

Your Task:  
You dont need to read input or print anything. Complete the function countWords() which takes integer N and list of strings as input parameters and returns the number of words that appear twice in the list.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)  


Constraints:
1<= N <= 104

link --> https://practice.geeksforgeeks.org/problems/twice-counter4236/1#
"""


class Solution
{
    public int countWords(String list[], int n)
    {
        HashMap<String, Integer> hsh = new HashMap<>();
        for (int i = 0;i < list.length; i++){
            if (hsh.containsKey(list[i])){
                int v = hsh.get(list[i]) + 1;
                hsh.put(list[i], v);
            }else{
            hsh.put(list[i], 1);}
        }
        int j = 0;
        for (String e: hsh.keySet()){
            if (hsh.get(e) == 2){
                j++;
            }
        }
        return j;
    }

}