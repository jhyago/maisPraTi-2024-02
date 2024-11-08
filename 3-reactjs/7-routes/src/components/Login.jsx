import { useContext } from "react";
import AuthContext from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

function Login() {
    const { login } = useContext(AuthContext)
    const navigate = useNavigate()

    const handleLogin = () => {
        login()
        navigate('/services')
    }

    return(
        <div className="page">
            <h1>Login Page</h1>
            <button onClick={handleLogin}>Login</button>
        </div>
    )
}

export default Login