import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {


    /*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
    *
    * */

    public int[][] merge(int[][] intervals) {

        //base case
        if(intervals.length == 0) return new int[0][];

        //sort the list
        Arrays.sort(intervals, ((int[] o1, int[] o2) -> o1[0] - o2[0]));

        //create list to store the ans
        List<int[]> list = new ArrayList<>();

        int[] pre = intervals[0];
        list.add(pre);

        for(int i = 0; i < intervals.length; i++){
            int[] curr = intervals[i];
            //1. overlap pre[1] >= curr[0] && pre[1] <= curr[1]
            if(pre[1] >= curr[0] && pre[1] <= curr[1]){
                pre[1] = curr[1];
                //2. include pre[1] >= curr[1] do nothing
            }else if(pre[1] >= curr[1]){
                continue;
            }else{
                //3. not overlap
                int[] newInterval = {curr[0], curr[1]};
                list.add(newInterval);
                pre = newInterval;
            }
        }

        //construct result: list -> int[][]
        int[][] result = new int[list.size()][];
        for(int i = 0; i < list.size(); i++){
            result[i] = list.get(i);
        }

        return result;

    }

}
