// Importa a biblioteca axios, usada para realizar requisições HTTP
const axios = require('axios')
// Importa o serviço da API que será testado
const apiService = require('./apiService')

// Faz o mock (simulação) da biblioteca axios para evitar chamadas reais à API
jest.mock('axios')

// Define o conjunto de testes para o serviço da API
describe('Testando chamada para API externa', () => {
    // Testa o comportamento da função getData com dados simulados
    it('Deve retornar dados simulados da API', async () => {
        // Define a resposta simulada que será retornada pelo mock do axios
        const mockedResponse = { data: { id: 1, name: 'teste' } }

        // Configura o mock do axios para retornar a resposta simulada quando chamado
        axios.get.mockResolvedValue(mockedResponse)

        // Chama a função getData do serviço da API
        const response = await apiService.getData()

        // Verifica se a resposta obtida é igual à resposta simulada
        expect(response).toEqual(mockedResponse.data)
    })
})