import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {

        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // pop twice
        if(min == stack.pop()){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
