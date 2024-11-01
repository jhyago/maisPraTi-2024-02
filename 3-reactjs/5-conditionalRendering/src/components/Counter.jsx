import { useState, useEffect } from 'react'

function Counter() {
    const [count, setCount] = useState(0)

    useEffect(() => {
        console.log(`O contador mudou para: ${count}`)
    },[count])

    return (
        <div>
            <p>Contador: {count}</p>
            <button onClick={() => setCount(count + 1)}>Incrementar</button>
        </div>
    )
}

export default Counter