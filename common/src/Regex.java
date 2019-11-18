public class Regex {





    public static void main(String[] args) {


        String s = "abc,s";

        //remove not a-z A-Z
        String[] str = s.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");

        for(String word : str){
            System.out.println(word);
        }

    }



}
