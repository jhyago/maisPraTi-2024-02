// Importa a classe Component do React, permitindo a criação de um componente de classe
import { Component } from 'react'

// Define o componente LifeCycleClassComponent, que é uma extensão da classe Component do React
class LifeCycleClassComponent extends Component {
    
    // O construtor inicializa o componente, configurando o estado inicial
    constructor(props) {
        super(props)
        // Define o estado inicial com a propriedade 'count' igual a 0
        this.state = { count: 0 }
    }

    // Método chamado automaticamente logo após o componente ser montado no DOM
    componentDidMount() {
        console.log("Componente montado!") // Mensagem de log para indicar que o componente foi montado
    }

    // Método chamado sempre que o componente é atualizado, ou seja, quando recebe novas props ou o estado muda
    componentDidUpdate(prevProps, prevState) {
        console.log("Componente atualizado! Propriedades e estados anteriores: ", prevProps, prevState)
        // Exibe no console as props e o estado anterior para ver o que mudou
    }

    // Método chamado imediatamente antes do componente ser desmontado do DOM
    componentWillUnmount() {
        console.log("Componente será desmontado!") // Mensagem de log indicando a desmontagem do componente
    }

    // Função que incrementa o valor de 'count' no estado em 1 ao ser chamada
    increment = () => {
        // Utiliza setState para atualizar o estado de forma assíncrona
        this.setState({ count: this.state.count + 1 })
    }

    // O método render é obrigatório em componentes de classe e define o que será exibido no DOM
    render() {
        return (
            <div>
                {/* Exibe o valor atual de 'count' */}
                <p>Contagem: {this.state.count}</p>
                {/* Botão que, ao ser clicado, chama a função 'increment' para aumentar a contagem */}
                <button onClick={this.increment}>Incrementar</button>
            </div>
        )
    }
}

// Exporta o componente para que ele possa ser importado e utilizado em outros arquivos
export default LifeCycleClassComponent