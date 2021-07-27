"""
Find duplicates in an array 
Easy Accuracy: 20.69% Submissions: 100k+ Points: 2
Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array.

Example 1:

Input:
N = 4
a[] = {0,3,1,2}
Output: -1
Explanation: N=4 and all elements from 0
to (N-1 = 3) are present in the given
array. Therefore output is -1.
Example 2:

Input:
N = 5
a[] = {2,3,1,2,3}
Output: 2 3 
Explanation: 2 and 3 occur more than once
in the given array.
Your Task:
Complete the function duplicates() which takes array a[] and n as input as parameters and returns a list of elements that occur more than once in the given array in sorted manner. If no such element is found return -1. 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).
Note : The extra space is only for the array to be returned.
Try and perform all operation withing the provided array. 

Constraints:
1 <= N <= 105
0 <= A[i] <= N-1, for each valid i

link --> https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1#
"""

"""NAIVE APPROACH: this could be also done by sorting first then CHECK with arr[i] == arr[i+1]"""


"""using hash approach"""

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        HashMap<Integer, Integer> hsh = new HashMap<>();
        ArrayList<Integer> lis = new ArrayList<>();

        for (Integer ele: arr){
            if (hsh.containsKey(ele)){
                int cnt = hsh.get(ele) + 1;
                hsh.put(ele, cnt);
            }else{
                hsh.put(ele, 1);
            }
        }
        for (Integer e: hsh.keySet()){
            if (hsh.get(e) > 1){
                lis.add(e);
            }
        }
        if (lis.isEmpty()){
            lis.add(-1);
        }
        Collections.sort(lis);
        return lis;
        
    }
}

"""2ND APPROACH: this could be also done HAVING A FREQUENCY LIST which takes the extra O(n) space"""

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> lis = new ArrayList<>();
        ArrayList<Integer> li = new ArrayList<>();
        for (int i = 0 ; i< n; i++){
            li.add(0);
        }
        
        for (Integer ele: arr){
            int val = li.get(ele) + 1;
            li.set(ele,val);
        }
        
        for (int i = 0; i< n; i++){
            if (li.get(i) > 1){
                lis.add(i);
            }
        }
        
        if (lis.isEmpty()){
            lis.add(-1);
        }
        return lis;
        
    }
}