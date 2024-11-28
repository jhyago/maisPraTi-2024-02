import { useEffect, useState } from "react";
import { FaMoon, FaSun } from "react-icons/fa";

export const Navigation = () => {

  const [isDarkMode, setIsDarkMode] = useState(() => localStorage.getItem("theme") === "dark")
  const [isOpen, setIsOpen] = useState(false)

  useEffect(() => {
    if(isDarkMode){
      document.documentElement.classList.add("dark")
    } else {
      document.documentElement.classList.remove("dark")
    }
    localStorage.setItem("theme", isDarkMode ? "dark" : "light")
  }, [isDarkMode])

  const toggleMenu = () => {
    setIsOpen(!isOpen)
  }

  const toggleTheme = () => {
    setIsDarkMode(!isDarkMode)
  }

  return (
    <header className="p-6 sm:px-12 w-full h-28 z-50 fixed bg-gradient-to-b from-verde2/95 to-verde1/80 backdrop-blur-sm from-80%">
      {/* Cabeçalho fixo com espaçamento interno, largura total, altura fixa e fundo em gradiente com leve desfoque. */}

      <nav className="flex items-center justify-between">
        {/* Barra de navegação com itens centralizados verticalmente e distribuídos horizontalmente com espaço entre eles. */}

        <img className="w-52 sm:w-64" src="./Logo-2.webp" alt="" />
        {/* Logotipo da empresa. O tamanho da imagem se ajusta conforme o tamanho da tela. */}

        <div className="lg:hidden flex">
          {/* Div visível apenas no modo mobile (telas menores que lg), contendo botões de alternância de tema e menu. */}

          <button
            className="text-branco p-6 mr-3 bg-verde1 hover:bg-black"
            onClick={toggleTheme}
          >
            {isDarkMode ? <FaSun /> : <FaMoon />}
          </button>
          {/* Botão para alternar entre modo claro e escuro. Mostra ícones de sol ou lua com base no estado atual. */}

          <button
            className="text-branco focus:outline-none"
            onClick={toggleMenu}
          >
            <svg
              className="w-6 h-6"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M4 6h16M4 12h16m-7 6h7"
              ></path>
            </svg>
          </button>
          {/* Botão para abrir o menu lateral no mobile. Representado por um ícone de hambúrguer (três linhas horizontais). */}
        </div>

        <ul className="hidden lg:flex flex-row items-center gap-12 text-branco">
          {/* Lista de navegação visível apenas no desktop (telas maiores que lg). Itens dispostos horizontalmente. */}

          <li>
            <a className="hover:underline" href="#kits" id="linkKits">
              Kits
            </a>
          </li>
          {/* Link para a seção 'Kits'. */}

          <li>
            <a
              className="hover:underline"
              href="#OndeComprar"
              id="linkOndeComprar"
            >
              Onde Comprar
            </a>
          </li>
          {/* Link para a seção 'Onde Comprar'. */}

          <li>
            <a
              className="hover:underline"
              href="#FaleComigo"
              id="linkFaleComigo"
            >
              Fale Comigo
            </a>
          </li>
          {/* Link para a seção 'Fale Comigo'. */}

          <a
            id="ComprarAgora"
            href="https://www.catarse.me/rduvng"
            target="_blank"
            className="hidden text-branco lg:inline-block"
          >
            <button>Comprar Agora</button>
          </a>
          {/* Botão de 'Comprar Agora' visível apenas no desktop. Abre em uma nova aba. */}

          <li>
            <button
              className="text-branco bg-verde1 hover:bg-black"
              onClick={toggleTheme}
            >
              {isDarkMode ? <FaSun /> : <FaMoon />}
            </button>
          </li>
          {/* Botão para alternar entre temas claro e escuro, repetido no desktop. */}
        </ul>
      </nav>

      {/* Menu Mobile */}
      <div
        className={`fixed top-0 right-0 w-3/4 h-full bg-verde1/95 text-branco transform backdrop-blur-sm ${
          isOpen ? "translate-x-0" : "translate-x-full"
        } transition-transform duration-300 ease-in-out lg:hidden`}
      >
        {/* Menu lateral para mobile, desliza da direita para a esquerda quando `isOpen` é verdadeiro. */}

        <div className="flex items-center justify-end p-6">
          {/* Cabeçalho do menu lateral, contendo o botão de fechar. */}

          <button
            className="text-branco focus:outline-none"
            onClick={toggleMenu}
          >
            <svg
              className="w-8 h-8"
              fill="none"
              stroke="currentColor"
              viewBox="0 0 24 24"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth="2"
                d="M6 18L18 6M6 6l12 12"
              ></path>
            </svg>
          </button>
          {/* Botão de fechar o menu no mobile. Representado por um ícone de "X". */}
        </div>

        <div className="bg-verde1/90 h-dvh">
          {/* Conteúdo do menu lateral no mobile com links verticais. Fundo com opacidade. */}

          <ul className="flex flex-col items-start p-12 space-y-6 text-2xl">
            <li>
              <a
                className="hover:underline"
                href="#kits"
                id="linkKits"
                onClick={toggleMenu}
              >
                Kits
              </a>
            </li>
            <li>
              <a
                className="hover:underline"
                href="#OndeComprar"
                id="linkOndeComprar"
                onClick={toggleMenu}
              >
                Onde Comprar
              </a>
            </li>
            <li>
              <a
                className="hover:underline"
                href="#FaleComigo"
                id="linkFaleComigo"
                onClick={toggleMenu}
              >
                Fale Comigo
              </a>
            </li>
          </ul>
          {/* Links de navegação verticais com espaçamento no menu lateral. Fecha o menu ao clicar. */}

          <a
            id="ComprarAgora"
            href="https://www.catarse.me/rduvng"
            target="_blank"
            className="block w-full text-center mt-6 scale-125"
            onClick={toggleMenu}
          >
            <button>Comprar Agora</button>
          </a>
          {/* Botão de 'Comprar Agora' no menu lateral. Fecha o menu ao clicar. */}
        </div>
      </div>
    </header>
  );
};
