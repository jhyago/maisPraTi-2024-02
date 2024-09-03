const prompt = require('prompt-sync')();

// Exercício 1: Verificar se um número é positivo, negativo ou zero
const numero = Number(prompt('Digite um número: '));

if (numero > 0) {
    console.log('O número informado é positivo!');
} else if (numero < 0) {
    console.log('O número informado é negativo!');
} else if (numero === 0) {
    console.log('O número é zero.');
} else {
    console.log('Erro! Informe um número válido.');
}

// Exercício 2: Verificar se um ano é bissexto
const ano = Number(prompt('Informe um ano:'));

if ((ano % 4 === 0 && ano % 100 !== 0) || (ano % 400 === 0)) {
    console.log(`O ano ${ano} é bissexto`);
} else {
    console.log(`${ano} não é um ano bissexto`);
}

// Exercício 3: Calcular a média de três notas e atribuir um conceito
let nota1 = Number(prompt('Informe a primeira nota: '));
let nota2 = Number(prompt('Informe a segunda nota: '));
let nota3 = Number(prompt('Informe a terceira nota: '));

let media = (nota1 + nota2 + nota3) / 3;
let conceito;

if (media >= 90) {
    console.log(`A média das notas é ${media.toFixed(2)}`);
    conceito = 'A';
} else if (media >= 80) {
    console.log(`A média das notas é ${media.toFixed(2)}`);
    conceito = 'B';
} else {
    console.log('É outra nota.');
}

console.log('O conceito do aluno é: ' + conceito);

// Exercício 9: Classificar idade em faixas etárias e usar switch para exibir uma mensagem
let idade = Number(prompt('Informe a sua idade: '));
let faixaEtaria;

if (idade >= 0 && idade <= 12) {
    faixaEtaria = 'Criança';
} else if (idade >= 13 && idade <= 17) {
    faixaEtaria = 'Adolescente';
} else if (idade >= 18 && idade <= 60) {
    faixaEtaria = 'Adulto';
} else {
    faixaEtaria = 'Idade inválida';
}

switch (faixaEtaria) {
    case 'Criança':
        console.log("Você é uma criança!");
        break;
    case 'Adolescente':
        console.log('Você é um(a) adolescente');
        break;
    case 'Adulto':
        console.log('Você é um(a) adulto(a)!');
        break;
    default:
        console.log('Idade inválida');
}

// Exercício 10: Calcular o maior divisor comum (MDC) entre dois números
let num1 = 98;
let num2 = 56;

let a = num1;
let b = num2;

do {
    let temp = b;
    b = a % b;
    a = temp;
} while (b !== 0);

const MDC = a;

console.log('O maior divisor comum de ' + num1 + ` e ${num2} é ${MDC}`);

// Exercício: Verificar se um número é primo
let numeroPrimo = Number(prompt('Qual número que deseja verificar? '));

for (let i = 1; i < numeroPrimo; i++) {
    if ((numeroPrimo % i === 0) && (i !== 1)) {
        console.log('Não é primo!');
        break;
    }

    if (i === (numeroPrimo - 1)) {
        console.log('É primo!');
    }
}

// Exemplo adicional: Imprimir os 50 primeiros números primos maiores que 100
let contadorPrimos = 0;
let numeroAtual = 100;

do {
    let totalDivisores = 0;
    for (let i = 1; i <= numeroAtual; i++) {
        if (numeroAtual % i === 0) {
            totalDivisores++;
        }
    }

    if (totalDivisores === 2) { // Número primo tem exatamente dois divisores
        console.log(numeroAtual);
        contadorPrimos++;
    }

    numeroAtual++;
} while (contadorPrimos < 50);

// Trabalhando com arrays
let carros = Array();

carros[0] = 'Civic';
carros[1] = 10;
carros[2] = true;
carros['Hyago'] = '10';

let motos = Array('CBR', 'Ninja', 10);
let livros = ['Senhor dos Anéis', 'O Hobbit', 'Harry Potter', 'Sherlock Holmes'];

// Manipulando o array de livros
livros.splice(2, 1, 'Animais Fantásticos'); // Substitui 'Harry Potter' por 'Animais Fantásticos'
console.log(livros);