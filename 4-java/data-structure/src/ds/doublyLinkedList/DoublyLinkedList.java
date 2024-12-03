package ds.doublyLinkedList;
// Define o pacote onde a classe está localizada, geralmente organizado para agrupar classes relacionadas.

// Classe genérica que implementa uma lista duplamente encadeada
public class DoublyLinkedList<T> {
    Node<T> head; // Referência ao primeiro nó (cabeça) da lista.
    Node<T> tail; // Referência ao último nó (cauda) da lista.
    int size;     // Armazena o tamanho atual da lista.

    // Construtor padrão que inicializa uma lista vazia.
    public DoublyLinkedList() {
        this.head = null; // Inicializa a cabeça como nula.
        this.tail = null; // Inicializa a cauda como nula.
        this.size = 0;    // Inicializa o tamanho como 0.
    }

    // Método para adicionar um elemento no final da lista.
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value); // Cria um novo nó com o valor fornecido.
        if(size == 0) { // Verifica se a lista está vazia.
            head = tail = newNode; // Define o novo nó como cabeça e cauda.
        } else {
            tail.next = newNode;     // O próximo do nó atual da cauda aponta para o novo nó.
            newNode.previous = tail; // O anterior do novo nó aponta para a cauda atual.
            tail = newNode;          // Atualiza a cauda para o novo nó.
        }
        size++; // Incrementa o tamanho da lista.
    }

    // Método para adicionar um elemento no início da lista.
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value); // Cria um novo nó com o valor fornecido.
        if(size == 0) { // Verifica se a lista está vazia.
            head = tail = newNode; // Define o novo nó como cabeça e cauda.
        } else {
            newNode.next = head;   // O próximo do novo nó aponta para a cabeça atual.
            head.previous = newNode; // O anterior da cabeça atual aponta para o novo nó.
            head = newNode;        // Atualiza a cabeça para o novo nó.
        }
        size++; // Incrementa o tamanho da lista.
    }

    // Método para remover e retornar o primeiro elemento da lista.
    public T removeFirst() {
        if(size == 0) throw new IllegalStateException("A lista está vazia.");
        // Verifica se a lista está vazia e lança uma exceção se estiver.

        T value = head.value; // Armazena o valor do nó da cabeça.
        if(size == 1) {       // Caso haja apenas um elemento na lista.
            head = tail = null; // Define cabeça e cauda como nulas.
        } else {
            head = head.next;  // Atualiza a cabeça para o próximo nó.
            head.previous = null; // Remove a referência ao nó anterior.
        }
        size--; // Decrementa o tamanho da lista.
        return value; // Retorna o valor removido.
    }

    // Método para remover e retornar o último elemento da lista.
    public T removeLast() {
        if(size == 0) throw new IllegalStateException("Lista vazia.");
        // Verifica se a lista está vazia e lança uma exceção se estiver.

        T value = tail.value; // Armazena o valor do nó da cauda.
        if(size == 1) {       // Caso haja apenas um elemento na lista.
            head = tail = null; // Define cabeça e cauda como nulas.
        } else {
            tail = tail.previous; // Atualiza a cauda para o nó anterior.
            tail.next = null;     // Remove a referência ao próximo nó.
        }
        size--; // Decrementa o tamanho da lista.
        return value; // Retorna o valor removido.
    }

    // Método para exibir os elementos da lista.
    public void display() {
        Node<T> current = head; // Começa a iteração a partir da cabeça.
        System.out.print("[ "); // Inicia a representação da lista.
        while(current != null){ // Itera enquanto houver nós na lista.
            System.out.print(current.value + " "); // Exibe o valor do nó atual.
            current = current.next; // Move para o próximo nó.
        }
        System.out.println("]"); // Fecha a representação da lista.
    }

    // Método para retornar o tamanho atual da lista.
    public int size() {
        return this.size; // Retorna o atributo de tamanho.
    }
}