const pedidoPizza = new Promise((resolve, reject) => {
    let pizzaPronta = false

    if(pizzaPronta) {
        resolve("Pizza foi entregue!")
    } else {
        reject("O pedido da pizza falhou")
    }
})

pedidoPizza.then((mensagem) => {
    console.log(mensagem)
})
.catch((erro) => {
    console.log(erro)
})



function buscarDados() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            const dados = {nome: 'João', idade: 50}
            resolve(dados)
        }, 2000)
    })
}

buscarDados().then((dados) => {
    console.log("Dados recebidos: ", dados)
}).catch((erro) => {
    console.log("Erro ao buscar os dados: ", erro)
})

function login(usuario){
    return new Promise((resolve, reject) => {
        if(usuario === 'Emerson'){
            resolve("Login bem-sucedido!")
        } else {
            reject("Falha na autenticação.")
        }
    })
}

function buscarPerfil(){
    return new Promise((resolve) => {
        setTimeout(() => {
            resolve({nome: "Emerson", profissão: "Desenvolvedor"})
        }, 2000)
    })
}

login("Emerson").then((mensagem) => {
    console.log(mensagem)
    return buscarPerfil()
}).then((perfil) => {
    console.log(perfil)
}).catch((erro) => {
    console.log(erro)
})









