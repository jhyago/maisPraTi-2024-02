import { useState, useEffect } from 'react'
import axios from 'axios'
// Importa os hooks `useState` e `useEffect` do React para gerenciar estado e efeitos colaterais.
// Importa a biblioteca `axios` para realizar requisições HTTP.

const User = () => {
    // Define o componente funcional `User`.

    const [users, setUsers] = useState([])
    // Declara um estado `users` inicializado como um array vazio.
    // `setUsers` será usado para atualizar o estado quando os dados dos usuários forem obtidos.

    const [error, setError] = useState('')
    // Declara um estado `error` inicializado como uma string vazia.
    // `setError` será usado para armazenar mensagens de erro em caso de falhas nas requisições.

    useEffect(() => {
        // O hook `useEffect` é usado para executar efeitos colaterais, como buscar dados, após o componente ser montado.

        axios.get('https://jsonplaceholder.typicode.com/users')
        // Faz uma requisição GET para a API fictícia `jsonplaceholder` para obter dados dos usuários.

        .then(response => setUsers(response.data))
        // Se a requisição for bem-sucedida, atualiza o estado `users` com os dados recebidos (response.data).

        .catch(error => setError(error.message))
        // Em caso de erro, atualiza o estado `error` com a mensagem de erro recebida.

    }, [])
    // O array vazio `[]` como dependência indica que o efeito será executado apenas uma vez, após a montagem do componente.

    const addUser = async () => {
        // Define a função assíncrona `addUser` para adicionar um novo usuário.

        try {
            const response = await axios.post('https://jsonplaceholder.typicode.com/users', {
                name: 'Patolino',
                email: 'patolino@disney.com'
            })
            // Faz uma requisição POST para a API, enviando um objeto com nome e e-mail do novo usuário.

            console.log('Usuário adicionado ', response.data)
            // Exibe no console os dados do usuário adicionados pela API.

        } catch (error) {
            console.error('Erro ao adicionar usuário: ', error.message)
            // Exibe uma mensagem de erro no console caso a requisição POST falhe.
        }
    }

    const deleteUser = async (userId) => {
        // Define a função assíncrona `deleteUser` para deletar um usuário pelo ID.

        try {
            await axios.delete(`https://jsonplaceholder.typicode.com/users/users/${userId}`)
            // Faz uma requisição DELETE para a API usando o `userId` fornecido para especificar o usuário a ser removido.
            // Nota: A URL contém um erro ("users/users") que deve ser corrigido para "users".

            console.log('Usuário deletado')
            // Exibe no console uma mensagem indicando que o usuário foi deletado com sucesso.

        } catch (error) { 
            console.error('Erro ao deletar o usuário', error.message)
            // Exibe uma mensagem de erro no console caso a requisição DELETE falhe.
        }
    }

    return (
        <div>
            <ul>
                {/* Renderiza uma lista de usuários */}
                {users.map((user) => (
                    // Itera sobre o estado `users`, criando um elemento `li` para cada usuário.
                    <li key={user.id}>{user.name}</li>
                    // Cada `li` exibe o nome do usuário e usa o `id` como chave única.
                ))}
            </ul>
        </div>
    )
}

export default User
// Exporta o componente `User` como padrão para que possa ser importado e utilizado em outros arquivos.