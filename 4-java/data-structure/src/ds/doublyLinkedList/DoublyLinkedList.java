package ds.doublyLinkedList;

public class DoublyLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if(size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if(size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if(size == 0) throw new IllegalStateException("A lista está vazia.");
        T value = head.value;
        if(size == 1){
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        size--;
        return value;
    }
}
