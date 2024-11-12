// Importa a biblioteca axios, usada para fazer requisições HTTP
const axios = require('axios')

// Cria um objeto chamado apiService, que encapsula o método para buscar dados
const apiService = {
    // Método assíncrono que realiza a requisição para buscar dados
    getData: async () => {
        try {
            // Faz uma requisição GET para o endpoint especificado
            const response = await axios.get('https://jsonplaceholder.typicode.com/users')

            // Retorna os dados da resposta (response.data contém o corpo da resposta)
            return response.data
        } catch (error) {
            // Lança um erro com uma mensagem personalizada caso a requisição falhe
            throw new Error(`Erro ao buscar os dados: ${error.message}`)
        }
    }
}

// Exporta o objeto apiService para que possa ser usado em outros arquivos
module.exports = apiService