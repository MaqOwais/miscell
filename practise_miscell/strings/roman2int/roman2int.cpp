"""
Roman to Integer
Easy

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

link --> https://leetcode.com/problems/roman-to-integer/
"""

class Solution {
public:
    int romanToInt(string s) {
        map<char, int> hsh;
        hsh['I'] = 1;
        hsh['V'] = 5;
        hsh['X'] = 10;
        hsh['L'] = 50;
        hsh['C'] = 100;
        hsh['D'] = 500;
        hsh['M'] = 1000;
        int n = s.size() - 1;
        int cnt = hsh[s[n]] ;
        for (int i = n - 1; i >= 0 ; i--){
            char ele = s[i];
            char ele1 = s[i+1];
            if (hsh[ele1] > hsh[ele]){
                cnt -= hsh[ele];
            }else{
                cnt += hsh[ele];
            }
        }
        
        return cnt;
    }
};

class Solution {
public:
    int romanToInt(string s) {
        int res=0;
        unordered_map<char,int> mp={{'M',1000},
                                 {'D',500},
                                 {'C',100},
                                 {'L',50},
                                 {'X',10},
                                 {'V',5},
                                 {'I',1}
                                };
        for(int i=0;i<s.length();i++){
            if(mp[s[i]]<mp[s[i+1]]) res-=mp[s[i]];
            else res+=mp[s[i]];
        }
        return res;
    }
};
class Solution {
public:
    int roman(char c){
        if(c=='I')
            return 1;
        else if(c=='V')
            return 5;
        else if(c=='X')
            return 10;
        else if(c=='L')
            return 50;
        else if(c=='C')
            return 100;
        else if(c=='D')
            return 500;
        return 1000;
         
    }
    int romanToInt(string s) {
        int g=0;
        for(int i=0;i<s.length();i++){
            if(i+1 < s.length() && roman(s[i+1])>roman(s[i])){
                g+=roman(s[i+1])-roman(s[i]);
                i++;
            }
            else
                g+=roman(s[i]);
            // cout<<g<<" ";
        }
        return g;
    }
};