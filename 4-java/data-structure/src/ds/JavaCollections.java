package ds;

import java.util.*;
import java.util.stream.Collectors;

public class JavaCollections {
    public static void main(String[] args) {
        // Trabalhando com ArrayList
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");

        System.out.println("Conteúdo do ArrayList:");
        for (String lang : list) {
            System.out.println(lang);
        }

        list.remove("Python");
        Collections.sort(list);

        System.out.println("ArrayList após remoção e ordenação:");
        list.forEach(System.out::println);

        System.out.println("-----------------------------------------------");

        // Trabalhando com LinkedList
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("João");
        linkedList.add("Manoel");
        linkedList.addFirst("Marcio");
        linkedList.addLast("Hyago");

        System.out.println("Primeiro elemento da LinkedList: " + linkedList.getFirst());
        System.out.println("Conteúdo da LinkedList:");
        linkedList.forEach(System.out::println);

        System.out.println("-----------------------------------------------");

        // Trabalhando com PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.add(30);
        priorityQueue.add(10);
        priorityQueue.add(1);

        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Cabeça da PriorityQueue: " + priorityQueue.peek());

        System.out.println("Removendo elementos da PriorityQueue:");
        while (!priorityQueue.isEmpty()) {
            System.out.println("Removendo: " + priorityQueue.poll());
        }

        // Trabalhando com Queue (LinkedList como fila)
        Queue<String> linkedListQueue = new LinkedList<>();
        linkedListQueue.add("Elemento 1");
        linkedListQueue.add("Elemento 2");
        linkedListQueue.add("Elemento 45");

        System.out.println("LinkedList Queue: " + linkedListQueue);
        System.out.println("Cabeça da fila (LinkedList Queue): " + linkedListQueue.peek());

        System.out.println("-----------------------------------------------");

        // Trabalhando com HashMap
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Laranja", 3);
        hashMap.put("Beterraba", 5);
        hashMap.put("Maçã", 2);

        System.out.println("Valor associado a 'Laranja': " + hashMap.get("Laranja"));
        System.out.println("Conteúdo do HashMap:");
        hashMap.forEach((key, value) -> System.out.println(key + " -> " + value));

        System.out.println("-----------------------------------------------");

        // Filtro de palavras
        List<String> frase = new ArrayList<>(List.of("Java", "é", "uma", "linguagem", "robusta"));
        frase.removeIf(palavra -> palavra.length() < 4);
        System.out.println("Palavras com mais de 4 caracteres: " + frase);

        // Simulação de fila de espera
        Queue<String> filaDeEspera = new LinkedList<>(List.of("Ana", "Pedro", "Maria", "João"));
        System.out.println("Fila inicial: " + filaDeEspera);

        while (!filaDeEspera.isEmpty()) {
            System.out.println("Próximo a ser atendido: " + filaDeEspera.poll());
            System.out.println("Fila atual: " + filaDeEspera);
        }

        System.out.println("-----------------------------------------------");

        // Trabalhando com Streams e operações funcionais
        List<Integer> numeros = List.of(1, 2, 3, 4, 5);

        // Filtrar números pares
        List<Integer> pares = numeros.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);

        // Obter os três menores números
        List<Integer> menoresTres = numeros.stream()
                .sorted()
                .limit(3)
                .toList();
        System.out.println("Três menores números: " + menoresTres);

        // Soma de números usando reduce
        int soma = numeros.stream()
                .reduce(0, Integer::sum);
        System.out.println("Soma dos números: " + soma);

        // Transformar lista de palavras em maiúsculas
        List<String> palavras = List.of("Java", "Stream", "Aula");
        List<String> palavrasMaiusculas = palavras.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Palavras em maiúsculas: " + palavrasMaiusculas);
    }
}