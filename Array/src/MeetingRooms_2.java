import java.util.Arrays;

public class MeetingRooms_2 {

    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length == 0) return 0;

        int[] preTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            preTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(preTime);
        Arrays.sort(endTime);

        int res = 0;
        int endPoint = 0;
        //in order to find the time gap between different time stamp

        //if preTime is smaller than endTime, it means we need room
        //else if preTime is bigger than endTime, we do not need to add room
        //but to check later endTime and see whether there is overlap
        for(int i = 0; i < intervals.length; i++){
            if(preTime[i] < endTime[endPoint]) res++;
            else endPoint++;
        }

        return res;
    }
}
