// Importa o hook useContext do React para acessar o contexto
import { useContext } from 'react'

// Importa o ThemeContext, criado no arquivo ThemeContext.js
import { ThemeContext } from './ThemeContext'

// Define o componente ThemeSwitcher, que permitirá alternar o tema
function ThemeSwitcher() {

    // Usa o hook useContext para acessar o valor do ThemeContext
    // Extraímos as variáveis 'theme' e 'toggleTheme' do contexto
    const { theme, toggleTheme } = useContext(ThemeContext)

    // Renderiza o componente
    return (
        <div>
            {/* Exibe o tema atual */}
            <p>O tema atual é: {theme}</p>
            {/* Botão que chama a função toggleTheme ao ser clicado, alternando o tema */}
            <button onClick={toggleTheme}>Trocar o tema</button>
        </div>
    )
}

// Exporta o componente ThemeSwitcher como padrão para que possa ser usado em outros lugares do aplicativo
export default ThemeSwitcher