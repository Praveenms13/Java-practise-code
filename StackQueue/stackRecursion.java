import java.util.Stack;

public class StackRecursionExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Original Stack:");
        printStack(stack);
    }

    public static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        System.out.println(stack.pop());
        printStack(stack);
    }
}
