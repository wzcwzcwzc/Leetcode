import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Permutation {


    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(nums.length == 0) return ans;

        backTrack(ans, temp, nums);
        return ans;
    }

    public void backTrack(List<List<Integer>> ans, List<Integer> temp, int[] nums){

        //goal
        //when temp.length == nums.length add the result to ans
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
        }else{
            for(int i = 0; i < nums.length; i++){
                if(temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backTrack(ans, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3};
//        Permutation p = new Permutation();
//
//        List<List<Integer>> ans = p.permute(nums);
//        for(int i = 0; i < ans.size(); i++){
//            System.out.println(ans.get(i));
//        }


    }
}
