// =====================================================
// 1. Verifica se um número é par ou ímpar utilizando if
// =====================================================
function verificarParOuImpar(num) {
    if (num % 2 === 0) {
        console.log(`${num} é par`);
    } else {
        console.log(`${num} é ímpar`);
    }
}
verificarParOuImpar(5);  // Exemplo

// =====================================================
// 2. Classifica a idade de uma pessoa em categorias
// =====================================================
function classificarIdade(idade) {
    if (idade >= 0 && idade <= 12) {
        console.log("Criança");
    } else if (idade >= 13 && idade <= 17) {
        console.log("Adolescente");
    } else if (idade >= 18 && idade <= 64) {
        console.log("Adulto");
    } else if (idade >= 65) {
        console.log("Idoso");
    } else {
        console.log("Idade inválida");
    }
}
classificarIdade(25);  // Exemplo

// =====================================================
// 3. Classifica uma nota entre "Aprovado", "Recuperação", ou "Reprovado"
// =====================================================
function classificarNota(nota) {
    if (nota >= 7) {
        console.log("Aprovado");
    } else if (nota >= 5) {
        console.log("Recuperação");
    } else {
        console.log("Reprovado");
    }
}
classificarNota(6);  // Exemplo

// =====================================================
// 4. Menu interativo utilizando switch-case
// =====================================================
function menuInterativo(opcao) {
    switch (opcao) {
        case 1:
            console.log("Opção 1 selecionada.");
            break;
        case 2:
            console.log("Opção 2 selecionada.");
            break;
        case 3:
            console.log("Opção 3 selecionada.");
            break;
        default:
            console.log("Opção inválida.");
    }
}
menuInterativo(2);  // Exemplo

// =====================================================
// 5. Calcula o Índice de Massa Corporal (IMC)
// =====================================================
function calcularIMC(peso, altura) {
    let imc = peso / (altura * altura);
    if (imc < 18.5) {
        console.log("Baixo peso");
    } else if (imc >= 18.5 && imc <= 24.9) {
        console.log("Peso normal");
    } else if (imc >= 25 && imc <= 29.9) {
        console.log("Sobrepeso");
    } else {
        console.log("Obesidade");
    }
}
calcularIMC(70, 1.75);  // Exemplo

// =====================================================
// 6. Verificar se os lados fornecidos formam um triângulo e determinar o tipo
// =====================================================
function verificarTriangulo(A, B, C) {
    if (A < B + C && B < A + C && C < A + B) {
        if (A === B && B === C) {
            console.log("Triângulo Equilátero");
        } else if (A === B || A === C || B === C) {
            console.log("Triângulo Isósceles");
        } else {
            console.log("Triângulo Escaleno");
        }
    } else {
        console.log("Os lados fornecidos não formam um triângulo");
    }
}
verificarTriangulo(3, 3, 3);  // Exemplo

// =====================================================
// 7. Calcular o valor da compra de maçãs
// =====================================================
function calcularValorMacas(quantidade) {
    let preco = quantidade < 12 ? 0.30 : 0.25;
    let total = preco * quantidade;
    console.log(`Valor total: R$ ${total.toFixed(2)}`);
}
calcularValorMacas(15);  // Exemplo

// =====================================================
// 8. Ler dois valores e escrevê-los em ordem crescente
// =====================================================
function ordenarValores(a, b) {
    if (a < b) {
        console.log(a, b);
    } else {
        console.log(b, a);
    }
}
ordenarValores(5, 2);  // Exemplo

// =====================================================
// 9. Exibir uma contagem regressiva de 10 até 1
// =====================================================
function contagemRegressiva() {
    for (let i = 10; i >= 1; i--) {
        console.log(i);
    }
}
contagemRegressiva();  // Exemplo

// =====================================================
// 10. Ler um número e escrevê-lo na tela 10 vezes
// =====================================================
function escreverNumero(n) {
    for (let i = 1; i <= 10; i++) {
        console.log(n);
    }
}
escreverNumero(7);  // Exemplo

// =====================================================
// 11. Solicitar 5 números e calcular a soma total
// =====================================================
function somarCincoNumeros() {
    let soma = 0;
    for (let i = 1; i <= 5; i++) {
        let numero = parseFloat(prompt(`Digite o ${i}º número:`));
        soma += numero;
    }
    console.log(`Soma total: ${soma}`);
}
//somarCincoNumeros();  // Exemplo (requer input do usuário)

// =====================================================
// 12. Exibe a tabuada de um número fornecido pelo usuário
// =====================================================
function exibirTabuada(numero) {
    for (let i = 1; i <= 10; i++) {
        console.log(`${i} x ${numero} = ${i * numero}`);
    }
}
exibirTabuada(5);  // Exemplo

// =====================================================
// 13. Receber números decimais até que o usuário digite 0 e calcular a média
// =====================================================
function calcularMedia() {
    let soma = 0;
    let count = 0;
    let numero;
    do {
        numero = parseFloat(prompt("Digite um número (0 para sair):"));
        if (numero !== 0) {
            soma += numero;
            count++;
        }
    } while (numero !== 0);

    if (count > 0) {
        let media = soma / count;
        console.log(`Média aritmética: ${media}`);
    } else {
        console.log("Nenhum número foi inserido.");
    }
}
//calcularMedia();  // Exemplo (requer input do usuário)

// =====================================================
// 14. Calcular o fatorial de um número
// =====================================================
function calcularFatorial(numero) {
    let fatorial = 1;
    for (let i = 1; i <= numero; i++) {
        fatorial *= i;
    }
    console.log(`Fatorial de ${numero} é ${fatorial}`);
}
calcularFatorial(5);  // Exemplo

// =====================================================
// 15. Imprime os primeiros 10 números da sequência de Fibonacci
// =====================================================
function fibonacci() {
    let a = 0, b = 1, temp;
    console.log(a);
    console.log(b);
    for (let i = 3; i <= 10; i++) {
        temp = a + b;
        console.log(temp);
        a = b;
        b = temp;
    }
}
fibonacci();  // Exemplo