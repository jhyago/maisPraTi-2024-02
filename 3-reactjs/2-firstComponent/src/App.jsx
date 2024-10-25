import React, { useState } from 'react'

function App() {
    const [contagem, setContagem] = useState(0)

    const incrementar = () => {
        setContagem(contagem + 1)
    }

    return (
        <div style={{ textAlign: 'center', marginTop: '50px' }}>
            <h1>Contador: { contagem }</h1>
            <button onClick={incrementar}>Incrementar</button>
        </div>
    )
}

export default App
