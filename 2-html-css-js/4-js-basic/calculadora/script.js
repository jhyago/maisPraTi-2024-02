function inserir(valor){
    let tela = document.formulario.tela
    
    if(tela.value.length < 14){
        if(isOperador(valor) && isOperador(tela.value[tela.value.length - 1])){
            return
        }
    }

    tela.value += valor
}

function limparTela(){
    document.formulario.tela.value = ""
}

function deletar(){
    let tela = document.formulario.tela
    tela.value = tela.value.slice(0, -1)
}

function calcularTotal(){
    let tela = document.formulario.tela
    const expressao = tela.value;

    if(expressao && !isOperador(expressao[expressao.length - 1])){
        try {
            let resultado = calcularExpressao(expressao) 
            tela.value = resultado
        } catch (error){
            alert("Expressão inválida")
            limparTela()
        }
    }
}

function isOperador (char){
    return ['+', '-', '/', '*'].includes(char)
}

function calcularExpressao(expressao){
    return eval(expressao)
}