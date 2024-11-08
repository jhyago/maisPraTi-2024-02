import './styles/App.css'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Home from './pages/Home'
import About from './pages/About'
import Services from './pages/Services'
import Contact from './pages/Contact'
import ProtectedRoute from './components/ProtectedRoute'
import Login from './components/Login'

function App() {
  
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/about' element={ <About /> } />
          <Route path='/services' element={ 
          <ProtectedRoute>
            <Services />
          </ProtectedRoute> } />
          <Route path='/contact' element={ <Contact /> } />
          <Route path='/login' element={ <Login /> } />
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
