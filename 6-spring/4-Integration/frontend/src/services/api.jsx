import axios from "axios"; // Importa a biblioteca axios, que facilita a realização de requisições HTTP

// Cria uma instância do axios com configurações personalizadas
const api = axios.create({
    baseURL: "http://localhost:8080", // Define a URL base para todas as requisições HTTP (aponta para o backend local na porta 8080)
    withCredentials: true, // Permite o envio de cookies e outras credenciais junto com as requisições
});

export default api; // Exporta a instância 'api' para que possa ser utilizada em outras partes da aplicação