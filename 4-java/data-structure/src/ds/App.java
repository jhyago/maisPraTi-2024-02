package ds;

import java.util.*;

public class App {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");

        for(String lang : list) {
            System.out.println(lang);
        }

        list.remove("Python");

        Collections.sort(list);
        list.forEach(System.out::println);

        System.out.println("-----------------------------------------------");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("João");
        linkedList.add("Manoel");
        linkedList.addFirst("Marcio");
        linkedList.addLast("Hyago");

        System.out.println("Primeiro elemento: " + linkedList.getFirst());

        linkedList.forEach(System.out::println);


        System.out.println("-----------------------------------------------");

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(1);
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("PriorityQueue (Cabeça da Fila): " + priorityQueue.peek());

        while(!priorityQueue.isEmpty()) {
            System.out.println("Removendo: " + priorityQueue.poll());
        }

        Queue<String> linkedListQueue = new LinkedList<>();

        linkedListQueue.add("Elemento 1");
        linkedListQueue.add("Elemento 2");
        linkedListQueue.add("Elemento 45");
        System.out.println("LinkedList Queue: " + linkedListQueue);
        System.out.println("LinkedList Queue(Cabeça da Fila): " + linkedListQueue.peek());

        System.out.println("-----------------------------------------------");

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Laranja", 3);
        hashMap.put("Beterraba", 5);
        hashMap.put("Maça", 2);

        System.out.println("Valor associada a 'Laranja': " + hashMap.get("Laranja"));

        hashMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    //Filtro de Plavras: Um programa que leia uma frase do usuário e armazene cada palavra em um ArrayList
        //Remova todas as palavras com menos de 4 caracteres e exiba a lista

        //Simulando uma Fila de Espera:

        //Crie um programa que simule uma fila de espera utilizando uma LinkedList.
        //Adicione os seguintes nomes na fila: "Ana", "Pedro", "Maria", "João".
            //    Mostre o próximo nome a ser atendido (primeiro da fila) e remova-o.
          //      Permita que o usuário insira novos nomes na fila ou remova o próximo nome a ser atendido até que a fila esteja vazia.
        //Mostre a fila a cada operação.
    }
}
