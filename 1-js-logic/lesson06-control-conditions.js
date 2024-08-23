// Comparações simples usando operadores relacionais.
console.log(10 > 5);  // true, 10 é maior que 5
console.log(10 < 5);  // false, 10 não é menor que 5
console.log(10 <= 5); // false, 10 não é menor ou igual a 5
console.log(10 >= 5); // true, 10 é maior ou igual a 5
console.log(10 == 5); // false, 10 não é igual a 5
console.log(10 == '10'); // true, compara apenas valores (não o tipo)
console.log(10 === '10'); // false, compara valor e tipo (10 é número, '10' é string)
console.log(10 != '10'); // false, valores são iguais (apenas tipos diferentes)
console.log(10 !== '10'); // true, valores iguais mas tipos diferentes (número e string)

// Operadores lógicos.
console.log((10 < 5) && (10 > 2)); // false, ambos os lados precisam ser verdadeiros para && (E)
console.log((10 > 5) || (10 < 2)); // true, apenas um lado precisa ser verdadeiro para || (OU)
console.log((10 > 5) || !(10 < 2)); // true, negação da condição (10 < 2) torna a expressão verdadeira
console.log(!(10 > 5) || (10 < 2)); // false, negação da condição verdadeira torna-a falsa

// Exemplo de autenticação simples usando operadores lógicos.
let usuario = "Jaques";
let senha = "1234";
let autenticacao = usuario === 'Jaques' && senha === '1234'; // Verdadeiro se ambos forem corretos

console.log(autenticacao); // true, pois usuario e senha estão corretos

// Estruturas condicionais (if-else).
const nota = 60;
if(nota >= 60){
    console.log('APROVADO!'); // Se nota for 60 ou mais, imprime APROVADO!
} else {
    console.log('REPROVADO!'); // Se nota for menos que 60, imprime REPROVADO!
}

// Verifica a faixa etária usando if-else.
let idade = 50;

if((idade >= 18) && (idade <= 32)){
    console.log('Pode se inscrever no concurso!'); // Imprime se a idade estiver entre 18 e 32
} else {
    console.log('Não pode se inscrever no concurso.'); // Fora dessa faixa etária, imprime esta mensagem
}

// Operador ternário para decisões simples.
let resultadoTernario = (18 >= idade && idade <= 32) ? 
    console.log('Pode se inscrever no concurso!') : 
    console.log('Não pode se inscrever no concurso.');

// Exercício 1: Verifica se um número é par ou ímpar.
let numeroParImpar = 17;

numeroParImpar % 2 === 0 ? console.log('PAR!') : console.log('ÍMPAR!'); // Verifica se o resto da divisão por 2 é 0

// Exercício 2: Encontra o maior de três números.
let numero1 = 2;
let numero2 = 3;
let numero3 = 1;

if((numero1 > numero2) && (numero1 > numero3)){
    console.log('O primeiro valor é o maior!'); // numero1 é o maior
} else if((numero2 > numero1) && (numero2 > numero3)) {
    console.log('O segundo valor é o maior!'); // numero2 é o maior
} else if((numero3 > numero1) && (numero3 > numero2)){
    console.log('O terceiro número é o maior'); // numero3 é o maior
} else {
    console.log('Os números são iguais ou há um empate entre dois ou mais números.');
}

// Exercício 3: Calculadora simples usando entrada do usuário.
const prompt = require('prompt-sync')(); // Necessário para receber entrada do usuário no Node.js

let valor1 = Number(prompt("Insira o primeiro valor: ")); // Recebe o primeiro número do usuário
let valor2 = Number(prompt("Insira o segundo valor: "));  // Recebe o segundo número do usuário
let operacao = prompt("Informe a operação desejada (+, -, /, *): "); // Recebe a operação desejada
let resultado = 0;

if(operacao === '+'){
    resultado = valor1 + valor2; // Soma
} else if(operacao === '-'){
    resultado = valor1 - valor2; // Subtração
} else if(operacao === '*'){
    resultado = valor1 * valor2; // Multiplicação
} else if(operacao === '/'){
    if(valor2 !== 0){
        resultado = valor1 / valor2; // Divisão, com verificação de divisão por zero
    } else {
        console.log("Erro: divisão por zero!"); // Mensagem de erro se valor2 for 0
        resultado = undefined;
    }
} else {
    console.log('Operação inválida!'); // Se a operação não for uma das especificadas
    resultado = undefined;
}

if(resultado !== undefined){
    console.log("Resultado: ", resultado); // Imprime o resultado se não for undefined
}

// Estrutura switch para múltiplas condições.
let opcao = 1;

switch(opcao) {
    case 1: 
        console.log('Você selecionou a primeira opção'); // Se opcao for 1
        break;
    case 2: 
        console.log('Você selecionou a segunda opção'); // Se opcao for 2
        break;
    default:
        console.log('Você não escolheu nenhuma das opções'); // Qualquer outro valor
        break;
}

// Exemplo adicional: Verifica se uma string é vazia ou não
let texto = "";

if(texto){
    console.log("A string não está vazia."); // Se a string não for vazia
} else {
    console.log("A string está vazia."); // Se a string estiver vazia
}

// Exemplo adicional: Usando switch para categorizar a idade
let idadePessoa = 25;

switch(true) {
    case (idadePessoa >= 0 && idadePessoa <= 12):
        console.log("Criança");
        break;
    case (idadePessoa >= 13 && idadePessoa <= 17):
        console.log("Adolescente");
        break;
    case (idadePessoa >= 18 && idadePessoa <= 59):
        console.log("Adulto");
        break;
    case (idadePessoa >= 60):
        console.log("Idoso");
        break;
    default:
        console.log("Idade inválida");
        break;
}