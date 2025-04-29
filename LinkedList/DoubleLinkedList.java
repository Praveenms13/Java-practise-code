class DoubleLinkedList {
    // Node class to represent each element
    static class Node {
        int data;
        Node next;
        Node prev;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Head node of the list
    Node head;

    // Function to insert a new node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;  // If the list is empty, the new node becomes the head
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;  // Traverse to the last node
            }
            temp.next = newNode;  // Insert the new node at the end
            newNode.prev = temp;  // Set the previous pointer of the new node
        }
    }

    // Function to display the list from head to tail
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function to display the list from tail to head
    public void displayBackward() {
        Node temp = head;
        if (temp == null) return;

        // Move to the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Traverse backward using prev pointer
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    // Function to delete the first node
    public void delete() {
        if (head != null) {
            if (head.next != null) {
                head = head.next;
                head.prev = null;  // Update the previous pointer of the new head
            } else {
                head = null;  // List becomes empty
            }
        } else {
            System.out.println("List is empty.");
        }
    }

    // Main method to test the Double Linked List
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.println("Double Linked List (Forward):");
        list.displayForward();

        System.out.println("Double Linked List (Backward):");
        list.displayBackward();

        list.delete();  // Remove the first node
        System.out.println("After deletion (Forward):");
        list.displayForward();
    }
}
