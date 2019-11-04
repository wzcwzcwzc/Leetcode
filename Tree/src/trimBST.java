public class trimBST {


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node2.left = node3;

        trimBST t = new trimBST();
        TreeNode root = t.trimBST(node1, 3, 5);
        dfs(root);
    }

    public static void dfs(TreeNode node){
        if(node == null) return;

        dfs(node.left);
        System.out.println(node.val);
        dfs(node.right);

    }

    public TreeNode trimBST(TreeNode root, int L, int R) {

        //use stack to store the whole tree and judge each node whether between L and R == recursion

        if(root == null) return null;//终止条件

        if(root.val < L) {
            return trimBST(root.right, L, R);
        }

        if(root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;


    }
}
