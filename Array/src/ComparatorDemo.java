import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        int[][] arr = new int[2][3];

        arr = new int[][]{{0, 2, 2}, {1, 1, 1}};


        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
            public int compare(int[] c1, int[] c2){
                for(int i = 1; i < c1.length; i++){
                    if(c1[i] > c2[i]){
                        return 1;
                    } else if(c1[i] < c2[i]){
                        return -1;
                    }
                }
                return c1[0] - c2[0];
            }
        });

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.println(arr[i][j]);
                // 1,1,1; 0,2,2
            }
        }
    }
}
