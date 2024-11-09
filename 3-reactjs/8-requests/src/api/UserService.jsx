import ApiClient from "./apiClient"
// Importa a instância `ApiClient` configurada no arquivo `apiClient`.
// `ApiClient` encapsula a URL base e outras configurações para todas as requisições HTTP.

export const getUsers = () => ApiClient.get('/users')
// Define a função `getUsers`, que realiza uma requisição GET para a rota `/users`.
// Retorna a lista de usuários ao chamar o endpoint correspondente na API.
// Utiliza a configuração da URL base definida no `ApiClient`.

export const addUser = (user) => ApiClient.post('/users', user)
// Define a função `addUser`, que realiza uma requisição POST para a rota `/users`.
// O parâmetro `user` é um objeto que contém os dados do novo usuário a ser enviado no corpo da requisição.
// Utiliza a configuração do `ApiClient` para simplificar a chamada.

export const deleteUser = (id) => ApiClient.delete(`/users/${id}`)
// Define a função `deleteUser`, que realiza uma requisição DELETE para a rota `/users/:id`.
// O parâmetro `id` é usado para especificar qual usuário será excluído.
// A URL completa é construída concatenando o `id` à rota base `/users`.
// Utiliza a configuração do `ApiClient` para gerenciar a requisição.