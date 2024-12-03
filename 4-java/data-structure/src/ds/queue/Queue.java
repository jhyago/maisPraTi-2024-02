package ds.queue;

public class Queue<T>{
    Node<T> front;
    Node<T> rear;
    int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if(isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
    }

    public T dequeue() {
        if(isEmpty()) {
           throw new IllegalStateException("A fila está vazia!");
        }
        T value = front.value;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Fila está vazia");
        return front.value;
    }

    public int size() {
        return size;
    }

    public void display() {
        Node<T> current = front;
        System.out.print("[ ");
        while(current != null) {
            System.out.print(current.value + "");
            current = current.next;
        }
        System.out.println("]");
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
