import { useState, useEffect } from 'react'
import { getUsers } from '../api/UserService'
// Importa os hooks `useState` e `useEffect` do React para gerenciar estado e efeitos colaterais.
// Importa a função `getUsers` do serviço `UserService`, que é responsável por buscar os dados dos usuários.

const UseUsers = () => {
    // Define um hook customizado chamado `UseUsers`.
    // Este hook encapsula a lógica para buscar e gerenciar o estado da lista de usuários.

    const [users, setUsers] = useState([])
    // Declara o estado `users` inicializado como um array vazio.
    // `setUsers` é a função usada para atualizar o estado dos usuários.

    const [loading, setLoading] = useState(true)
    // Declara o estado `loading` inicializado como `true`.
    // `setLoading` é a função usada para atualizar o estado de carregamento.

    useEffect(() => {
        // Usa o hook `useEffect` para executar a lógica de busca de dados após o componente ser montado.

        const fetchData = async () => {
            // Define a função assíncrona `fetchData`, que encapsula a lógica para buscar dados.

            try {
                const response = await getUsers()
                // Chama a função `getUsers` para fazer uma requisição à API e obter a lista de usuários.

                setUsers(response.data)
                // Atualiza o estado `users` com os dados obtidos da API (`response.data`).

            } catch (error) {
                console.error('Erro ao carregar os usuários: ', error)
                // Caso ocorra um erro na requisição, exibe a mensagem de erro no console.
            } finally {
                setLoading(false)
                // No final (independente de sucesso ou erro), atualiza o estado `loading` para `false` para indicar que a operação foi concluída.
            }
        }

        fetchData()
        // Invoca a função `fetchData` para buscar os dados dos usuários assim que o componente for montado.

    }, [])
    // O array vazio `[]` como dependência garante que o `useEffect` execute apenas uma vez, após a montagem do componente.

    return { users, loading }
    // Retorna um objeto contendo os estados `users` e `loading` para serem usados no componente que consome este hook.
}

export default UseUsers
// Exporta o hook customizado `UseUsers` para que possa ser reutilizado em outros componentes.