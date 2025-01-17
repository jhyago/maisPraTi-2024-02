import { useState, useEffect } from 'react'

function ChangeBG() {
    const[color, setColor] = useState(0)

    useEffect(() => {
        const interval = setInterval(() => {
            setColor('#' + Math.floor(Math.random() * 0x1000000).toString(16).padStart(6, '0'))
        }, 2000)

        return ( '#' + Math.floor(Math.random() * 0x1000000).toString(16).padStart(6, '0') )
    }, [color])

    return (
        <div>Cor: {color}</div>
    )
}

export default ChangeBG