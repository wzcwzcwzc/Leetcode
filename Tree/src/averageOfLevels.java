import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {

        if(root == null){
            return null;
        }

        List<Double> list = new ArrayList<>();

        //use bfs to traverse the tree and use two queue to store each level, temp transfer to queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            long sum = 0;
            long count = 0;

            Queue<TreeNode> temp = new LinkedList<>();

            while(!queue.isEmpty()){
                TreeNode node = queue.remove();
                sum = sum + node.val;
                count++;

                if(node.left != null){
                    temp.add(node.left);
                }

                if(node.right != null){
                    temp.add(node.right);
                }

            }
            queue = temp;
            list.add((sum * 1.0) / count);
        }

        return list;

    }



}
