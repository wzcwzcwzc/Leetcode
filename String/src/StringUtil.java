import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringUtil {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        String s = "123";
        s.charAt(1);
        s.split(" ");
        s.indexOf(" ");
        char[] c = s.toCharArray();


        Comparator<String> com = new Comparator<String>(){

            public int compare(String s1, String s2){

                return 1;
            }

        };


        Collections.sort(list, com);
    }
}
