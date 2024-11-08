import { Link, useNavigate } from 'react-router-dom'

function Home() {
    const navigate = useNavigate()

    const goToServices = () => {
        navigate('/services')
    }

    return(
        <div>
            <h1>Home Page</h1>
            <p>Welcome!</p>
            <Link to="/about">Go to About</Link>
            <Link to="/contact">Go to Contact</Link>
            <div>
                <button onClick={goToServices}>Go to Services</button>
            </div>
        </div>
    )
}

export default Home