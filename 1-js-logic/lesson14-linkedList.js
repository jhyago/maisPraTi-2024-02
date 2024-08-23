class Node {
    constructor(data){
        // Construtor da classe Node, que define o nó da lista.
        // Ele recebe um valor 'data' e inicializa o próximo nó como 'null'.
        this.data = data
        this.next = null
    }
}

class LinkedList {
    constructor(){
        // Construtor da classe LinkedList, que inicializa a lista.
        // 'head' representa o primeiro nó da lista (inicialmente 'null').
        // 'size' mantém o tamanho da lista (inicialmente 0).
        this.head = null
        this.size = 0
    }

    add(data) {
        // Método para adicionar um novo nó ao final da lista.
        let newNode = new Node(data) // Cria um novo nó com os dados fornecidos.

        if(this.head === null){
            // Se a lista estiver vazia (head é null), o novo nó se torna o head.
            this.head = newNode
        } else {
            // Se a lista não estiver vazia, percorre até o final e adiciona o novo nó.
            let current = this.head
            while(current.next !== null){
                current = current.next
            }
            // Atribui o novo nó ao próximo do último nó encontrado.
            current.next = newNode
        }

        this.size++ // Incrementa o tamanho da lista.
    }

    insertAt(data, index){
        // Método para inserir um novo nó em uma posição específica.
        if(index < 0 || index > this.size){
            // Se o índice for inválido, exibe uma mensagem e retorna.
            return console.log('Index fora dos limites!')
        }

        let newNode = new Node(data) // Cria um novo nó com os dados fornecidos.
        let current = this.head // Começa do início da lista.
        let previous

        if(index === 0){
            // Se o índice for 0, o novo nó se torna o head.
            newNode.next = this.head
            this.head = newNode
        } else {
            // Se o índice não for 0, percorre a lista até o índice desejado.
            for(let i = 0; i < index; i++){
                previous = current
                current = current.next
            }

            // Insere o novo nó entre 'previous' e 'current'.
            newNode.next = current
            previous.next = newNode
        }
        
        this.size++ // Incrementa o tamanho da lista.
    }

    removeFrom(index){
        // Método para remover um nó de uma posição específica.
        if(index < 0 || index > this.size){
            // Se o índice for inválido, exibe uma mensagem e retorna.
            return console.log('Index fora dos limites!')
        }

        let current = this.head // Começa do início da lista.
        let previous

        if(index === 0){
            // Se o índice for 0, remove o head e define o próximo nó como head.
            this.head = current.next
        } else {
            // Se o índice não for 0, percorre a lista até o índice desejado.
            for(let i = 0; i < index; i++){
                previous = current
                current = current.next
            }

            // Remove o nó atual, conectando 'previous' ao próximo nó de 'current'.
            previous.next = current.next
        }

        this.size = this.size - 1 // Decrementa o tamanho da lista.
        return current.data // Retorna os dados do nó removido.
    }

    indexOf(data) {
        // Método para encontrar o índice de um nó específico na lista.
        let current = this.head // Começa do início da lista.
        let index = 0

        while(current !== null){
            // Percorre a lista até encontrar o nó com os dados correspondentes.
            if(current.data === data){
                return index // Retorna o índice se encontrar o nó.
            }
            index++
            current = current.next
        }

        return -1 // Retorna -1 se o nó não for encontrado.
    }    

    isEmpty() {
        // Método para verificar se a lista está vazia.
        return this.size === 0
    }

    sizeOfList() {
        // Método para retornar o tamanho atual da lista.
        return this.size
    }

    printList() {
        // Método para imprimir todos os elementos da lista.
        let current = this.head // Começa do início da lista.
        while(current !== null){
            console.log(current.data) // Imprime os dados do nó atual.
            current = current.next // Move para o próximo nó.
        }
    }
}

// Instancia uma nova lista encadeada.
let list = new LinkedList()

// Adiciona elementos à lista.
list.add("Elemento 0")
list.add("Elemento 1")
list.add("Elemento 2")
list.add("Elemento 3")

// Encontra o índice de um elemento específico na lista.
console.log(list.indexOf("Elemento 3")) // Deve imprimir 3, pois "Elemento 3" está na quarta posição.

// Remove o segundo elemento da lista.
list.removeFrom(1) // Remove "Elemento 1".

// Imprime a lista atualizada.
list.printList()

// Imprime o tamanho da lista.
console.log(list.sizeOfList()) // Deve imprimir 3, pois removemos um elemento.