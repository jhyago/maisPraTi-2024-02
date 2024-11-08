import { useContext } from 'react';
import { Navigate } from 'react-router-dom';
import AuthContext from '../context/AuthContext';

// Importa o hook `useContext` para acessar o contexto de autenticação (`AuthContext`) 
// e o componente `Navigate` do React Router DOM, que permite redirecionar o usuário para outra rota 
// caso ele não tenha permissão de acessar a rota protegida.

function ProtectedRoute({ children }) {
    const { isAuthenticated } = useContext(AuthContext);
    // Usa o `useContext` para obter o valor de `isAuthenticated` do `AuthContext`.
    // Este valor indica se o usuário está autenticado (`true`) ou não (`false`).

    if (!isAuthenticated) {
        return <Navigate to="/login" />;
        // Se o usuário não estiver autenticado (`isAuthenticated` é false), retorna o componente `Navigate`,
        // que redireciona o usuário para a rota de login (`/login`).
    }

    return children;
    // Caso o usuário esteja autenticado (`isAuthenticated` é true), renderiza o conteúdo da rota protegida,
    // que é passado como `children` para este componente.
}

export default ProtectedRoute;
// Exporta o componente `ProtectedRoute` para que ele possa ser usado em outras partes da aplicação,
// protegendo rotas que requerem autenticação.