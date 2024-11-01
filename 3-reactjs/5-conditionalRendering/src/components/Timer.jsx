import { useState, useEffect } from 'react'

function Timer() {
    const[seconds, setSeconds] = useState(0)

    useEffect(() => {
        const interval = setInterval(() => {
            setSeconds(prevSeconds => prevSeconds + 1)
        }, 1000)

        return () => clearInterval(interval)
    }, [])

    return (
        <div>Segundos: {seconds}</div>
    )
}

export default Timer