import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTools {

    //1. tree traverse bfs

    public void traverse(TreeNode root){


        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.peek();
            if(node.left != null){
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }
        }
    }


    public static void main(String[] args) {



    }


}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        this.val = x;
    }


}
