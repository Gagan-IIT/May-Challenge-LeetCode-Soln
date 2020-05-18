/* PROBLEM:
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of 
the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False

Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/

class Solution {
    static boolean ifEqual(int[] pFreq, int[] sFreq){
        for(int i=0; i<26; i++)
            if(pFreq[i]!=sFreq[i]) return false;
        return true;
    }
    public boolean checkInclusion(String p, String s) {
         int pLen = p.length(), sLen = s.length();
        if(pLen>sLen) return false;
        
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];
        int t=0;
        for(int i=0; i<pLen; i++){
            pFreq[p.charAt(i)-'a']++;
            sFreq[s.charAt(i)-'a']++;
        }
        if(ifEqual(pFreq, sFreq)) return true;
        for(int i=pLen; i<sLen; i++){
            t++;
            sFreq[s.charAt(i)-'a']++;
            sFreq[s.charAt(i-pLen)-'a']--;
            if(ifEqual(pFreq, sFreq)) return true;
        }
        return false;
    }
}
