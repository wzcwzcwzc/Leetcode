public class increasingBST {

    //当遇到初始节点初始化困难，可以采用pre节点初始化为-1，然后输出pre.right
    TreeNode pre = new TreeNode(-1);
    TreeNode ans = pre;
    //rearrange the tree in order, use dfs to do inorder search and reconstruct the tree
    public TreeNode increasingBST(TreeNode root) {

        if(root == null){
            return null;
        }

        dfs(root);
        return pre.right;

    }

    public void dfs(TreeNode node){

        if(node == null) return;
        dfs(node.left);
        ans.right = new TreeNode(node.val);
        ans = ans.right;
        dfs(node.right);

    }
}
