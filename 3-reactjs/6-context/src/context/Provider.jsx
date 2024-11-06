import { ThemeProvider } from "./ThemeContext";
import { TodoProvider } from "./TodoContext"

const Provider = ({children}) => {
    return (
        <TodoProvider>
            <ThemeProvider>
                {children}
            </ThemeProvider>
        </TodoProvider>
    )
}

export default Provider