package LinkedList;

public class LinkedList {
    private Node head;

    LinkedList() {
        head = null;
    }

    LinkedList(String data) {
        head = new Node(data);
    }

    public void append(String data) {
        Node temp = this.head;
        if (temp == null) {
            temp = new Node(data);
            head = temp;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public void prepand(String data) {
        if (data == null) return;
        Node tempNode = new Node(data);
        if (this.head != null) tempNode.next = this.head;
        this.head = tempNode;
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String peek() {
        return head.data;
    }

    public Node pop() {
        Node temp = this.head;
        this.head = this.head.next;
        return temp;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append("Markus");
        ll.append("B");
        ll.append("C");
        ll.append("D");
        ll.append(null);
        System.out.println(ll.isEmpty());
        ll.printList();
        ll.pop();
        ll.pop();
        ll.pop();
        ll.pop();
        System.out.println(" Here null pointer exception ");
        ll.pop();
        ll.pop();
    }
}
