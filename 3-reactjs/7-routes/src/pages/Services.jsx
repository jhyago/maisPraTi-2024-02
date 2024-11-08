import { useNavigate } from 'react-router-dom'
// Importa o hook `useNavigate` do React Router DOM, que permite navegar programaticamente para outras rotas.

import AuthContext from '../context/AuthContext'
// Importa o contexto `AuthContext`, que provavelmente contém informações e funções relacionadas à autenticação, 
// como o método `logout`.

import { useContext } from 'react'
// Importa o hook `useContext`, que permite acessar o valor do `AuthContext`.

function Services() {
    const navigate = useNavigate()
    // Utiliza o hook `useNavigate` para obter a função `navigate`, usada para redirecionar programaticamente.

    const { logout } = useContext(AuthContext)
    // Usa o `useContext` para acessar o valor do `AuthContext`. 
    // Aqui, está extraindo a função `logout`, que provavelmente desconecta o usuário.

    const goToContact = () => {
        navigate('/contact')
        // Define uma função para redirecionar o usuário para a página de contato (`/contact`) 
        // quando chamada, utilizando a função `navigate`.
    }

    return (
        <div className='page'>
            {/* Div principal com a classe CSS 'page', usada para estilização. */}
            <h1>Services Page</h1>
            {/* Título da página de serviços. */}

            <ul>
                {/* Lista de serviços oferecidos. */}
                <li>Desenvolvimento de Software</li>
                <li>Design Gráfico</li>
            </ul>

            <button onClick={goToContact}>Contact US</button>
            {/* Botão que, ao ser clicado, executa a função `goToContact`, 
                redirecionando o usuário para a página de contato (`/contact`). */}

            <button onClick={logout}>Logout</button>
            {/* Botão que, ao ser clicado, executa a função `logout`, 
                provavelmente desconectando o usuário da aplicação. */}
        </div>
    )
}

export default Services
// Exporta o componente `Services` para que possa ser usado em outros arquivos.