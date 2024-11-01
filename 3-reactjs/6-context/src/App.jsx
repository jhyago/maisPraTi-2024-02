import './App.css'
import { ThemeProvider } from './components/ThemeContext'
import ThemeSwitcher from './components/ThemeSwitcher'

function App() {
  return (
    <>
        <ThemeProvider>
          <h1>Exemplo de Tema com useContext</h1>
          <ThemeSwitcher/>
        </ThemeProvider>
    </>
  )
}

export default App
