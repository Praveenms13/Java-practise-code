class CircularSingleLinkedList {
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
            head = newNode;
            newNode.next = head;  // First node points to itself (circular)
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;  // Traverse to the last node
            }
            temp.next = newNode;  // Insert the new node at the end
            newNode.next = head;  // New node points to head, making it circular
        }
    }

    // Function to display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
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
                    temp = temp.next;  // Traverse to the node before the head
                }
                temp.next = head.next;  // Bypass the head node
                head = head.next;  // Move the head to the next node
            }
        } else {
            System.out.println("List is empty.");
        }
    }

    // Main method to test the Circular Single Linked List
    public static void main(String[] args) {
        CircularSingleLinkedList list = new CircularSingleLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        System.out.println("Circular Single Linked List:");
        list.display();

        list.delete();  // Remove the first node
        System.out.println("After deletion:");
        list.display();
    }
}
