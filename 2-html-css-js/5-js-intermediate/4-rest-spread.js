// let numeros = [1, 2, 3]
// let novosNumeros = [...numeros, 4, 5]

// console.log(novosNumeros) //1, 2, 3, 4, 5

// let pessoa = {nome: "Neymar", idade: 30}
// let novaPessoa = {...pessoa, cidade: "Santos"}

// console.log(novaPessoa) //Nome: Neymar, idade: 30, cidade: Santos.

// function soma(a, b, c){
//     return a + b + c
// }

// let numeros = [1, 2, 3]
// console.log(soma(...numeros))

function soma(...numeros){
    return numeros.reduce((total, numero) => total + numero)
}

console.log(soma(1, 2, 3, 4, 5))


const [primeiro, segundo, ...resto] = [1, 2, 3, 4, 5]

console.log(primeiro)
console.log(segundo)
console.log(resto)


const pessoa = { nome: "Kanemann", idade: 30, time: "Maior do sul"}

const { nome, ...outrasInfo} = pessoa

console.log(nome)
console.log(outrasInfo)

// Crie uma função chamada calculaMedia que aceita uma quantidade indefinida de notas de estudantes e calcula a média dessas notas.

// Instruções:

//     Use o operador rest para capturar todas as notas passadas como argumentos.
//     Dentro da função, some todas as notas e divida pela quantidade de notas para calcular a média.

// Imagine que você está desenvolvendo um sistema de e-commerce e precisa mesclar os dados de um cliente com uma atualização recente. Os dados antigos estão em um objeto, e os dados novos chegam em outro. Utilize o operador spread para criar um novo objeto contendo as informações atualizadas.

// Instruções:

//     Use o operador spread para combinar os dois objetos, dando prioridade aos dados mais recentes.

// Suponha que você tem uma lista de produtos em um carrinho de compras e deseja adicionar novos produtos sem modificar o array original. Use o operador spread para criar uma nova lista de produtos.

// Instruções:

//     Use o operador spread para adicionar novos itens a um array já existente.