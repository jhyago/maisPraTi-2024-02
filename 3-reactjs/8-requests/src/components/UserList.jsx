import UseUsers from "../hooks/useUsers"
// Importa um hook customizado chamado `UseUsers` do arquivo especificado. Este hook será usado para gerenciar o estado relacionado aos usuários, como a lista de usuários e o estado de carregamento.

const UserList = () => {
    // Define o componente funcional `UserList`. Ele renderiza uma lista de usuários baseada nos dados obtidos pelo hook `UseUsers`.

    const { users, loading } = UseUsers()
    // Desestrutura `users` (a lista de usuários) e `loading` (indicador de carregamento) do hook `UseUsers`.
    // `UseUsers` provavelmente encapsula lógica de estado e/ou requisições de dados.

    if(loading) return <p>Carregando</p>
    // Verifica se o estado `loading` está `true`. Se estiver, retorna um parágrafo com o texto "Carregando" para indicar ao usuário que os dados estão sendo carregados.
    // Isso evita que o componente tente renderizar uma lista de usuários quando os dados ainda não foram obtidos.

    return (
        <ul>
            {/* Retorna um elemento `ul` que contém a lista de usuários */}
            {users.map((user) => (
                // Usa o método `map` para iterar sobre o array `users`. Para cada usuário no array, cria um elemento `li` correspondente.
                <li key={user.id}>{user.name}</li>
                // Cada elemento da lista recebe uma `key` única baseada no `id` do usuário.
                // O conteúdo do `li` exibe o nome do usuário (`user.name`).
            ))}
        </ul>
    )
}

export default UserList
// Exporta o componente `UserList` como padrão para que possa ser importado e utilizado em outros arquivos do projeto.