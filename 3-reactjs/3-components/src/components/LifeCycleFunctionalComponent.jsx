import { useState, useEffect } from 'react'

function LifeCycleFunctionalComponent (){
    const [count, setCount] = useState(0)
    
    useEffect(() => {
        console.log("Componente montado!")

        return () => {console.log("Componente será desmontado!")}
    }, [])

    useEffect(() => {
        console.log("Componente atualizado!")
    }, [count])

    const increment = () => {
        setCount(count + 1)
    }

    return (
        <div>
            <p>Contagem: {count}</p>
            <button onClick={increment}>Incremente a Contagem</button>
        </div>
    )
}

export default LifeCycleFunctionalComponent