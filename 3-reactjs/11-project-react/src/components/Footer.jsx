import React from "react";
import { FaSquareInstagram } from "react-icons/fa6"; // Ícone do Instagram
import { FaGoodreads } from "react-icons/fa"; // Ícone do Goodreads

export const Footer = () => {
    return (
        <div className="p-12 bg-preto text-branco">
            {/* Contêiner principal:
                - `p-12`: Padding interno de 12 unidades.
                - `bg-preto`: Fundo preto.
                - `text-branco`: Texto branco. */}

            <h1 className="footer-title text-4xl font-sans font-bold">
                Relatos de um Vampiro na Guerra
            </h1>
            {/* Título do rodapé:
                - `text-4xl`: Tamanho do texto grande.
                - `font-sans`: Fonte sans-serif.
                - `font-bold`: Texto em negrito. */}

            <div className="flex flex-row items-center justify-center pt-12 w-full gap-8 m-auto">
                {/* Contêiner dos ícones de redes sociais:
                    - `flex flex-row`: Organização horizontal dos itens.
                    - `items-center`: Centraliza os itens verticalmente.
                    - `justify-center`: Centraliza os itens horizontalmente.
                    - `pt-12`: Padding superior de 12 unidades.
                    - `w-full`: Largura total.
                    - `gap-8`: Espaçamento horizontal entre os itens.
                    - `m-auto`: Centraliza o contêiner na tela. */}

                <a
                    href="https://www.goodreads.com/book/show/211226924-relatos-de-um-vampiro-na-guerra"
                    target="_blank"
                >
                    <div className="text-5xl" alt="Good Reads">
                        <FaGoodreads />
                    </div>
                    {/* Link para a página do livro no Goodreads:
                        - `text-5xl`: Tamanho do ícone.
                        - O ícone é renderizado usando `FaGoodreads` da biblioteca `react-icons`.
                        - `target="_blank"`: Abre o link em uma nova aba. */}
                </a>

                <a href="https://www.instagram.com/rduvng/" target="_blank">
                    <div className="text-5xl" alt="Instagram">
                        <FaSquareInstagram />
                    </div>
                    {/* Link para a página do Instagram:
                        - Ícone do Instagram renderizado com `FaSquareInstagram` da biblioteca `react-icons`.
                        - Configurações similares ao link anterior. */}
                </a>

                <a
                    href="https://www.skoob.com.br/relatos-de-um-vampiro-na-guerra-122450332ed122451356.html"
                    target="_blank"
                >
                    <img
                        className="w-10 h-10"
                        src=".\icon-skoob.webp"
                        alt="Skoob"
                    />
                    {/* Link para a página do livro no Skoob:
                        - `w-10 h-10`: Define largura e altura de 10 unidades para o ícone.
                        - `src`: Caminho para a imagem do ícone do Skoob.
                        - `alt="Skoob"`: Texto alternativo para acessibilidade. */}
                </a>
            </div>

            <div className="pt-10 w-full text-xl">
                {/* Contêiner do crédito do desenvolvedor:
                    - `pt-10`: Padding superior de 10 unidades.
                    - `w-full`: Largura total.
                    - `text-xl`: Tamanho do texto grande. */}

                <a
                    href="https://www.linkedin.com/in/leonardo-boeira-maciel/"
                    target="_blank"
                    rel="noopener noreferrer"
                >
                    <div className="hover:underline">
                        Site desenvolvido por Leonardo Boeira Maciel
                    </div>
                    {/* Link para o LinkedIn do desenvolvedor:
                        - `hover:underline`: Adiciona sublinhado ao texto quando o mouse passa sobre ele.
                        - `rel="noopener noreferrer"`: Melhora segurança e performance ao abrir links em nova aba. */}
                </a>
            </div>
        </div>
    );
};