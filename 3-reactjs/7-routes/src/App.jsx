import './styles/App.css'
// Importa o arquivo CSS para estilizar o componente principal App.

import { BrowserRouter, Routes, Route } from 'react-router-dom'
// Importa componentes essenciais do React Router DOM para gerenciar a navegação da aplicação:
// - BrowserRouter: Envolve o aplicativo para habilitar o roteamento baseado em URLs.
// - Routes: Define um conjunto de rotas disponíveis na aplicação.
// - Route: Define cada rota individual, associando um caminho ('path') a um componente.

import Navbar from './components/Navbar'
// Importa o componente Navbar, que provavelmente é uma barra de navegação presente em todas as páginas.

import Home from './pages/Home'
// Importa o componente da página inicial da aplicação.

import About from './pages/About'
// Importa o componente da página "Sobre" (About).

import Services from './pages/Services'
// Importa o componente da página "Serviços" (Services), que estará protegida por uma rota.

import Contact from './pages/Contact'
// Importa o componente da página de contato (Contact).

import ProtectedRoute from './components/ProtectedRoute'
// Importa o componente ProtectedRoute, que é uma rota especial que protege o acesso a determinadas páginas, como a de serviços.

import Login from './components/Login'
// Importa o componente Login, que deve ser usado para autenticar usuários.

function App() {
// Define o componente principal da aplicação.

  return (
    <>
      {/* Fragmento React: permite encapsular o código sem adicionar um elemento DOM extra. */}
      <BrowserRouter>
        {/* BrowserRouter é o contexto para gerenciar rotas na aplicação. */}
        <Navbar />
        {/* Exibe o componente Navbar em todas as páginas. */}

        <Routes>
          {/* Define o contêiner de rotas para mapear URLs a componentes. */}
          <Route path='/' element={<Home />} />
          {/* Define a rota inicial ('/') e associa ao componente Home. */}
          
          <Route path='/about' element={<About />} />
          {/* Define a rota '/about' para exibir o componente About. */}
          
          <Route 
            path='/services' 
            element={
              <ProtectedRoute>
                <Services />
              </ProtectedRoute>
            } 
          />
          {/* Define a rota '/services'. O componente Services está protegido por ProtectedRoute, 
              que provavelmente verifica a autenticação antes de renderizar a página. */}

          <Route path='/contact' element={<Contact />} />
          {/* Define a rota '/contact' para exibir o componente Contact. */}

          <Route path='/login' element={<Login />} />
          {/* Define a rota '/login' para exibir o componente Login, onde o usuário provavelmente faz login. */}
        </Routes>
      </BrowserRouter>
      {/* Finaliza o contexto do BrowserRouter. */}
    </>
  )
}

export default App
// Exporta o componente App como padrão, permitindo que seja usado em outros arquivos, como no ponto de entrada (index.js).