// Cria uma nova promessa que simula o pedido de uma pizza
const pedidoPizza = new Promise((resolve, reject) => {
    let pizzaPronta = false // Simula o estado da pizza (se está pronta ou não)

    // Verifica se a pizza está pronta
    if(pizzaPronta) {
        // Se a pizza estiver pronta, resolve a promessa com uma mensagem de sucesso
        resolve("Pizza foi entregue!")
    } else {
        // Caso contrário, rejeita a promessa com uma mensagem de erro
        reject("O pedido da pizza falhou")
    }
})

// Usamos o método 'then' para lidar com o sucesso da promessa
pedidoPizza.then((mensagem) => {
    console.log(mensagem) // Exibe a mensagem de sucesso no console
})
// Usamos o método 'catch' para tratar erros ou falhas na promessa
.catch((erro) => {
    console.log(erro) // Exibe a mensagem de erro no console
})


// Função que simula a busca de dados, retorna uma promessa
function buscarDados() {
    return new Promise((resolve, reject) => {
        // Simula um atraso de 2 segundos com setTimeout
        setTimeout(() => {
            const dados = {nome: 'João', idade: 50} // Dados que serão retornados
            resolve(dados) // Resolve a promessa com os dados simulados
        }, 2000)
    })
}

// Chama a função 'buscarDados' e espera que a promessa seja resolvida
buscarDados().then((dados) => {
    // Quando a promessa é resolvida, exibe os dados no console
    console.log("Dados recebidos: ", dados)
})
// Caso haja algum erro, trata a falha no 'catch'
.catch((erro) => {
    console.log("Erro ao buscar os dados: ", erro)
})


// Função que simula o processo de login, retorna uma promessa
function login(usuario){
    return new Promise((resolve, reject) => {
        // Se o usuário for "Emerson", o login é bem-sucedido
        if(usuario === 'Emerson'){
            resolve("Login bem-sucedido!")
        } else {
            // Caso contrário, falha na autenticação
            reject("Falha na autenticação.")
        }
    })
}

// Função que simula a busca de um perfil, retorna uma promessa
function buscarPerfil(){
    return new Promise((resolve) => {
        // Simula um atraso de 2 segundos para buscar o perfil
        setTimeout(() => {
            // Retorna um objeto com os dados do perfil
            resolve({nome: "Emerson", profissão: "Desenvolvedor"})
        }, 2000)
    })
}

// Chama a função de login e verifica se o login é bem-sucedido
login("Emerson").then((mensagem) => {
    // Se o login for bem-sucedido, exibe a mensagem no console
    console.log(mensagem)
    // Depois, chama a função 'buscarPerfil' para buscar os dados do perfil
    return buscarPerfil()
})
// Quando a promessa de buscar o perfil é resolvida, exibe os dados do perfil
.then((perfil) => {
    console.log(perfil)
})
// Caso ocorra algum erro no login ou ao buscar o perfil, trata o erro
.catch((erro) => {
    console.log(erro)
})