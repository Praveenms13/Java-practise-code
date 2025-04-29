class Node {
    String name;
    int rollNumber;
    int age;
    char grade;
    Node next;
    Node(String name, int age, int rollNumber, char grade) {
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
}
public class linkedList2 {
    Node head;
    public void addDataAtEnd(String name, int age, int rollNumber, char grade){
        Node newNode = new Node(name, age, rollNumber, grade);
        if (head == null) {
            head = newNode; 
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    public void addDataAtBeginning(String name, int age, int rollNumber, char grade){
        Node newNode = new Node(name, age, rollNumber, grade);
        newNode.next = head;
        head = newNode;
    }
    public void addAtSpecificIndex(int index, String name, int age, int rollNumber, char grade) {
        int count = 0;
        if (head == null) { 
            System.err.println("There is no elements is the current linked list ..");
            System.exit(0); 
        }
        Node current = head;
        Node newNode = new Node(name, age, rollNumber, grade);
        while (current != null && count < index - 1){
            count++;
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    public void displayLinkedList() {
        Node current = head;
        int cnt = 0;
        while (current != null) {
            System.out.print("Index => " + (cnt) + " Node " + ++cnt + " ==> Name: "+current.name+" RollNumber: "+current.rollNumber+" Age: "+current.age+" Grade: "+current.grade);
            System.out.println();
            current = current.next;
        } 
        System.out.println("Index => " + (cnt) + " Node " + ++cnt + " ==> null");
    }
    public void deleteStudentDataByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            System.exit(0);
        }
        if (head.rollNumber == rollNumber) {
            head = head.next; 
            return;
        }
        Node current = head;
        while(current.next != null){
            System.out.println("Checking " + current.next.rollNumber);
            if(current.next.rollNumber == rollNumber) {
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }
    }
    public void searchStudentByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty");
            System.exit(0);
        }
        if (head.rollNumber == rollNumber) {
            System.out.println("The student data is in first Index itself ...");
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            if (current.rollNumber == rollNumber) {
                System.out.println("Student Data Found at " + count + " Index");
                return;
            }
            current = current.next;
        }
    }
    public void updateStudentsGrade(int rollNumber, char grade) {
        if (head == null) {
            System.out.println("List is empty");
            System.exit(0);
        }
        if (head.rollNumber == rollNumber) {
            head.grade = grade;
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = grade;
            }
            current = current.next;
        }
    }
    public static void main(String[] args) {
        linkedList2 linkedList2Obj = new linkedList2();
        linkedList2Obj.addDataAtBeginning("Praveen", 21, 91, 'A');
        linkedList2Obj.addDataAtBeginning("Prakash", 23, 48, 'B');
        linkedList2Obj.addDataAtBeginning("Nelson", 22, 04, 'C');
        linkedList2Obj.addDataAtEnd("Vibusha", 28, 44, 'D');
        linkedList2Obj.displayLinkedList();
        System.out.println("After Inserting At Specific Index");
        linkedList2Obj.addAtSpecificIndex(3, "kaushik", 28, 45, 'D');
        linkedList2Obj.displayLinkedList();
        linkedList2Obj.deleteStudentDataByRollNumber(44);
        linkedList2Obj.displayLinkedList();
        linkedList2Obj.searchStudentByRollNumber(45);
        linkedList2Obj.updateStudentsGrade(45, 'X');
        linkedList2Obj.displayLinkedList();
    }
}
