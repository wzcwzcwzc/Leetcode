import java.util.Stack;

public class newStack {

    Stack<Integer> stack;
    int stackMaxSize;
    Stack<Integer> temp;
    int cur_size;

    public newStack(int maxSize) {
        stack = new Stack<>();
        temp = new Stack<>();
        stackMaxSize = maxSize;
        cur_size = 0;
    }

    public void push(int x) {
        // judge the size of stack
        if(cur_size < stackMaxSize){
            stack.push(x);
            cur_size++;
        }
    }

    public int pop() {
        if(stack.isEmpty()) {
            return -1;
        }

        int ans = stack.pop();
        cur_size--;
        return ans;
    }

    public void increment(int k, int val) {
        while(!stack.isEmpty()){
            int x = stack.pop();
            temp.push(x);
        }

        // need to consider that the relationship of cur_size and k
        if(k >= stackMaxSize || k >= cur_size){
            // update all elements in stack
            while(!temp.isEmpty()){
                int kk = temp.pop();
                stack.push(kk + val);
            }
        }else{
            for(int j = 0; j < k; j++) {
                int s = temp.pop();
                stack.push(s + val);
            }
        }

        while(!temp.isEmpty()){
            int ele = temp.pop();
            stack.push(ele);
        }

        temp = new Stack<>();
    }


    public static void main(String[] args) {
        newStack ns = new newStack(10);
        ns.push(83);
        ns.increment(2, 60);
        System.out.println(ns.pop());
//        System.out.println(ns.pop());
//        System.out.println(ns.pop());
//        System.out.println(ns.pop());

        /*
        * ["CustomStack","push","increment","increment","increment","push","push","push","increment","push","push","increment","pop","pop","push"]
[[12],[83],[2,60],[9,61],[1,60],[82],[21],[58],[8,8],[22],[80],[1,64],[],[],[24]]
        * */
    }
}
