import { createContext, useState } from 'react'
// Importa `createContext` para criar um contexto que pode compartilhar dados globalmente na aplicação.
// Importa `useState` para gerenciar o estado interno relacionado à autenticação do usuário.


const AuthContext = createContext()
// Cria o contexto `AuthContext`, que será utilizado para armazenar e compartilhar o estado de autenticação
// e as funções relacionadas (`login` e `logout`) entre os componentes da aplicação.


export function AuthProvider({children}){
    // Define o componente `AuthProvider`.
    // Ele será usado para envolver os componentes filhos (`children`) da aplicação, 
    // fornecendo acesso ao estado e funções de autenticação.
    
    const [isAuthenticated, setIsAuthenticated] = useState(false)
    // Declara um estado chamado `isAuthenticated`, com valor inicial `false`, 
    // indicando que o usuário não está autenticado por padrão.
    // A função `setIsAuthenticated` permite atualizar o valor de `isAuthenticated`.

    const login = () => {
        setIsAuthenticated(true)
        // Função `login` que atualiza o estado `isAuthenticated` para `true`.
        // Representa a ação de autenticar o usuário (por exemplo, após um login bem-sucedido).
    }


    const logout = () => {
        setIsAuthenticated(false)
        // Função `logout` que atualiza o estado `isAuthenticated` para `false`.
        // Representa a ação de desconectar o usuário (por exemplo, após um clique no botão "Sair").
    }

    return(
        <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
        {/* Retorna o `AuthContext.Provider`, que fornece os dados e funções de autenticação
            para todos os componentes filhos (`children`) que estão dentro do `AuthProvider`. */}
        
            {children}
            {/* Renderiza os componentes filhos que foram passados para o `AuthProvider`. */}
        </AuthContext.Provider>
    )
}

export default AuthContext
// Exporta o `AuthContext` como padrão, permitindo que outros componentes 
// possam consumi-lo usando o hook `useContext(AuthContext)`.