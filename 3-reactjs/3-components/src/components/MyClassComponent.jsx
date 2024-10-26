// Importa a classe Component do React para permitir a criação de um componente de classe
import { Component } from 'react'

// Define o componente de classe MyClassComponent que herda funcionalidades de React.Component
class MyClassComponent extends Component {
    
    // Construtor inicializa o estado do componente
    constructor(props) {
        super(props)
        // Define o estado inicial com 'count' igual a 0
        this.state = { count: 0 }
    }

    // Método incrementCount atualiza o estado ao incrementar o valor de 'count' em 1
    incrementCount = () => {
        // Usa setState para atualizar o estado de forma assíncrona, adicionando 1 ao valor atual de 'count'
        this.setState({ count: this.state.count + 1 })
    }

    // Método render é obrigatório em componentes de classe e define o que será exibido no DOM
    render() {
        return (
            <div>
                {/* Exibe o valor atual de 'count' */}
                <p>Contagem: {this.state.count}</p> 
                {/* Botão que chama o método incrementCount ao ser clicado */}
                <button onClick={this.incrementCount}>Incrementar</button>
            </div>
        )
    }
}

// Exporta o componente para ser utilizado em outros arquivos
export default MyClassComponent