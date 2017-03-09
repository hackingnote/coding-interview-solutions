
class MinStack {

    private List<Integer> stack = new LinkedList<Integer>();
    private List<Integer> minStack = new LinkedList<Integer>();

    public int getLast(List<Integer> list) {
        return list.get(list.size() - 1);
    }

    public void push(int x) {
        stack.add(x);
        if (minStack.size() == 0 || x <= getLast(minStack)) {
            minStack.add(x);
        }
    }

    public void pop() {
        if (stack.size() >0) {
            if (getLast(stack) == getLast(minStack)) {
                minStack.remove(minStack.size() -1);
            }
            stack.remove(stack.size()  - 1);
        }
    }

    public int top() {
        if (stack.size() > 0) {
            return getLast(stack);
        }
        return -1;
    }

    public int getMin() {
        if (minStack.size() > 0) {
        return getLast(minStack);
        }
        return -1;
    }
}
