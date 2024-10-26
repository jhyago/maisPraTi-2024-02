// Importa os hooks useState e useEffect do React
import { useState, useEffect } from 'react'

// Define o componente funcional LifeCycleFunctionalComponent
function LifeCycleFunctionalComponent () {
    // Define um estado 'count' inicializado com o valor 0, e uma função 'setCount' para atualizar esse estado
    const [count, setCount] = useState(0)
    
    // Primeiro useEffect simula o método componentDidMount e componentWillUnmount do ciclo de vida do componente de classe
    useEffect(() => {
        // Executado uma vez, logo após o componente ser montado no DOM
        console.log("Componente montado!")

        // Retorna uma função de limpeza que será executada quando o componente for desmontado
        return () => {
            console.log("Componente será desmontado!") // Indica a desmontagem do componente
        }
    }, []) // O array vazio faz com que este efeito execute apenas uma vez

    // Segundo useEffect monitora o estado 'count' e simula o método componentDidUpdate
    useEffect(() => {
        console.log("Componente atualizado!") // Indica que o componente foi atualizado

    }, [count]) // Este efeito será executado sempre que 'count' mudar

    // Função que incrementa o valor de 'count' ao ser chamada
    const increment = () => {
        // Atualiza o estado 'count' adicionando 1 ao valor atual
        setCount(count + 1)
    }

    // Renderiza o conteúdo do componente
    return (
        <div>
            {/* Exibe o valor atual de 'count' */}
            <p>Contagem: {count}</p>
            {/* Botão que, ao ser clicado, chama a função 'increment' para aumentar a contagem */}
            <button onClick={increment}>Incremente a Contagem</button>
        </div>
    )
}

// Exporta o componente para que ele possa ser utilizado em outros arquivos
export default LifeCycleFunctionalComponent