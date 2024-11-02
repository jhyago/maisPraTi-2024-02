// Importa os hooks createContext e useState do React
import { createContext, useState } from 'react'

// Cria um contexto chamado ThemeContext, que será utilizado para compartilhar o estado do tema entre componentes
export const ThemeContext = createContext()
    
// Define o ThemeProvider, um componente de contexto que permitirá que outros componentes acessem o tema
// eslint-disable-next-line react/prop-types
export const ThemeProvider = ({ children }) => {
  
  // Cria uma variável de estado chamada 'theme' com valor inicial "light" e uma função 'setTheme' para atualizar o valor de 'theme'
  const [theme, setTheme] = useState("light");

  // Define a função 'toggleTheme', que alterna o valor de 'theme' entre "light" e "dark"
  const toggleTheme = () => {
    setTheme((prevTheme) => (prevTheme === "light" ? "dark" : "light"));
  }

  // Retorna o provedor de contexto ThemeContext.Provider com o valor atual do tema e a função toggleTheme
  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      {children} {/* Renderiza os componentes filhos dentro do provedor, permitindo que eles acessem o valor do contexto */}
    </ThemeContext.Provider>
  )
}