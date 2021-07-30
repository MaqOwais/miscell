/* 
Trapping Rain Water 
Medium Accuracy: 49.62% Submissions: 73900 Points: 4
Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 
 

Example 1:

Input:
N = 6
arr[] = {3,0,0,2,0,4}
Output:
10
Explanation: 

Example 2:

Input:
N = 4
arr[] = {7,4,0,9}
Output:
10
Explanation:
Water trapped by above 
block of height 4 is 3 units and above 
block of height 0 is 7 units. So, the 
total unit of water trapped is 10 units.
Example 3:

Input:
N = 3
arr[] = {6,9,9}
Output:
0
Explanation:
No water will be trapped.

Your Task:
You don'y need to read input or print anything. The task is to complete the function trappingWater() which takes arr and N as input parameters and returns the total amount of water that can be trapped.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
3 <= N <= 107
0 <= Ai <= 108


*/


class Solution{
    static int trappingWater(int arr[], int n) { 
        int water = 0;
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 0; i < n; i++) l.add(0);
        for (int i = 0; i < n; i++) r.add(0);
        l.set(0,arr[0]);
        r.set(n - 1, arr[n - 1]);
        for (int i = 1; i < n; i++) l.set(i, Math.max(arr[i], l.get(i-1)) );
        for (int j = n - 2; j > 0; j--) r.set(j, Math.max(arr[j], r.get(j+1)) );
        for (int k = 1; k < n - 1; k++) water += Math.min(l.get(k), r.get(k)) - arr[k];
        return water;
    } 
}


// using both for , add, set
class Solution{
    
    static int trappingWater(int arr[], int n) { 
        int water = 0;
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        // adding 0's
        for (int i = 0; i < n; i++) r.add(0);
        // appending to left side
        l.add(arr[0]);
        r.set(n - 1, arr[n - 1]);
        for (int i = 1; i < n; i++) l.add(Math.max(arr[i], l.get(i-1)) );
        for (int j = n - 2; j > 0; j--) r.set(j, Math.max(arr[j], r.get(j+1)) );

        for (int j = 1; j < n - 1; j++) water += Math.min(l.get(j),r.get(j)) - arr[j];

        return water;
    } 
}
