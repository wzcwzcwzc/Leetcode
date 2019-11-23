import java.util.HashMap;
import java.util.Map;

public class Trie {

    //prefix tree, similar to hashMap

    //it can search for O(n)

    /*

    wzc wzd, each character is a TrieNode
    *       root
            |
            w
    *       |
    *       z --
    *       |   |
    *       c   d
    * */

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    //insert a word into trie
    public void insert(String word){
        Map<Character, TrieNode> children = root.children;

        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            //change each character into TireNode
            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;

            //set leaf node (tail)
            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }

    //return true if the word is in the trie
    public boolean search(String word){
        TrieNode t = searchNode(word);

        if(t != null && t.isLeaf){
            return true;
        }else{
            return false;
        }

    }

    public TrieNode searchNode(String str){
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                //similar to linked list
                children = t.children;
            }else{
                return null;
            }
        }
        return t;
    }

    //search the word starts with given prefix
    public boolean startsWith(String prefix){
        if(searchNode(prefix) == null){
            return false;
        }else{
            return true;
        }
    }

}


class TrieNode{
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode(){
    }
    public TrieNode(char c){
        this.c = c;
    }

}
