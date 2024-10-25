import { StrictMode } from 'react' // Importa StrictMode do React, usado para verificar o código em modo estrito e identificar possíveis problemas
import { createRoot } from 'react-dom/client' // Importa a função createRoot da biblioteca react-dom/client, necessária para renderizar o app na árvore de elementos do DOM
import App from './App.jsx' // Importa o componente App do arquivo App.jsx

createRoot(document.getElementById('root')).render( // Cria a raiz do React vinculada ao elemento HTML com o id 'root' e chama a função render para iniciar a renderização

  // Envolve o aplicativo em StrictMode para habilitar verificações adicionais durante o desenvolvimento e renderiza o componente App dentro de StrictMode
  <StrictMode> 
    <App /> 
  </StrictMode>,
)
