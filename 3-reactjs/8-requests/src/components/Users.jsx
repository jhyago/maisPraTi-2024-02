import { useState, useEffect } from 'react'
import axios from 'axios'

const User = () => {
    const [users, setUsers] = useState([])
    const [error, setError] = useState('')

    useEffect(() => {
        axios.get('https://jsonplaceholder.typicode.com/users')
        .then(response => setUsers(response.data))
        .catch(error => setError(error.message))
    }, [])

    const addUser = async () => {
        try {
            const response = await axios.post('https://jsonplaceholder.typicode.com/users', {
                name: 'Patolino',
                email: 'patolino@disney.com'
            })
            console.log('Usuário adicionado ', response.data)
        } catch (error) {
            console.error('Erro ao adicionar usuário: ', error.message)
        }
    } 

    const deleteUser = async (userId) => {
        try {
            await axios.delete(`https://jsonplaceholder.typicode.com/users/users/${userId}`)
            console.log('Usuário deletado')
        } catch (error){ 
            console.error('Erro ao deletar o usuário', error.message)
        }
    }

    return (
        <div>
            <ul>
                {users.map((user) => (
                    <li key={user.id}>{user.name}</li>
                ))}
            </ul>
        </div>
    )
}

export default User