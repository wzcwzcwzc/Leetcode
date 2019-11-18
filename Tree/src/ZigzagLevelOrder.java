import java.util.*;

public class ZigzagLevelOrder {


    /*
    * Given a binary tree, return the zigzag level order traversal of its nodes' values.
    * (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
    * */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){


        List<List<Integer>> ans = new ArrayList<>();

        //base case
        if(root == null) return ans;

        //use queue to store each level
        //create new list to store each level nodes

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int levelCount = 0;

        while(!q.isEmpty()){

            List<Integer> oneLevel = new ArrayList<>();
            //traverse each level by using for loop
            for(int i = q.size(); i > 0; i--){
                TreeNode t = q.poll();
                oneLevel.add(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }

            //odd level need reverse
            if(levelCount % 2 == 1){
                Collections.reverse(oneLevel);
            }
            ans.add(oneLevel);
            levelCount++;
        }

        return ans;


    }
}
