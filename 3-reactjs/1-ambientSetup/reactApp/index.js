// Importa a biblioteca React, que é necessária para criar e utilizar componentes em React
import React from 'react'

// Importa a biblioteca ReactDOM, que é usada para manipular o DOM (Document Object Model) no navegador, renderizando componentes React na página
import ReactDOM from 'react-dom'

// Importa o componente App que está localizado no arquivo './src/App'. Esse é o componente principal que será renderizado na aplicação
import App from './src/App'

// Usa o método ReactDOM.render para renderizar o componente App na página. 
// O primeiro argumento é o componente <App />, que é o que será mostrado na interface.
// O segundo argumento é a referência ao elemento HTML com o id 'root' no qual o React irá renderizar o componente App.
// Normalmente, no HTML da página existe uma div com o id 'root' onde a aplicação React será montada.
ReactDOM.render(<App />, document.getElementById('root'))