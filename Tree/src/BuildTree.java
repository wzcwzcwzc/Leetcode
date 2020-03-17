import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    /*
    *
    * Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
    *
    * */

    int pre_index = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int index = 0;
        for(int i : inorder){
            map.put(i, index++);
        }

        return helper(0, inorder.length);

    }

    public TreeNode helper(int in_left, int in_right){

        if(in_left == in_right) return null;

        int root_val = preorder[pre_index];
        TreeNode root = new TreeNode(root_val);

        int index = map.get(root_val);

        pre_index++;
        root.left = helper(in_left, index);
        root.right = helper(index+1, in_right);
        return root;
    }
}
