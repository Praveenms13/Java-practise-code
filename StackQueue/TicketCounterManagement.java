import java.util.LinkedList;
import java.util.Queue;
public class TicketCounterManagement {
    public static void main(String[] args) {
        // Create a Queue to represent the ticket counter line
        Queue<String> ticketQueue = new LinkedList<>();
        // Enqueue customers
        ticketQueue.add("Customer 1");
        ticketQueue.add("Customer 2");
        ticketQueue.add("Customer 3");
        ticketQueue.add("Customer 4");

        System.out.println("Initial Queue: " + ticketQueue);

        // Serve the customers
        while (!ticketQueue.isEmpty()) {
            System.out.println(ticketQueue.peek() + " is being served.");
            ticketQueue.remove();
            System.out.println("Queue after serving: " + ticketQueue);
        }
        System.out.println("All customers have been served!");
    }
}
