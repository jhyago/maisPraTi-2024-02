package ds.stack;
// Define o pacote onde a classe Stack está localizada, agrupando-a com outras relacionadas a estruturas de dados.

public class Stack<T> {
    Node<T> top; // Referência para o nó no topo da pilha.
    int size;    // Armazena o tamanho atual da pilha.

    // Construtor que inicializa uma pilha vazia.
    public Stack() {
        this.top = null; // Inicializa o topo da pilha como nulo.
        this.size = 0;   // Define o tamanho inicial como 0.
    }

    // Método para adicionar um elemento ao topo da pilha.
    public void push(T value) {
        Node<T> newNode = new Node<>(value); // Cria um novo nó com o valor fornecido.
        newNode.next = top; // Define o próximo nó do novo nó como o nó atual do topo.
        top = newNode;      // Atualiza o topo da pilha para o novo nó.
        size++;             // Incrementa o tamanho da pilha.
    }

    // Método para remover e retornar o elemento no topo da pilha.
    public T pop() {
        if (size == 0) { // Verifica se a pilha está vazia.
            throw new IllegalStateException("Pilha está vazia");
            // Lança uma exceção se tentar remover de uma pilha vazia.
        }
        T value = top.value; // Armazena o valor do nó no topo da pilha.
        top = top.next;      // Atualiza o topo para o próximo nó.
        size--;              // Decrementa o tamanho da pilha.
        return value;        // Retorna o valor removido.
    }
}