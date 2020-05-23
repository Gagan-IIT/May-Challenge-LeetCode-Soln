/* PROBLEM:
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:
Input:
"tree"
Output:
"eert"
Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:
Input:
"cccaaa"
Output:
"cccaaa"
Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:
Input:
"Aabb"
Output:
"bbAa"
Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Map;
import java.util.LinkedHashMap;
import java.lang.*;
class Solution {
    
    
    
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(hm.get(s.charAt(i))==null) hm.put(s.charAt(i), 1);
            else hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
        }
        List<Map.Entry<Character, Integer> > list = 
               new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() { 
            public int compare(Map.Entry<Character, Integer> e1,  
                               Map.Entry<Character, Integer> e2) 
            { 
                if(e2.getValue()>e1.getValue()) return 1; 
                if(e2.getValue()==e1.getValue()) return 0;
                else return -1;
            } 
        });
        HashMap<Character, Integer> sorted = new LinkedHashMap<Character, Integer>(); 
        for (Map.Entry<Character, Integer> en : list) { 
            sorted.put(en.getKey(), en.getValue()); 
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> en : sorted.entrySet()) { 
            for(int i=0; i<en.getValue(); i++) sb.append(en.getKey());
        }
        return sb.toString();
    }
}
