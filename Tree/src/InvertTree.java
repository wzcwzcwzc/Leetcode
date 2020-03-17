public class InvertTree {


    /*
    *
    *
    *
    * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
    *
    * */

    public TreeNode invertTree(TreeNode root){

        //from down to up

        //condition to finish recursion,当走到root节点为空的时候说明到了树的底部
        if(root == null) return null;

        //get right and left node of next level
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        //do exchange
        root.left = right;
        root.right = left;

        return root;
    }
}
