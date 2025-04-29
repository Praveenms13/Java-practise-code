import java.util.PriorityQueue;

public class TaskSchedulerPriorityQ {
    static class Task implements Comparable<Task> {
        String taskName;
        int priority;

        Task(String taskName, int priority) {
            this.taskName = taskName;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            // Lower number means higher priority
            return Integer.compare(this.priority, other.priority);
        }

        @Override
        public String toString() {
            return taskName + " (Priority: " + priority + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();

        // Adding tasks with different priorities
        taskQueue.add(new Task("Task1", 3)); // Low priority
        taskQueue.add(new Task("Task2", 1)); // High priority
        taskQueue.add(new Task("Task3", 2)); // Medium priority

        // Processing tasks based on priority
        while (!taskQueue.isEmpty()) {
            System.out.println("Processing: " + taskQueue.poll());
        }
    }
}
