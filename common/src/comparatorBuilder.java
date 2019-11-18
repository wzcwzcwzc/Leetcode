import java.util.*;

public class comparatorBuilder {


    /*
    * this file is build up a comparator in java
    *
    * */

    public static void main(String[] args) {

        int [][] arr = {{1,2}, {1, 3}, {4,5}};

        //how to write a comparator
        //compare first element of each array
        Arrays.sort(arr, ((int[] o1, int[] o2) -> (o1[0] - o2[0])));

        Comparator<Integer> com = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        };


    }
}
