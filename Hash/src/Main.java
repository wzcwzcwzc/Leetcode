import java.util.*;
/**
 * @author Barry
 * @date 03/17/2020
 * */
public class Main {

    /**
     * Determine whether a one-to-one character mapping exists from one string, s1, to another string, s2.
     *
     * @Param s1
     * @Param s2
     * */
    public boolean mapWords(String s1, String s2){
        // the one-to-one map means that the length of s1 must smaller or equal to s2
        if(s1.length() > s2.length()){
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            if(!map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i), s2.charAt(i));
            }
            if(map.get(s1.charAt(i)) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // get two parameter s1, s2 from user input
        String s1 = args[0];
        String s2 = args[1];
        Main mapWords = new Main();
        System.out.println(mapWords.mapWords(s1, s2));
    }
}
