import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    /*
    *
    *
    * Given a matrix of m x n elements (m rows, n columns),
    * return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    *
    *
    * */

    public List<Integer> spiralOrder(int[][] matrix) {

        //use four indexes to define the margin of matrix

        List<Integer> res = new ArrayList<>();

        if(matrix.length == 0 || matrix[0].length == 0) return res;

        int firstRow = 0;
        int firstCol = 0;
        int lastRow = matrix.length - 1;
        int lastCol = matrix[0].length - 1;

        while(firstRow <= lastRow && firstCol <= lastCol){

            //print first row
            for(int i = firstCol; i <= lastCol; i++){
                res.add(matrix[firstRow][i]);
            }

            firstRow++;

            //print last col
            for(int i = firstRow; i <= lastRow; i++){
                res.add(matrix[i][lastCol]);
            }

            lastCol--;

            //print last row
            if(firstRow <= lastRow){
                for(int i = lastCol; i >= firstCol; i--){
                    res.add(matrix[lastRow][i]);
                }
                lastRow--;
            }

            //print first col
            if(firstCol <= lastCol){

                for(int i = lastRow; i >= firstRow; i--){
                    res.add(matrix[i][firstCol]);
                }
                firstCol++;

            }

        }

        return res;

    }


}
