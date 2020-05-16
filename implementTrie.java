/* PROBLEM:
Implement a trie with insert, search, and startsWith methods.

Example:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/

class Trie {
    
    class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children = new TrieNode[26];
        TrieNode(){
            for (int i = 0; i < 26; i++) 
                children[i] = null;
            isEndOfWord = false;
        }
    }
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        int level; 
        int length = key.length(); 
        int index; 
       
        TrieNode temp = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 
            if (temp.children[index] == null) 
                temp.children[index] = new TrieNode(); 
       
            temp = temp.children[index]; 
        } 
       
        temp.isEndOfWord = true;
    }
    
    public boolean search(String key) {
        int level; 
        int length = key.length(); 
        int index; 
        TrieNode temp = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 
       
            if (temp.children[index] == null) 
                return false; 
       
            temp = temp.children[index]; 
        } 
       
        return (temp != null && temp.isEndOfWord);
    }
    
    public boolean startsWith(String key) {
        int level; 
        int length = key.length(); 
        int index; 
        TrieNode temp = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 
       
            if (temp.children[index] == null) 
                return false; 
       
            temp = temp.children[index]; 
        } 
       
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
