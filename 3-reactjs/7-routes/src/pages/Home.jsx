import { Link, useNavigate } from 'react-router-dom'
// Importa os componentes e hooks do React Router DOM:
// - `Link`: Para criar links de navegação declarativa que alteram a URL sem recarregar a página.
// - `useNavigate`: Um hook que fornece uma função para navegação programática dentro da aplicação.

function Home() {
    const navigate = useNavigate()
    // Declaração do hook `useNavigate`. Ele retorna a função `navigate`, usada para mudar a rota 
    // programaticamente sem a necessidade de um link explícito.

    const goToServices = () => {
        navigate('/services')
        // Função que utiliza `navigate` para redirecionar o usuário para a página de serviços (`/services`) 
        // quando chamada. É útil em interações baseadas em eventos, como cliques de botão.
    }

    return (
        <div>
            {/* Div principal que contém o conteúdo da página. */}
            <h1>Home Page</h1>
            {/* Título principal da página. */}
            <p>Welcome!</p>
            {/* Texto de boas-vindas. */}
            <Link to="/about">Go to About</Link>
            {/* Link declarativo para a página "About" (`/about`). 
                Quando clicado, a URL muda para `/about`. */}
            <Link to="/contact">Go to Contact</Link>
            {/* Link declarativo para a página "Contact" (`/contact`). */}

            <div>
                {/* Contêiner para o botão de navegação. */}
                <button onClick={goToServices}>Go to Services</button>
                {/* Botão que dispara a função `goToServices` ao ser clicado, redirecionando para `/services`. */}
            </div>
        </div>
    )
}

export default Home
// Exporta o componente `Home` para que ele possa ser importado e usado em outros arquivos.