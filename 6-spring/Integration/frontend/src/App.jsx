import { useState } from 'react'
import { BrowserRouter as Router, Route, Routes, Navigate} from 'react-router-dom'
import Login from './components/Login'
import UserList from './components/UserList'
import CourseList from './components/CourseList'

function App() {
    const [authenticated, setAuthenticated] = useState(false)

    return (
       <Router>
        <Routes>
            <Route path="/" element={<Login onLogin={() => setAuthenticated(true) />} />
            {authenticated ? (
                <>
                    <Route path="/usuarios" element={<UserList />} />
                    <Route path="/cursos" element={<CourseList />} />
                </>
            ) : (
                <Route path="*" element={<Navigate to="/" />} />
            )}
        </Routes>
       </Router>
    )
}

export default App
