import { useContext } from 'react'
import { ThemeContext} from './ThemeContext'

function ThemeSwitcher() {
    const { theme, toggleTheme } = useContext(ThemeContext)

    return (
        <div>
            <p>O tema atual é: {theme}</p>
            <button onClick={toggleTheme}>Trocar o tema</button>
        </div>
    )
}

export default ThemeSwitcher