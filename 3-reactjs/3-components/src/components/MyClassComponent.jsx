import { Component } from 'react'

class MyClassComponent extends Component {
    
    constructor(props) {
        super(props)
        this.state = { count: 0 }
    }

    incrementCount = () => {
        this.setState({ count: this.state.count + 1 })
    }

    render() {
        return (
            <div>
               <p>Contagem: {this.state.count}</p> 
               <button onClick={this.incrementCount}>Incrementar</button>
            </div>
        )
    }
}

export default MyClassComponent