package Stack;

public class Stack {
    private final String[] stack;
    private int head;
    private final int size;

    Stack(int size) {
        this.size = size;
        this.stack = new String[size];
        this.head = 0;
    }

    public void push(String data) {
        if (head != size) {
            stack[head++] = data;
            return;
        }
        throw new IllegalStateException("Stack is full");
    }

    public String pop() {
        if (!isEmpty()) {
            String temp = stack[head - 1];
            stack[head - 1] = null;
            head--;
            return temp;
        }
        throw new IllegalStateException("Stack is Empty");
    }

    public boolean isEmpty() {
        return head == 0;
    }

    public String peek() {
        return stack[head];
    }

    public static void main(String[] args) {
        Stack stack1 = new Stack(20);
        System.out.println(stack1.isEmpty());
        stack1.push("Markus");
        stack1.push("Bernhard");
        stack1.push("Papa");
        stack1.push("Mama");
        stack1.push("Eva");
    
        while (!stack1.isEmpty()) {
            System.out.println("On the Stack: " + stack1.pop());
        }
    }
}
