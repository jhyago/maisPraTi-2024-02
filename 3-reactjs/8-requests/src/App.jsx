import UsersPage from './pages/UsersPage'
import './styles/App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/" element={<h1>Bem-vindo</h1>} />
          <Route path="/users" element={<UsersPage/>} />
        </Routes>
      </Router>
    </>
  )

}

export default App
