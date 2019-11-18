import java.util.Arrays;

public class KClosest {

    /*
    * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
    *
    * */

    public int[][] kClosest(int[][] points, int K) {


        //brute force, calculate all points distance and sort

        //O(nlogn)

        int[] distance = new int[points.length];


        for(int i = 0; i < distance.length; i++){
            distance[i] = Cal_distance(points[i]);
        }

        //in order to get the K closet distance
        Arrays.sort(distance);

        int[][] res = new int[K][2];
        int j = 0;

        for(int i = 0; i < distance.length; i++){


            if(Cal_distance(points[i]) <= distance[K-1]){
                //if the distance of points[i] smaller than sorted distance[K-1], we need to add to result
                res[j] = points[i];
                j++;
            }

        }

        return res;
    }

    public int Cal_distance(int[] points){
        return points[0] * points[0] + points[1] * points[1];
    }
}