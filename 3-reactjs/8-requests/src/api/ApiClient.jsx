import axios from 'axios'

const ApiClient = axios.create({
    baseURL: 'https://jsonplaceholder.typecode.com',
    timeout: 10000
})

export default ApiClient