import { useState, useEffect } from 'react' // Importa os hooks useState e useEffect do React para gerenciar estado e efeitos colaterais.

function UserList() { // Declara um componente funcional chamado UserList.
    const [users, setUsers] = useState([]) // Cria uma variável de estado chamada "users", inicializada como um array vazio, e "setUsers" para atualizá-la.

    useEffect(() => { // useEffect é utilizado para executar a função de busca dos dados uma única vez ao montar o componente.
        fetch('https://jsonplaceholder.typicode.com/users') // Faz uma requisição para a API de exemplo para obter uma lista de usuários.
            .then(response => response.json()) // Converte a resposta da API para o formato JSON.
            .then(data => setUsers(data)) // Atualiza o estado "users" com os dados recebidos da API.
            .catch(error => console.error("Erro ao buscar dados", error)) // Caso ocorra um erro na requisição, exibe uma mensagem de erro no console.
    }, []) // A lista de dependências vazia faz com que o useEffect seja executado apenas uma vez, ao montar o componente.

    return( // Início da estrutura de retorno do JSX.
        <ul> {/* Cria uma lista não ordenada (ul) para exibir a lista de usuários. */}
            {users.map(user => ( // Mapeia o array "users" para renderizar um item de lista (li) para cada usuário.
                <li key={user.id}>{user.name}</li> // Cada usuário é exibido em um item de lista (li) com a propriedade "key" definida pelo id do usuário para identificação única.
            ))}
        </ul>
    )
}

export default UserList // Exporta o componente UserList para que possa ser importado e usado em outros arquivos.