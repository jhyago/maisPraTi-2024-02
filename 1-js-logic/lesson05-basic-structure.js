// Imprime diferentes formas de escrever "Hello World!" no console.
console.log("'Hello World!'");  // Com aspas simples dentro de aspas duplas
console.log('"Hello World!"');  // Com aspas duplas dentro de aspas simples
console.log(`Hello World!`);    // Com crase, que permite interpolação de variáveis

// Imprime um número decimal e o tipo de dois valores diferentes.
console.log(1.5);               // Imprime o número decimal 1.5
console.log(typeof(10));        // Verifica e imprime o tipo de dado de 10 (número)
console.log(typeof('10'));      // Verifica e imprime o tipo de dado de '10' (string)

// Imprime uma combinação de tipos de dados diferentes.
console.log(typeof('10'), 1000, "Jaques");  // Imprime o tipo de '10', um número, e uma string

// Declaração de variáveis usando diferentes palavras-chave.
let name = 'Jaques';            // Declara uma variável com escopo de bloco
var anotherName = 'Jaques';     // Declara uma variável com escopo global ou de função

// Declara uma constante, cujo valor não pode ser alterado.
const CITY = "Porto Alegre";    // Constante com valor "Porto Alegre"

// Declara uma variável sem inicializar e depois atribui um valor.
let test;                       // Declara uma variável sem valor inicial (undefined)
console.log(test);              // Imprime o valor undefined
test = "Teste";                 // Atribui um valor à variável
console.log(test);              // Imprime o valor "Teste"

// Trabalhando com valores nulos e booleanos.
let myNull = null;              // Variável inicializada com valor null
console.log(myNull);            // Imprime null
let myBoolean = true;           // Variável inicializada com valor booleano true
console.log(typeof(myBoolean)); // Verifica e imprime o tipo boolean

// Operações aritméticas básicas.
let num1 = 10;
let num2 = 5;

console.log(num1 + num2);       // Soma: 15
console.log(num1 - num2);       // Subtração: 5
console.log(num1 / num2);       // Divisão: 2
console.log(num1 * num2);       // Multiplicação: 50
console.log(num1 ** num2);      // Exponenciação: 10^5 = 100000
console.log(num1 % num2);       // Módulo (resto da divisão): 0

// Ordem de precedência dos operadores em JavaScript:
// () -> Parênteses têm a maior precedência
// ** -> Exponenciação vem em seguida
// * / % -> Multiplicação, divisão e módulo vêm em seguida
// + - -> Adição e subtração têm a menor precedência

// Convertendo string para número e somando com um número.
let numTest = "5";
console.log(parseInt(numTest) + 10);  // Converte "5" para número e soma 10, resultando em 15

// Trabalhando com incremento e decremento.
let counter = 1;
counter = counter + 1;  // Incrementa o valor em 1
counter = counter - 1;  // Decrementa o valor em 1
counter++;              // Incremento pós-fixado (aumenta após a execução)
counter--;              // Decremento pós-fixado (diminui após a execução)

console.log(counter);   // Imprime o valor atual do contador
console.log(counter++); // Imprime o valor atual e depois incrementa
console.log(counter);   // Imprime o valor após o incremento
console.log(++counter); // Incrementa primeiro e depois imprime o valor

// Trabalhando com incrementos e decrementos de passos maiores.
let step = 2;

counter = counter + step;  // Incrementa o valor de counter em 2
counter += step;           // Atalho para incrementar o valor de counter em 2

counter = counter - step;  // Decrementa o valor de counter em 2
counter -= step;           // Atalho para decrementar o valor de counter em 2

counter = counter * step;  // Multiplica o valor de counter por 2
counter *= step;           // Atalho para multiplicar o valor de counter por 2

counter = counter / step;  // Divide o valor de counter por 2
counter /= step;           // Atalho para dividir o valor de counter por 2