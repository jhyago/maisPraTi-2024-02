package ds.queue;
// Define o pacote onde a classe está localizada, agrupando-a logicamente com outras relacionadas a estruturas de dados.

public class Queue<T> {
    Node<T> front; // Referência para o primeiro elemento (início) da fila.
    Node<T> rear;  // Referência para o último elemento (fim) da fila.
    int size;      // Armazena o tamanho atual da fila.

    // Construtor que inicializa uma fila vazia.
    public Queue() {
        this.front = null; // Inicializa o início da fila como nulo.
        this.rear = null;  // Inicializa o fim da fila como nulo.
        this.size = 0;     // Define o tamanho inicial como 0.
    }

    // Método para adicionar um elemento ao final da fila.
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value); // Cria um novo nó com o valor fornecido.
        if (isEmpty()) { // Verifica se a fila está vazia.
            front = rear = newNode; // Define o novo nó como início e fim da fila.
        } else {
            rear.next = newNode; // O próximo do último nó aponta para o novo nó.
            rear = newNode;      // Atualiza o último nó para o novo nó.
        }
        size++; // Incrementa o tamanho da fila.
    }

    // Método para remover e retornar o primeiro elemento da fila.
    public T dequeue() {
        if (isEmpty()) { // Verifica se a fila está vazia.
            throw new IllegalStateException("A fila está vazia!");
            // Lança uma exceção se tentar remover de uma fila vazia.
        }
        T value = front.value; // Armazena o valor do primeiro nó.
        front = front.next;    // Atualiza o início da fila para o próximo nó.
        if (front == null) {   // Se o início for nulo após a remoção...
            rear = null;       // Atualiza o fim também para nulo (fila vazia).
        }
        size--; // Decrementa o tamanho da fila.
        return value; // Retorna o valor removido.
    }

    // Método para retornar o primeiro elemento da fila sem removê-lo.
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Fila está vazia");
        // Lança uma exceção se tentar visualizar uma fila vazia.
        return front.value; // Retorna o valor do nó no início da fila.
    }

    // Método para retornar o tamanho atual da fila.
    public int size() {
        return size; // Retorna o valor do atributo `size`.
    }

    // Método para exibir os elementos da fila.
    public void display() {
        Node<T> current = front; // Começa a iteração no início da fila.
        System.out.print("[ ");  // Inicia a representação visual da fila.
        while (current != null) { // Itera enquanto houver elementos na fila.
            System.out.print(current.value + " "); // Exibe o valor do nó atual.
            current = current.next; // Move para o próximo nó.
        }
        System.out.println("]"); // Fecha a representação visual da fila.
    }

    // Método para verificar se a fila está vazia.
    public boolean isEmpty() {
        return size == 0; // Retorna verdadeiro se o tamanho for 0.
    }
}