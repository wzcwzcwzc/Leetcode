import java.util.*;

public class rangeSumBST {

    int sum = 0;


    public static void main(String[] args) {
//        TreeNode node1 = new TreeNode(10);
//        TreeNode node2 = new TreeNode(5);
//        TreeNode node3 = new TreeNode(3);
//        node1.left = node2;
//        node2.left = node3;
//
//        rangeSumBST rsb = new rangeSumBST();
//        System.out.println(rsb.rangeSumBST(node1, 10, 10));
        rangeSumBST rsb = new rangeSumBST();
        int[] arr = {1,2,2,1,1};
        String s = "deeedbbcccbdaa";
//        System.out.println(rsb.removeDuplicates(s, 3));

    }

    public int rangeSumBST(TreeNode root, int L, int R){

        if(root == null){
            return 0;
        }

        dfs(root, L, R);
        return sum;

    }

    public void dfs(TreeNode node, int L, int R){
        if(node != null){
            if(node.val >= L && node.val <= R){
                sum += node.val;
            }
            if(node.val > L){
                dfs(node.left, L , R);
            }

            if(node.val < R){
                dfs(node.right, L , R);
            }
        }
    }

    //todo modify the code
//    public String removeDuplicates(String s, int k) {
//
//        //使用stringbuilder来存储新的string，stack存储
//        Stack<Character> stack = new Stack<>();
//        Stack<Map<Character, Integer>> temp = new Stack<>();
//        Map<Character, Integer> map = new HashMap<>();
//
//        char[] sc = s.toCharArray();
//
//        //遍历数组，如果遇到不同则入栈，若peek()相同但未达到K个则继续, 可以使用另外一个栈存储获得的重复字符
//        for(char c : sc) {
//            if (!stack.isEmpty() && stack.peek() == c) {
//                map.put(c, map.getOrDefault(c, 1) + 1);
//                temp.push(map);
//            } else {
//                stack.push(c);
//            }
//
//            while(!stack.isEmpty() && map.size() > 0 && map.get(c) % k == 0){
//                temp.pop();
//                for(int i = 0; i < map.get(c); i++){
//                    stack.pop();
//                }
//            }
//        }
//
//        StringBuilder builder = new StringBuilder();
//        for(char c : stack){
//            builder.append(c);
//        }
//        return builder.toString();
//    }


    public boolean uniqueOccurrences(int[] arr) {

        //use hashmap to store the number <Integer, Integer>, 把integer放入set如果出现一样的就返回false

        if(arr.length == 0) return true;

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : arr){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else{
                map.put(n, 1);
            }
        }

        Set<Integer> set = new HashSet<>();

        for(Integer key : map.keySet()){
            if(!set.contains(map.get(key))){
                set.add(map.get(key));
            }else{
                return false;
            }
        }

        return true;

    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
