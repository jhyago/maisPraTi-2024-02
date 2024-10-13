// ---------------------------------------------
// 1. Operador Spread em Arrays
// ---------------------------------------------
let numeros = [1, 2, 3]

// Usando o operador spread para criar um novo array, adicionando 4 e 5
let novosNumeros = [...numeros, 4, 5]
console.log(novosNumeros) // Saída: [1, 2, 3, 4, 5]

// ---------------------------------------------
// 2. Operador Spread em Objetos
// ---------------------------------------------
let pessoa = { nome: "Neymar", idade: 30 }

// Usando o spread para adicionar uma nova propriedade 'cidade' ao objeto
let novaPessoa = { ...pessoa, cidade: "Santos" }
console.log(novaPessoa) // Saída: {nome: "Neymar", idade: 30, cidade: "Santos"}

// ---------------------------------------------
// 3. Usando Spread em Funções
// ---------------------------------------------
function soma(a, b, c) {
    return a + b + c
}

let numerosArray = [1, 2, 3]

// Usando o spread para passar elementos do array como argumentos individuais
console.log(soma(...numerosArray)) // Saída: 6

// ---------------------------------------------
// 4. Usando o Operador Rest em Funções
// ---------------------------------------------
function somaTudo(...numeros) {
    // Usando reduce para somar todos os números recebidos
    return numeros.reduce((total, numero) => total + numero)
}

// Chamando a função com múltiplos argumentos
console.log(somaTudo(1, 2, 3, 4, 5)) // Saída: 15

// ---------------------------------------------
// 5. Desestruturação de Arrays com Rest
// ---------------------------------------------
const [primeiro, segundo, ...resto] = [1, 2, 3, 4, 5]

console.log(primeiro) // Saída: 1
console.log(segundo)  // Saída: 2
console.log(resto)    // Saída: [3, 4, 5]

// ---------------------------------------------
// 6. Desestruturação de Objetos com Rest
// ---------------------------------------------
const jogador = { nome: "Kanemann", idade: 30, time: "Maior do sul" }

const { nome: nomeJogador, ...outrasInfo } = jogador

console.log(nomeJogador) // Saída: Kanemann
console.log(outrasInfo)  // Saída: { idade: 30, time: "Maior do sul" }

// ---------------------------------------------
// 7. Função que Calcula Média usando Operador Rest
// ---------------------------------------------
function calculaMedia(...notas) {
    const total = notas.reduce((soma, nota) => soma + nota, 0)
    return total / notas.length
}

// Chama a função com várias notas
console.log(calculaMedia(8, 7, 9, 6, 10)) // Saída: 8

// ---------------------------------------------
// 8. Exemplo de E-commerce com Spread (Mesclando Objetos)
// ---------------------------------------------
const clienteAntigo = {
    nome: "Carlos",
    idade: 32,
    email: "carlos@example.com"
}

const clienteAtualizado = {
    email: "carlos.dev@example.com",
    cidade: "São Paulo"
}

// Usando o operador spread para combinar os dados antigos com os novos
const clienteFinal = { ...clienteAntigo, ...clienteAtualizado }

console.log(clienteFinal)
// Saída: { nome: "Carlos", idade: 32, email: "carlos.dev@example.com", cidade: "São Paulo" }

// ---------------------------------------------
// 9. Adicionar Produtos ao Carrinho com Spread
// ---------------------------------------------
let carrinho = ["Produto 1", "Produto 2", "Produto 3"]

// Usando o spread para criar uma nova lista de produtos, sem alterar o array original
let novoCarrinho = [...carrinho, "Produto 4", "Produto 5"]

console.log(novoCarrinho) 
// Saída: ["Produto 1", "Produto 2", "Produto 3", "Produto 4", "Produto 5"]