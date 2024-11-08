import { useState, useEffect } from 'react'
import { getUsers } from '../api/UserService'

const UseUsers = () => {
    const [users, setUsers] = useState([])
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await getUsers()
                setUsers(response.data)
            } catch (error) {
                console.error('Erro ao carregar os usuários: ', error)
            } finally {
                setLoading(false)
            }
        }
        fetchData()
    }, [])

    return { users, loading }
}

export default UseUsers