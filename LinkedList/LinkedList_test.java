import java.util.*;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    public void createNode(String word) {
        Node newNode = new Node(word);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void displayLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " => ");
            current = current.next;
        }
        System.out.print("null");
    }
    public LinkedList copyLinkedlist() {
        LinkedList copy = new LinkedList();
        if (head == null) return copy;
        Stack <String> stack = new Stack<>();
        Node current = head;
        while (current != null) {
            char[] arr = current.data.toCharArray();
            Arrays.sort(arr);
            String a = new String(arr);
            stack.push(a);
            current = current.next;
        }
        while (!stack.isEmpty()) {
            copy.createNode(stack.pop());
        }
        return copy;
    }
}
public class LinkedList_test {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.print("\nOriginal List: ");
        list.createNode("pat");
        list.createNode("tea");
        list.createNode("tan");
        list.createNode("ate");
        list.createNode("nat");
        list.createNode("bat");
        list.displayLinkedList();

        System.out.print("\nCopied List: ");
        LinkedList copy = list.copyLinkedlist();
        copy.displayLinkedList();
    }
}