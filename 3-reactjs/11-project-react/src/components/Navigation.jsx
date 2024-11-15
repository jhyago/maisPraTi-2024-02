import { useState, useEffect } from 'react'
import { FaMoon, FaSun } from 'react-icons/fa'

export const Navigation = () => {
    const [isDarkMode, setIsDarkMode] = useState()
    const [isOpen, setIsOpen] = useState(false)

    const toggleMenu = () => {
        setIsOpen(!isOpen)
    }

    const toggleTheme = () => {
        setIsDarkMode(!isDarkMode)
    }

    return (
        <header className='p-6 sm:px-12 w-full h-28 z-50 fixed bg-gradient-to-b from-verde2/95 to-verde1/80 backdrop-blur-sm'>
            <nav className='flex items-center justify-between'>
                <img src="" alt="" className='w-52 sm:w-64'/>

                <div className='lg:hidden flex'>
                    <button 
                        className='text-branco p-6 mr-3 bg-verde1 hover:bg-black' 
                        onClick={toggleMenu}>
                        <svg>

                        </svg>
                    </button>
                    <ul className='hidden lg:flex flex-row items-center gap-12 text-branco'>
                        <li>
                            <a href="" className='hover:underline'>Kits</a>
                        </li>
                        <li>
                            <a href="" className='hover:underline'>Onde Comprar</a>
                        </li>
                        <li>
                            <a href="" className='hover:underline'>Fale Comigo</a>
                        </li>
                        <li>
                            <a href="" className='hover:underline'><button>Comprar Agora</button></a>
                        </li>
                        <li>
                            <button 
                                className='text-branco bg-verde1 hover:bg-black'
                                onClick={toggleTheme}>
                                    { isDarkMode ? <FaSun /> : <FaMoon /> }
                            </button>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
    )
}