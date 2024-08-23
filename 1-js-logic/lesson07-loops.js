// Imprimindo a tabuada do 5
console.log(5 * 1);
console.log(5 * 2);
console.log(5 * 3);
console.log(5 * 4);
console.log(5 * 5);
console.log(5 * 6);
console.log(5 * 7);
console.log(5 * 8);
console.log(5 * 9);
console.log(5 * 10);

const prompt = require('prompt-sync')();

// Exemplo 1: Tabuada de um número fornecido pelo usuário
let multiplicador = 7; // Número cuja tabuada será impressa

// <Inicialização>; <Condição>; <Incremento>
for(let contador = 0; contador <= 10; contador++){
    console.log(`${multiplicador} * ${contador} =`, multiplicador * contador);
}

// Exemplo 2: Imprimir valores pares entre 1 e 20
for(let numAtual = 0; numAtual <= 20; numAtual += 2){
    console.log(numAtual); // Imprime números pares
}

// Exemplo 3: Calcular a soma dos números de 1 a 100
let soma = 0;
for(let j = 1; j <= 100; j++){
    soma += j; // Acumula a soma de 1 a 100
}
console.log(soma); // Imprime a soma total

// Exemplo 4: Imprimir valores de 1 até 10 em ordem decrescente
for(let decrescente = 10; decrescente >= 1; decrescente--){
    console.log(decrescente); // Imprime números de 10 a 1
}

// Exemplo 5: Contagem regressiva usando while
let contadorWhile = 10;

while(contadorWhile > 0){
    console.log(contadorWhile); // Imprime o contador
    contadorWhile--; // Decrementa o contador
}

// Exemplo 6: Calcular a soma dos números de 1 a 100 usando while
let variavelSoma = 0;
let contadorSoma = 0;

while(contadorSoma <= 100){
    variavelSoma += contadorSoma; // Acumula a soma
    contadorSoma++; // Incrementa o contador
}

console.log(variavelSoma); // Imprime a soma total

// Exemplo 7: Média aritmética de números inseridos até que o usuário digite 0
let numEntrada = Number(prompt('Insira o primeiro número: '));
let totalNumeros = 0;
let somaTotal = 0;

while(numEntrada !== 0){
    somaTotal += numEntrada; // Acumula a soma
    totalNumeros++; // Conta a quantidade de números
    numEntrada = Number(prompt('Digite outro número: ')); // Solicita o próximo número
}

if(totalNumeros > 0){
    console.log('A média aritmética é: ', somaTotal / totalNumeros); // Calcula e imprime a média
} else {
    console.log('Nenhum número foi inserido.');
}

// Exemplo 8: Imprimir os 50 primeiros números primos maiores que 100
let qtdPrimos = 0;
let numeroAtual = 101; // Começa a verificar números a partir de 101

while(qtdPrimos < 50){
    let ehPrimo = true;

    for(let divisor = 2; divisor <= Math.sqrt(numeroAtual); divisor++){
        if(numeroAtual % divisor === 0){
            ehPrimo = false; // Se for divisível por outro número, não é primo
            break;
        }
    }

    if(ehPrimo){
        console.log(numeroAtual); // Imprime o número primo
        qtdPrimos++; // Conta o primo encontrado
    }

    numeroAtual++; // Verifica o próximo número
}

// Exemplo 9: Solicitar números ao usuário até que ele insira um valor negativo
let valor;

do {
    valor = Number(prompt('Digite um número: ')); // Solicita um número ao usuário
} while(valor >= 0); // Continua pedindo até o usuário inserir um número negativo

console.log('Você inseriu um número negativo e o loop foi encerrado.');