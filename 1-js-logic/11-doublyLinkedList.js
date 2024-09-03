// Define a classe Node, que representa um nó na lista duplamente ligada.
class Node {
    constructor(data){
        this.data = data      // Armazena o dado no nó.
        this.next = null      // Ponteiro para o próximo nó, inicialmente nulo.
        this.previous = null  // Ponteiro para o nó anterior, inicialmente nulo.
    }
}

// Define a classe DoublyLinkedList, que representa uma lista duplamente ligada.
class DoublyLinkedList {
    constructor(){
        this.head = null  // Ponteiro para o primeiro nó da lista (cabeça), inicialmente nulo.
        this.tail = null  // Ponteiro para o último nó da lista (cauda), inicialmente nulo.
        this.size = 0     // Contador de nós na lista, inicialmente 0.
    }

    // Método para adicionar um novo nó ao final da lista.
    add(data){
        let newNode = new Node(data)  // Cria um novo nó com o dado fornecido.

        if(this.head === null){       // Se a lista estiver vazia (cabeça é nula):
            this.head = newNode       // O novo nó se torna a cabeça da lista.
            this.tail = newNode       // O novo nó também se torna a cauda da lista.
        } else {                      // Se a lista não estiver vazia:
            this.tail.next = newNode  // Atualiza o ponteiro 'next' do nó atual da cauda para o novo nó.
            newNode.previous = this.tail  // Define o ponteiro 'previous' do novo nó para o nó atual da cauda.
            this.tail = newNode       // Atualiza a cauda para ser o novo nó.
        }

        this.size++  // Incrementa o contador de tamanho da lista.
    }

    // Método para inserir um nó em uma posição específica.
    insertAt(data, index){
        if(index < 0 || index > this.size){  // Verifica se o índice está fora dos limites.
            return console.log('Index fora dos limites!')  // Se estiver, imprime uma mensagem de erro.
        }

        let newNode = new Node(data)  // Cria um novo nó com o dado fornecido.
        let current = this.head       // Começa a partir do primeiro nó (cabeça).

        if(index === 0){  // Se o índice for 0, inserir no início da lista:
            if(this.head === null){   // Se a lista estiver vazia:
                this.head = newNode   // O novo nó se torna a cabeça.
                this.tail = newNode   // O novo nó se torna a cauda.
            } else {                  // Se a lista não estiver vazia:
                newNode.next = this.head  // O próximo nó do novo nó será o antigo primeiro nó.
                this.head.previous = newNode  // O ponteiro 'previous' do antigo primeiro nó é atualizado para o novo nó.
                this.head = newNode   // O novo nó se torna a cabeça.
            }
        } else if(index === this.size){  // Se o índice for igual ao tamanho da lista, inserir no final:
            this.tail.next = newNode  // O próximo nó do nó atual da cauda será o novo nó.
            newNode.previous = this.tail  // O ponteiro 'previous' do novo nó será o nó atual da cauda.
            this.tail = newNode       // O novo nó se torna a cauda.
        } else {  // Caso contrário, inserir em uma posição intermediária:
            for(let i = 0; i < index; i++){  // Percorre a lista até o nó na posição desejada.
                current = current.next
            }

            newNode.next = current  // O próximo nó do novo nó será o nó atual da posição.
            newNode.previous = current.previous  // O nó anterior ao novo nó será o nó anterior ao atual.
            current.previous.next = newNode  // O próximo nó do anterior será o novo nó.
            current.previous = newNode  // O ponteiro 'previous' do nó atual será o novo nó.
        }

        this.size++  // Incrementa o contador de tamanho da lista.
    }

    // Método para remover um nó de uma posição específica.
    removeAt(index) {
        if(index < 0 || index >= this.size){  // Verifica se o índice está fora dos limites.
            return console.log("Index fora dos limites!")  // Se estiver, imprime uma mensagem de erro.
        }

        let current = this.head  // Começa a partir do primeiro nó (cabeça).

        if(index === 0){  // Se o índice for 0, remover o primeiro nó:
            this.head = this.head.next  // Atualiza a cabeça para o próximo nó.

            if(this.head !== null){  // Se a lista não estiver vazia após a remoção:
                this.head.previous = null  // O ponteiro 'previous' da nova cabeça é atualizado para nulo.
            } else {
                this.tail = null  // Se a lista ficou vazia, a cauda também é atualizada para nulo.
            }
        } else if(index === this.size - 1){  // Se o índice for o último, remover o nó da cauda:
            this.tail = this.tail.previous  // Atualiza a cauda para o nó anterior.
            this.tail.next = null  // O próximo nó da nova cauda é atualizado para nulo.
        } else {  // Caso contrário, remover um nó de uma posição intermediária:
            for(let i = 0; i < index; i++){  // Percorre a lista até o nó na posição desejada.
                current = current.next
            }

            current.previous.next = current.next  // Atualiza o próximo nó do anterior para o próximo nó.
            current.next.previous = current.previous  // Atualiza o nó anterior do próximo para o anterior.
        }

        this.size--  // Decrementa o contador de tamanho da lista.
    }

    // Método para obter o dado de um nó em uma posição específica.
    getData(index){
        if(index < 0 || index >= this.size){  // Verifica se o índice está fora dos limites.
            return console.log("Index fora dos limites!")  // Se estiver, imprime uma mensagem de erro.
        }

        let current = this.head  // Começa a partir do primeiro nó (cabeça).

        for(let i = 0; i < index; i++){  // Percorre a lista até o nó na posição desejada.
            current = current.next
        }

        return current.data  // Retorna o dado armazenado no nó.
    }

    // Método para imprimir os dados da lista.
    print(){
        let current = this.head  // Começa a partir do primeiro nó (cabeça).
        let result = []  // Array para armazenar os dados para impressão.

        while(current !== null){  // Percorre a lista até o final.
            result.push(current.data)  // Adiciona o dado do nó atual ao array.
            current = current.next  // Avança para o próximo nó.
        }

        console.log(result.join(' <=> '))  // Imprime a lista no formato "data1 <=> data2 <=> ..."
    }

    // Método para obter o tamanho da lista.
    getSize(){
        return this.size  // Retorna o número de nós na lista.
    }

    // Método para verificar se a lista está vazia.
    isEmpty(){
        return this.size === 0  // Retorna verdadeiro se a lista estiver vazia.
    }

    // Método para limpar a lista, removendo todos os nós.
    clear(){
        this.head = null  // Define a cabeça como nula.
        this.tail = null  // Define a cauda como nula.
        this.size = 0     // Reseta o tamanho da lista para 0.

        console.log("Lista limpa!")  // Imprime uma mensagem indicando que a lista foi limpa.
    }
}

// Exemplo de uso da lista duplamente ligada.
let lista = new DoublyLinkedList()

// Adiciona alguns elementos à lista.
lista.add(10)
lista.add(20)
lista.add(30)
lista.add(40)
lista.add(50)

// Imprime a lista completa.
lista.print()

// Insere elementos em posições específicas.
lista.insertAt(5, 0)  // Insere 5 na posição 0.
lista.insertAt(15, 3)  // Insere 15 na posição 3.
lista.insertAt(55, lista.getSize())  // Insere 55 no final da lista.

// Imprime a lista após as inserções.
lista.print()

// Remove elementos de posições específicas.
lista.removeAt(0)  // Remove o elemento na posição 0.
lista.removeAt(3)  // Remove o elemento na posição 3.
lista.removeAt(lista.getSize() - 1)  // Remove o último elemento.

// Imprime a lista após as remoções.
lista.print()

// Obtém o dado de um nó na posição 2.
console.log("Elemento na posição 2:", lista.getData(2))

// Verifica se a lista está vazia.
console.log("A lista está vazia?", lista.isEmpty())

// Imprime o tamanho atual da lista.
console.log("Tamanho da lista?", lista.getSize())