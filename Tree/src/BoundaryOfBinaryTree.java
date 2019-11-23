import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree {

    /*
    * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1

Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].
    *
    * */


    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        //anti clock means left leaf right

        //use recursion, dfs

        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        //if root is only one node, it is also leaf, which means
        //we may add twice root
        if(root.left != null || root.right != null){
            ans.add(root.val);
        }

        left_dfs(root.left, ans);
        leaf_dfs(root, ans);
        right_dfs(root.right, ans);

        return ans;

    }

    public void leaf_dfs(TreeNode node, List<Integer> ans){
        if(node == null) return;

        //recursion until we find the leaf
        if(node.left == null && node.right == null){
            ans.add(node.val);
        }

        leaf_dfs(node.left, ans);
        leaf_dfs(node.right, ans);
    }

    public void left_dfs(TreeNode node, List<Integer> ans){
        //recursion ending condition
        if(node == null || (node.left == null && node.right == null)) return;

        //from top to bottom
        ans.add(node.val);
        if(node.left == null){
            left_dfs(node.right, ans);
        }else{
            left_dfs(node.left, ans);
        }
    }

    public void right_dfs(TreeNode node, List<Integer> ans){

        if(node == null || (node.left == null && node.right == null)) return;

        if(node.right == null){
            right_dfs(node.left, ans);
        }else{
            right_dfs(node.right, ans);
        }
        //from bottom to top
        ans.add(node.val);
    }

}
