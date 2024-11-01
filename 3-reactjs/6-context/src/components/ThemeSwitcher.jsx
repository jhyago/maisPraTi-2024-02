import { useContext } from 'react'
import  Theme  from './Theme'

function ThemeSwitcher() {
    const { theme, toggleTheme } = useContext(Theme)

    return (
        <div>
            <p>O tema atual é: {theme}</p>
            <button onClick={toggleTheme}>Trocar o tema</button>
        </div>
    )
}

export default ThemeSwitcher