import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {


    /*
    *
    * Given a paragraph and a list of banned words,
    * return the most frequent word that is not in the list of banned words.
    * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:

Input:
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
*
* Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
    * */

    public String mostCommonWord(String paragraph, String[] banned){

        //each time we meet a word we need to find whether it is banned
        //use hashSet to store the banned words

        Set<String> bannedSet = new HashSet<>();

        for(String bannedWord : banned){
            bannedSet.add(bannedWord);
        }

        //modify the format of paragraph and use hashMap to store frequency

        Map<String, Integer> map = new HashMap<>();

        String[] s = paragraph.replaceAll("[^A-Za-z]", " ").toLowerCase().split(" ");

        for(String str : s){
            //check whether it is banned
            if(!bannedSet.contains(str)){
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        String res = "";
        //compare frequency in hashMap
        for(String key : map.keySet()){
            if(res.equals("") || map.get(key) > map.get(res)){
                res = key;
            }
        }

        return res;

    }
}
