// Seleciona o elemento HTML com o ID 'titulo' e o armazena na variável 'titulo'
let title = document.getElementById('title')

// Seleciona o botão com o ID 'adicionarItem' e o armazena na variável 'botaoAdicionarItem'
let botaoAdicionarItem = document.getElementById('addItem')

// Seleciona o botão com o ID 'removerItem' e o armazena na variável 'botaoRemoverItem'
let botaoRemoverItem = document.getElementById('removeItem')

// Seleciona o elemento HTML com o ID 'lista' (uma lista não ordenada - ul) e o armazena na variável 'lista'
let list = document.getElementById('list')

/* Função responsável por adicionar um novo item à lista */
function addItem() {
    // Cria um novo elemento 'li' (item da lista)
    let novoItem = document.createElement('li')

    // Define o conteúdo do novo item como "Item" seguido do número de itens na lista + 1
    novoItem.innerHTML = `Item ${list.children.length + 1}`
    
    // Adiciona o novo item ao final da lista de itens (dentro do elemento 'ul')
    list.appendChild(novoItem)

    // Atualiza o texto do título para indicar que um novo item foi adicionado
    title.innerHTML = 'Novo item adicionado!'

    // Altera a cor do título para verde, indicando uma ação bem-sucedida
    title.style.color = 'green'
}

/* Função responsável por remover o último item da lista */
function removeItem(){
    // Verifica se a lista tem pelo menos um item
    if(list.children.length > 0){
        // Remove o último item da lista (usando 'lastElementChild' para pegar o último filho)
        list.removeChild(list.lastElementChild)

        // Atualiza o texto do título para indicar que um item foi removido
        title.innerHTML = 'Item removido'

        // Altera a cor do título para vermelho, indicando a remoção de um item
        title.style.color = "red";
    } else {
        // Se não houver mais itens para remover, exibe uma mensagem no título
        title.innerHTML = 'Não há mais itens para remover'

        // Altera a cor do título para cinza, indicando uma situação neutra
        title.style.color = 'gray'
    }
}

// Adiciona um evento 'click' ao botão 'adicionarItem' que chama a função 'adicionarItem' quando clicado
botaoAdicionarItem.addEventListener('click', addItem)

// Adiciona um evento 'click' ao botão 'removerItem' que chama a função 'removerItem' quando clicado
botaoRemoverItem.addEventListener('click', removeItem)