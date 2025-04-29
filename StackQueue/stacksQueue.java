import java.util.Stack;
import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;

public class stacksQueue {
    /**
     * From Array Deque
     * Resizable-array implementation of the {@link Deque} interface.  Array
     * deques have no capacity restrictions; they grow as necessary to support
     * usage.  They are not thread-safe; in the absence of external
     * synchronization, they do not support concurrent access by multiple threads.
     * Null elements are prohibited.  This class is likely to be faster than
     * {@link Stack} when used as a stack, and faster than {@link LinkedList}
     * when used as a queue.
     **/

    /**
     * Stacks are not thread safe, Use Collections.synchronizedList or other mechanisms for thread safety.
     */
    public static void main (String args[]) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Stack Implementation");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.print(stack.search(10));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Queue<Integer> queue = new LinkedList<>();
        System.out.println("Queue Implementation");
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Deque<Integer> deque = new ArrayDeque<>();
        System.out.println("DeQueue Implementation");
        deque.add(10);
        deque.add(20);
        deque.add(30);
        deque.add(40);
        deque.addFirst(100);

        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());
    }
}