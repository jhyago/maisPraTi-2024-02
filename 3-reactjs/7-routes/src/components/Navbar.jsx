import { Link } from 'react-router-dom';
import AuthContext from '../context/AuthContext';
import { useContext } from 'react';

// Importa o componente `Link` do React Router DOM para criar links de navegação que alteram a rota sem recarregar a página.
// Também importa o contexto `AuthContext`, que gerencia o estado de autenticação na aplicação, e o hook `useContext`,
// que permite acessar os valores fornecidos pelo `AuthContext`.

function Navbar() {
    const { isAuthenticated } = useContext(AuthContext);
    // Utiliza o hook `useContext` para acessar o valor de `isAuthenticated` do `AuthContext`.
    // Este valor indica se o usuário está autenticado (true) ou não (false).

    return (
        <nav className='navbar'>
            {/* Define a barra de navegação com a classe CSS `navbar` para estilização. */}
            <Link to="/">Home</Link>
            {/* Cria um link para a página inicial (`/`). Este link sempre estará disponível. */}
            
            <Link to="/about">About</Link>
            {/* Cria um link para a página "About" (`/about`). Este link também estará sempre disponível. */}

            { isAuthenticated ? (
                <>
                    <Link to="/services">Services</Link>
                    {/* Se o usuário estiver autenticado (`isAuthenticated` é true), renderiza o link 
                        para a página de serviços (`/services`). */}
                </>
            ) : (
                <Link to="/login">Login</Link>
            )}

            <Link to="/contact">Contact</Link>
            {/* Cria um link para a página de contato (`/contact`). Este link está sempre disponível. */}
        </nav>
    );
    // Renderiza a barra de navegação com links dinâmicos baseados no estado de autenticação. 
    // O estado controla se o link para "Services" ou "Login" será exibido.
}

export default Navbar;
// Exporta o componente `Navbar` para que ele possa ser utilizado em outras partes da aplicação, como no componente principal `App`.