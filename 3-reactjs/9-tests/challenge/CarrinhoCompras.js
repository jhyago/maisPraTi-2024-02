// Define a classe CarrinhoCompras
class CarrinhoCompras {

    // Construtor da classe, inicializa uma lista vazia para armazenar os produtos do carrinho
    constructor() {
        this.produtos = [] // Armazena os produtos adicionados ao carrinho
    }

    // Método para adicionar um produto ao carrinho
    adicionarProduto(nome, preco, quantidade) {
        // Procura um produto no carrinho que tenha o mesmo nome
        const produtoExistente = this.produtos.find(produto => produto.nome === nome)

        // Se o produto já existir no carrinho, incrementa a quantidade
        if(produtoExistente){
            produtoExistente.quantidade += quantidade
        } else {
            // Se o produto não existir, adiciona um novo item à lista de produtos
            this.produtos.push({ nome, preco, quantidade })
        }
    }

    // Método para remover um produto do carrinho pelo nome
    removerProduto(nome) {
        // Encontra o índice do produto na lista pelo nome
        const index = this.produtos.findIndex(produto => produto.nome === nome)

        // Se o produto não for encontrado, lança um erro
        if(index === -1){
            throw new Error(`Produto "${nome}" não encontrado no carrinho.`)
        }

        // Remove o produto da lista usando o índice encontrado
        this.produtos.splice(index, 1)
    }

    // Método para calcular o total do carrinho
    calcularTotal() {
        // Usa o método reduce para somar o preço total de todos os produtos
        return this.produtos.reduce((total, produto) => {
            // Multiplica o preço pela quantidade e adiciona ao total acumulado
            return total + produto.preco * produto.quantidade
        }, 0) // Começa o acumulador do total em 0
    }

    // Método para listar os produtos no carrinho
    listarProdutos() {
        // Mapeia a lista de produtos para retornar um novo array com os dados relevantes
        return this.produtos.map(produto => ({
            nome: produto.nome, // Nome do produto
            preco: produto.preco, // Preço unitário do produto
            quantidade: produto.quantidade // Quantidade do produto no carrinho
        }))
    }
}

// Exporta a classe para que possa ser usada em outros arquivos
module.exports = CarrinhoCompras