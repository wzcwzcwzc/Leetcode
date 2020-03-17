import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation_2 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length == 0) return ans;

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        backTrack(ans, temp, nums, used);
        return ans;
    }

    public void backTrack(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] used){

        if(temp.size() == nums.length){
            list.add(new ArrayList<>(temp));
        }else{
            int preNum = nums[0] - 1;
            for(int i = 0; i < nums.length; i++){
                //how to avoid the duplicates
                //use boolean to store the used
                //1, 1', 2
                if(!used[i] && nums[i] != preNum){
                    //current position needs to have constrain(1. not used 2. not the same as previous number)
                    preNum = nums[i];
                    used[i] = true;
                    temp.add(nums[i]);
                    backTrack(list, temp, nums, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }

    }
}
