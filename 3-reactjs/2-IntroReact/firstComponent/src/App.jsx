import React, { useState } from 'react' // Importa React e o hook useState do React

function App() { // Define o componente funcional App
    const [contagem, setContagem] = useState(0) // Declara um estado "contagem" inicializado em 0 e a função "setContagem" para atualizar o estado

    const incrementar = () => { // Define a função "incrementar" para incrementar a contagem
        setContagem(contagem + 1) // Atualiza o estado "contagem" somando 1 ao valor atual
    }

    return ( // Renderiza o componente
        <div style={{ textAlign: 'center', marginTop: '50px' }}> {/* Aplica estilos inline para centralizar o conteúdo e adicionar uma margem superior */}
            <h1>Contador: { contagem }</h1> {/* Exibe o valor atual de "contagem" */}
            <button onClick={incrementar}>Incrementar</button> {/* Cria um botão que chama a função "incrementar" ao ser clicado */}
        </div>
    )
}

export default App // Exporta o componente App como padrão para ser usado em outros arquivos