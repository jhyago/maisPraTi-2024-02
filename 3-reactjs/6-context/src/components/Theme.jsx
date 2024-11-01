import { createContext, useState, useContext } from 'react'

function Theme() {
    const ThemeContext = createContext()

    const ThemeProvider = ({children}) => {
        const [theme, setTheme] = useState('light')

        const toggleTheme = () => {
            setTheme((prevTheme) => (prevTheme === 'light' ? 'dark' : 'light'))
        }
    }

    return (
        <ThemeContext.Provider value={{ theme, toggleTheme }}>
            {children}
        </ThemeContext.Provider>
    )
}

export default Theme