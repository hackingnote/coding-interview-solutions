
public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       stack1 = new Stack<>();
       stack2 = new Stack<>();
    }

    public void push(int element) {
        stack2.push(element);
    }

    public int pop() {
        if (stack1.isEmpty()) {
            move();
        }
        return stack1.pop();
    }

    public int top() {
        if (stack1.isEmpty()) {
            move();
        }
        return stack1.peek();
    }

    private void move() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
}