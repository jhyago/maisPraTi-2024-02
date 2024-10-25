import { Component } from 'react'

class LifeCycleClassComponent extends Component {
    
    constructor(props) {
        super(props)
        this.state = { count: 0 }
    }

    componentDidMount() {
        console.log("Componente montado!")
    }

    componentDidUpdate(prevProps, prevState){
        console.log("Componente atualizado! Propriedades e estados anteriores: " + prevProps, prevState)
    }

    componentWillUnmount() {
        console.log("Componente será desmontado!")
    }

    increment = () => {
        this.setState({ count: this.state.count + 1 })
    }

    render() {
        return(
            <div>
                <p>Contagem: {this.state.count}</p>
                <button onClick={this.increment}>Incrementar</button>
            </div>
        )
    }
}

export default LifeCycleClassComponent