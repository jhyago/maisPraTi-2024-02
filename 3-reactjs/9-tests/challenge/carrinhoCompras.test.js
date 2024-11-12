// Importa a classe CarrinhoCompras para ser testada
const CarrinhoCompras = require('./CarrinhoCompras')

// Agrupa os testes para a classe CarrinhoCompras
describe('CarrinhoDeCompras', () => {
    let carrinho // Variável que armazenará a instância do carrinho

    // Executa antes de cada teste, garantindo que o carrinho esteja limpo para cada caso
    beforeEach(() => {
        carrinho = new CarrinhoCompras()
    })

    // Teste para verificar se produtos são adicionados corretamente ao carrinho
    test('Adicionar produtos corretamente', () => {
        // Adiciona dois produtos ao carrinho
        carrinho.adicionarProduto('Maça', 2.5, 3)
        carrinho.adicionarProduto('Banana', 1.2, 5)

        // Obtém a lista de produtos e verifica se contém os itens corretos
        const produtos = carrinho.listarProdutos()
        expect(produtos).toEqual([
            { nome: 'Maça', preco: 2.5, quantidade: 3 },
            { nome: 'Banana', preco: 1.2, quantidade: 5 }
        ])
    })

    // Teste para verificar se a quantidade de um produto existente é incrementada corretamente
    test('Incrementar a quantidade de um produto pré existente', () => {
        // Adiciona o mesmo produto duas vezes
        carrinho.adicionarProduto('Maça', 2.5, 3)
        carrinho.adicionarProduto('Maça', 2.5, 2)

        // Verifica se a quantidade foi somada
        const produtos = carrinho.listarProdutos()
        expect(produtos).toEqual([
            { nome: 'Maça', preco: 2.5, quantidade: 5 }
        ])
    })

    // Teste para verificar se um produto é removido corretamente
    test('Remover um produto', () => {
        // Adiciona um produto e depois o remove
        carrinho.adicionarProduto('Melão', 5, 1)
        carrinho.removerProduto('Melão')

        // Verifica se o carrinho está vazio
        const produtos = carrinho.listarProdutos()
        expect(produtos).toEqual([])
    })

    // Teste para verificar se um erro é lançado ao tentar remover um produto que não existe
    test('Lança erro ao tentar remover um produto que não existe', () => {
        // Verifica se a remoção de um produto inexistente lança o erro esperado
        expect(() => carrinho.removerProduto('Banana')).toThrowError('Produto "Banana" não encontrado no carrinho.')
    })

    // Teste para verificar o cálculo do total do carrinho
    test('Calcula o total', () => {
        // Adiciona dois produtos
        carrinho.adicionarProduto('Maça', 2.5, 3)
        carrinho.adicionarProduto('Banana', 1.2, 5)

        // Calcula o total e verifica se está correto
        const total = carrinho.calcularTotal()
        expect(total).toBeCloseTo(13.5) // Utiliza toBeCloseTo para lidar com possíveis imprecisões em cálculos
    })
    
    // Teste para verificar se a lista de produtos é retornada corretamente
    test('Retornar a lista de produtos', () => {
        // Adiciona dois produtos ao carrinho
        carrinho.adicionarProduto('Maça', 2.5, 3)
        carrinho.adicionarProduto('Banana', 1.2, 5)
        
        // Obtém e verifica a lista de produtos
        const produtos = carrinho.listarProdutos()
        expect(produtos).toEqual([
            { nome: 'Maça', preco: 2.5, quantidade: 3 },
            { nome: 'Banana', preco: 1.2, quantidade: 5 }
        ])
    })
})