import ApiClient from "./apiClient"

export const getUsers = () => ApiClient.get('/users')
export const addUser = (user) => ApiClient.post('/users', user)
export const deleteUser = (id) => ApiClient.delete(`/users/${id}`)