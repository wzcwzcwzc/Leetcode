public class Successor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        //if the node val > p : store the value and continue search node left
        //because there may exits smallest key bigger than p

        //if node val <= p: the successor must at right subtree of the node
        if(root == null) return null;
        TreeNode res = null;

        while(root != null){
            if(root.val > p.val){
                res = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }

        return res;
    }
}
