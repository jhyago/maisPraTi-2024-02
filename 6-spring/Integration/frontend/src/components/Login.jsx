import { useState } from "react"
import api from "../services/api"

const Login = ({ onLogin }) => {
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [error, setError] = useState("")

    const handleLogin = async (event) => {
        event.preventDefault()
        try {
            await api.post("/login", {}, { auth: { username, password }})
            onLogin()
        } catch(error) {
            setError("Credenciais inválidas")
        }
    }

    return (
        <div className="container">
            <h2>Login</h2>
            {error && <p className="text-danger">{error}</p>}
            <form onSubmit={handleLogin}>
                <div> className="mb-3">
                    <label>Usuário</label>
                    <input
                        type="text"
                        className="form-control"
                        value={username}
                        onChange={(event) => setUsername(event.target.value)}
                    />
                </div>
                <div className="mb-3">
                    <label>Senha</label>
                    <input
                        type="password"
                        className="form-control"
                        value={password}
                        onChange={(event) => setPassword(event.target.value)}
                    />
                </div>
                <button className="btn btn-primary">Entrar</button>
            </form
        </div>
    )
}

export default Login;