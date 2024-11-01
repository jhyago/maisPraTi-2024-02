import { useState } from "react" // Importa o hook useState do React, que será usado para gerenciar o estado de login.

function Login() { // Declara um componente funcional chamado Login.
    const [isLoggedIn, setIsLoggedIn] = useState(false) // Cria uma variável de estado chamada "isLoggedIn" inicializada como false, e "setIsLoggedIn" para alterá-la.

    return ( // Início da estrutura de retorno do JSX, que define a interface do componente.
        <div> {/* Cria uma div para conter os elementos do componente. */}
            {isLoggedIn ? ( // Verifica se "isLoggedIn" é true; se for, exibe o botão de logout.
                <button onClick={() => setIsLoggedIn(false)}>Logout</button> // Botão de logout; ao clicar, define "isLoggedIn" como false.
            ) : ( // Caso "isLoggedIn" seja false, exibe o botão de login.
                <button onClick={() => setIsLoggedIn(true)}>Login</button> // Botão de login; ao clicar, define "isLoggedIn" como true.
            )}
            <p>{isLoggedIn ? "Bem-vindo(a)!" : "Por favor, faça login."}</p> {/* Exibe uma mensagem de boas-vindas se "isLoggedIn" for true, senão solicita o login. */}
        </div>    
    )
}

export default Login // Exporta o componente Login para que possa ser importado e usado em outros arquivos.