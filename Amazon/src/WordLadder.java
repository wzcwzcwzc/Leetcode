import java.util.*;

public class WordLadder {

    /*
    * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
*
*
*
* Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
    * */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //put word list into hashset
        Set<String> wordSet = new HashSet<>(wordList);

        //base case
        if(!wordSet.contains(endWord)) return 0;

        //because we need to try all solutions until we get answer,
        //just like search in a maze
        //we do not use dfs because we cannot guarantee whether the road is right or not
        //so it is better to use bfs

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int ans = 0;

        while(!q.isEmpty()){
            //1.for one particular string, we need to try all kinds of change
            //and check the set
            for(int k = q.size(); k > 0; k--){
                String word = q.poll();
                if(beginWord.equals(word)){
                    //it is the final search and we get the result
                    return ans + 1;
                }

                for(int i = 0; i < word.length(); i++){
                    //change each character in the word
                    char[] newWord = word.toCharArray();
                    for(char c = 'a'; c < 'z'; c++){
                        newWord[i] = c;
                        //check the new String is in set or not
                        String s = new String(newWord);
                        if(wordSet.contains(s) && !s.equals(word)){
                            //if there exists in set which means it has possibility
                            //to become the endWord and we need to store it in queue
                            q.add(s);

                            //by remove the s in set to avoid dead search loop
                            wordSet.remove(s);
                        }
                    }
                }
            }
            //each level of queue contains candidates of endString,
            // we need to traverse whole queue and update ans until the queue is empty
            ans++;
        }
        return 0;
    }
}
