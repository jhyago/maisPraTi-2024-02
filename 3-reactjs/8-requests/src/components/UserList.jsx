import UseUsers from "../hooks/useUsers"

const UserList = () => {
    const { users, loading } = UseUsers()

    if(loading) return <p>Carregando</p>

    return (
        <ul>
            {users.map((user) => (
                <li key={user.id}>{user.name}</li>
            ))}
        </ul>
    )
}

export default UserList