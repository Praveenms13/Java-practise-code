class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class linkedList1 {
    Node head;
    public void add(int data) {
        Node newnode = new Node(data);
        if (head == null){
            head = newnode;
            return;
        }
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newnode;
    }
    public void addAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void displayLinkedList() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.println();
    }
    public void deleteDataFromLinkedlist(int data) {
        if (head == null) return;
        if (head.data == data) {
            head = head.next;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    public int getSize() {
        Node current = head;
        int count = 0;
        while (current != null){
            count++; 
            current = current.next;
        } 
        return count; 
    }
    public int searchElementByIndex(int searchElement) {
        int count = 0;
        Node current = head;
        while (current != null){
            if (current.data == searchElement){
                return count;
            }
            current = current.next;
            count++;
        } return -1;
    }
    public void deleteAll(){
        head = null;
    }
    public void reverseLinkedList(){
        Node prev = null;
        Node current =head;
        Node next = null;
        while (current != null){

        }
    }
    public static void main(String[] args) {
        linkedList1 list = new linkedList1();
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(40);
        list.add(330);
        list.add(22);
        list.displayLinkedList();
        list.deleteDataFromLinkedlist(330);
        list.displayLinkedList();
        int key = 40;
        System.out.println("Key to Search is: " + key + " " + list.searchElementByIndex(key));
        list.addAtBeginning(key+100);
        list.displayLinkedList();
        System.out.println("Size of the Linked List: " + list.getSize());
        System.out.println("Deleting all ....");
        list.deleteAll();
        System.out.println("Deleted all");
        list.displayLinkedList();
    }
}
