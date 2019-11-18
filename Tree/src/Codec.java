import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    /*
    * 297 Serialize and Deserialize Binary Tree
    * */


    public String serialize(TreeNode root) {
        //preorder to transverse the tree and get array
        return preorder(root, "");
    }

    public String preorder(TreeNode node, String str){

        if(node == null){
            str += "null,";
        }else{
            str += str.valueOf(node.val) + ",";
            str = preorder(node.left, str);
            str = preorder(node.right, str);
        }
        return str;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data == null) return null;

        String[] tree = data.split(",");

        List<String> list = new LinkedList<>(Arrays.asList(tree));

        return constructTree(list);

    }

    public TreeNode constructTree(List<String> list){

        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = constructTree(list);
        root.right = constructTree(list);

        return root;
    }
}
