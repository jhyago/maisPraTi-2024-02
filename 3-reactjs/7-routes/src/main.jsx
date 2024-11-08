import { createRoot } from 'react-dom/client'
// Importa a função `createRoot` do pacote 'react-dom/client'. 
// Essa função é usada para inicializar e renderizar um aplicativo React no DOM.
// É a abordagem recomendada para projetos React modernos, substituindo a antiga `ReactDOM.render`.

import './styles/index.css'
// Importa o arquivo CSS global que será aplicado a todo o projeto.
// Aqui, estilos básicos ou globais, como resets ou layouts gerais, são definidos.

import App from './App.jsx'
// Importa o componente principal `App`, que contém toda a lógica de rotas e o conteúdo da aplicação.

import { AuthProvider } from './context/AuthContext.jsx'
// Importa o componente de contexto `AuthProvider`, que provavelmente fornece o estado de autenticação 
// e funções relacionadas (como login e logout) para os componentes filhos da aplicação.

createRoot(document.getElementById('root')).render(
  // Inicializa o aplicativo React, selecionando o elemento DOM com o id `root` como o contêiner principal.
  // O método `createRoot` cria um ponto de entrada para o aplicativo React moderno.

  <AuthProvider>
    {/* Envolve o componente `App` com o `AuthProvider`. 
        Isso disponibiliza o contexto de autenticação (AuthContext) para todos os componentes 
        filhos de `App`, permitindo que eles acessem estados ou métodos de autenticação. */}
    <App />
    {/* Renderiza o componente `App`, que contém toda a lógica da aplicação. */}
  </AuthProvider>,
)