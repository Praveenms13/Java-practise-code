class SingleLinkedList {
    // Node class to represent each element
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
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
        }
    }

    // Function to display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function to delete the first node
    public void delete() {
        if (head != null) {
            head = head.next;  // Remove the head node
        } else {
            System.out.println("List is empty.");
        }
    }

    // Main method to test the Single Linked List
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.println("Single Linked List:");
        list.display();

        list.delete();  // Remove the first node
        System.out.println("After deletion:");
        list.display();
    }
}
