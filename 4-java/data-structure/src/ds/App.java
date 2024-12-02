package ds;

import ds.doublyLinkedList.DoublyLinkedList;

public class App {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        System.out.println("Adicionando elementos no final: ");
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.display();

        System.out.println("Adicionando elementos no início: ");
        list.addFirst(-3);
        list.addFirst(-2);
        list.addFirst(-1);
        list.display();

        list.removeLast();
        list.removeFirst();
        list.display();
    }
}
