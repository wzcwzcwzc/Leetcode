import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        //backtrack problem, recursion

        //1. put current into res
        //2. get new element
        //3. continue get next element, recursion
        //4. drop previous element

        //need index to store the current position of nums

        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        helper(res, 0, temp, nums);
        return res;
    }

    public void helper(List<List<Integer>> res, int index, List<Integer> temp, int[] nums){
        //1. put current element into res, need to pay attention to scope of variable temp
        //we need to create new ArrayList to store temp
        res.add(new ArrayList<>(temp));
        //2. get new element, from index to the end of nums
        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            helper(res, i + 1, temp, nums);
            //remove the last element, which is backtrack
            temp.remove(temp.size() - 1);
        }
    }
}
