class CircularDoubleLinkedList {
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
            head = newNode;
            newNode.next = head;  // Pointing to itself (circular)
            newNode.prev = head;  // Pointing to itself (circular)
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;  // Traverse to the last node
            }
            temp.next = newNode;  // Insert the new node at the end
            newNode.prev = temp;  // Link previous node to the new node
            newNode.next = head;  // Make circular
            head.prev = newNode;  // Head's previous points to the new node
        }
    }

    // Function to display the list in forward direction
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);  // Loop until we come back to the head
        System.out.println("(head)");
    }

    // Function to display the list in backward direction
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        // Traverse to the last node
        while (temp.next != head) {
            temp = temp.next;
        }

        // Traverse backward
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        } while (temp != head);  // Loop until we come back to the head
        System.out.println("(head)");
    }

    // Function to delete the first node
    public void delete() {
        if (head != null) {
            if (head.next == head) {  // Only one node in the list
                head = null;
            } else {
                Node temp = head;
                while (temp.next != head) {
                    temp = temp.next;  // Traverse to the last node
                }
                temp.next = head.next;  // Link last node to the second node
                head.next.prev = temp;  // Set previous of second node to last node
                head = head.next;  // Move head to the next node
            }
        } else {
            System.out.println("List is empty.");
        }
    }

    // Main method to test the Circular Double Linked List
    public static void main(String[] args) {
        CircularDoubleLinkedList list = new CircularDoubleLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.println("Circular Double Linked List (Forward):");
        list.displayForward();

        System.out.println("Circular Double Linked List (Backward):");
        list.displayBackward();

        list.delete();  // Remove the first node
        System.out.println("After deletion (Forward):");
        list.displayForward();
    }
}
