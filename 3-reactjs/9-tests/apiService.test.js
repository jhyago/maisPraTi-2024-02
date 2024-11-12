const axios = require('axios')
const apiService = require('./apiService')

jest.mock('axios')

describe('Testando chamada para API externa', () => {
    it('Deve retornar dados simulados da API', async() => {
        const mockedResponse = { data: { id: 1, name: 'teste'}}

        axios.get.mockResolvedValue(mockedResponse)

        const response = await apiService.getData()

        expect(response).toEqual(mockedResponse.data)
    })
})