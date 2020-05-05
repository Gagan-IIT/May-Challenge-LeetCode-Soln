/* PROBLEM:
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/


import java.util.HashMap;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        for(int i=0; i<magazine.length();i++){
            char c = magazine.charAt(i);
            if(hs.get(c)!=null) hs.put(c, hs.get(c)+1);
            else hs.put(c, 1);
        }
        for(int i=0; i<ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(hs.get(c)==null) return false;
            else{
                if(hs.get(c)==0) return false;
                else hs.put(c, hs.get(c)-1);
            }
        }
        return true;
    }
}
