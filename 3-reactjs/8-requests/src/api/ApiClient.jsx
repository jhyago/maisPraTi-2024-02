import axios from 'axios'
// Importa a biblioteca `axios`, que é usada para realizar requisições HTTP no projeto.

const ApiClient = axios.create({
    baseURL: 'https://jsonplaceholder.typicode.com',
    // Configura a URL base para todas as requisições feitas com esta instância do `axios`.
    // Isso elimina a necessidade de repetir a mesma URL base em cada chamada.

    timeout: 10000
    // Define um tempo limite (timeout) de 10.000 milissegundos (10 segundos) para as requisições.
    // Se uma requisição ultrapassar esse tempo, ela será automaticamente cancelada.
})

export default ApiClient
// Exporta a instância configurada do `axios` para que possa ser usada em todo o projeto.
// Isso ajuda a manter o código mais limpo e consistente, permitindo que todas as requisições compartilhem essa configuração básica.