function inserir(valor){ 
    // Função que insere o valor pressionado (número ou operador) na tela da calculadora

    let tela = document.formulario.tela
    // Obtém o elemento da tela da calculadora para manipulação de seu valor

    if(tela.value.length < 14){
        // Limita a quantidade de caracteres inseridos na tela para 14

        if(isOperador(valor) && isOperador(tela.value[tela.value.length - 1])){
            // Verifica se o valor inserido é um operador e se o último caractere na tela também é um operador
            // Se ambos forem operadores, impede a inserção, evitando operadores consecutivos
            return
        }
    }

    tela.value += valor
    // Se o valor passado for válido, ele é adicionado ao final do valor atual da tela
}

function limparTela(){
    // Função que limpa completamente a tela da calculadora
    document.formulario.tela.value = ""
    // Define o valor da tela como uma string vazia
}

function deletar(){
    // Função que apaga o último caractere da tela da calculadora
    let tela = document.formulario.tela
    // Obtém a referência à tela da calculadora

    tela.value = tela.value.slice(0, -1)
    // Remove o último caractere da string atual da tela utilizando o método slice
}

function calcularTotal(){
    // Função que avalia a expressão matemática e exibe o resultado na tela
    let tela = document.formulario.tela
    // Obtém a referência à tela da calculadora

    const expressao = tela.value;
    // Salva a expressão atual da tela em uma constante

    if(expressao && !isOperador(expressao[expressao.length - 1])){
        // Verifica se a expressão não está vazia e se o último caractere não é um operador
        // Isso evita avaliar uma expressão que termine com um operador, o que geraria erro

        try {
            let resultado = calcularExpressao(expressao) 
            // Tenta calcular o resultado da expressão chamando a função calcularExpressao

            tela.value = resultado
            // Exibe o resultado da avaliação na tela
        } catch (error){
            // Caso ocorra um erro ao calcular a expressão, entra no bloco catch

            alert("Expressão inválida")
            // Exibe uma mensagem de erro ao usuário informando que a expressão é inválida

            limparTela()
            // Limpa a tela da calculadora para evitar que a expressão inválida permaneça
        }
    }
}

function isOperador (char){
    // Função que verifica se um caractere é um operador matemático (+, -, *, /)
    return ['+', '-', '/', '*'].includes(char)
    // Retorna verdadeiro se o caractere for um dos operadores, e falso caso contrário
}

function calcularExpressao(expressao){
    // Função que avalia a expressão matemática e retorna o resultado
    return eval(expressao)
    // O método eval executa a expressão passada como uma string e retorna o valor calculado
}