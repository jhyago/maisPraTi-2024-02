import { useEffect, useState } from "react"
import api from "../services/api"

const UserList = () => {
    const [users, setUsers] = useState([])

    useEffect(() => {
        api.get("/usuarios").then((response) => {
            setUsers(response.data)
        })
    }, [])

    return (
        <div>
            <h2>Lista de Usuários</h2>
            <ul className="list-group">
                {users.map((user) => (
                    <li key={user.id} className="list-group-item">
                        {user.nome}
                    </li>
                )}
            </ul>
        </div>
    )
}

export default UserList