import { useContext } from "react";
import AuthContext from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

// Importa o hook `useContext` para acessar valores e funções do contexto React, neste caso, o `AuthContext`,
// que contém o estado e as funções relacionadas à autenticação, como `login`. Também importa o `useNavigate` 
// do React Router DOM, usado para redirecionar o usuário programaticamente para outra página após uma ação, 
// como o login bem-sucedido.

function Login() {
    const { login } = useContext(AuthContext);
    const navigate = useNavigate();

    // Usa o `useContext` para acessar a função `login` do `AuthContext`. Essa função altera o estado 
    // de autenticação para `true`, indicando que o usuário está autenticado. O `useNavigate` retorna 
    // a função `navigate`, que permite redirecionar o usuário para outra página, como a de serviços (`/services`).

    const handleLogin = () => {
        login();
        navigate('/services');
    };

    // Define a função `handleLogin` que chama a função `login` para autenticar o usuário e, em seguida, 
    // usa o `navigate` para redirecioná-lo à página de serviços (`/services`).

    return (
        <div className="page">
            <h1>Login Page</h1>
            <button onClick={handleLogin}>Login</button>
        </div>
    );
}

// O componente renderiza uma página de login simples com um título e um botão. 
// O botão, ao ser clicado, chama a função `handleLogin`, que autentica o usuário (através do `login`) 
// e o redireciona para a página de serviços usando `navigate`.

export default Login;

// Exporta o componente `Login` para que ele possa ser usado em outros arquivos da aplicação. 
// Ele está integrado ao contexto de autenticação, o que facilita o gerenciamento do login do usuário.