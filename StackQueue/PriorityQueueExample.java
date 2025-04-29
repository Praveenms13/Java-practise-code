import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        /**
         * Actually, in a PriorityQueue in Java, the element with the highest priority is the 
         * smallest element by default when using natural ordering. This is because the PriorityQueue 
         * uses a min-heap structure by default, where the smallest element (in terms of natural ordering) 
         * has the highest priority and will be dequeued first.
         */
        // Create a PriorityQueue that orders integers in ascending order (natural order)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(10);
        pq.add(30);
        pq.add(20);

        System.out.println("PriorityQueue: " + pq);  // Output: [10, 30, 20]

        // Remove the element with the highest priority (smallest element)
        System.out.println("Removed: " + pq.poll()); // Output: 10

        // Peek the top element (highest priority)
        System.out.println("Peek: " + pq.peek());   // Output: 20
    }
}
