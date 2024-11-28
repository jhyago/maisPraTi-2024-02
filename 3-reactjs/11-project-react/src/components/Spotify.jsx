export const Spotify = () => {
    return (
        <div className="flex flex-col pt-8 md:p-12 items-center justify-center m-auto bg-verde2 text-branco w-5/6 md:w-4/5 rounded-2xl h-fit xl:min-w-[1050px] 2xl:w-2/5">
            {/* Contêiner principal:
                - `flex flex-col`: Organiza os elementos verticalmente.
                - `pt-8`: Adiciona padding superior de 8 unidades.
                - `md:p-12`: Adiciona padding completo maior em telas médias ou maiores.
                - `items-center`: Centraliza os itens horizontalmente.
                - `justify-center`: Alinha os itens verticalmente ao centro.
                - `m-auto`: Centraliza o contêiner na tela.
                - `bg-verde2`: Fundo com cor personalizada verde2.
                - `text-branco`: Texto na cor branca.
                - `w-5/6 md:w-4/5`: Largura de 5/6 da tela padrão, ajustada para 4/5 em telas médias.
                - `rounded-2xl`: Bordas arredondadas grandes.
                - `h-fit`: Altura se ajusta ao conteúdo.
                - `xl:min-w-[1050px]`: Define largura mínima em telas grandes.
                - `2xl:w-2/5`: Reduz largura para 2/5 da tela em telas muito grandes. */}

            <div className="flex flex-col sm:flex-row items-center justify-center gap-10 mb-0 sm:mb-8">
                {/* Subcontêiner do título e imagens decorativas:
                    - `flex flex-col`: Organização vertical no padrão.
                    - `sm:flex-row`: Organização horizontal em telas pequenas.
                    - `items-center`: Centraliza os itens horizontalmente.
                    - `justify-center`: Alinha os itens verticalmente ao centro.
                    - `gap-10`: Espaçamento entre os itens.
                    - `mb-0 sm:mb-8`: Margem inferior variável (0 no padrão e 8 unidades em telas pequenas). */}

                <img
                    className="w-fit"
                    src="./cruz-03.svg"
                    alt="Cruz"
                />
                {/* Imagem decorativa inicial:
                    - `w-fit`: Ajusta largura com base no conteúdo.
                    - `src`: Caminho da imagem.
                    - `alt`: Texto alternativo para acessibilidade. */}

                <h1 className="text-4xl font-bold sm:text-5xl">
                    Entre no Mood
                </h1>
                {/* Título:
                    - `text-4xl`: Define o tamanho padrão do texto.
                    - `font-bold`: Negrito.
                    - `sm:text-5xl`: Aumenta o texto em telas pequenas. */}

                <img
                    className="md:w-fit w-0"
                    src="./cruz-03.svg"
                    alt="Cruz"
                />
                {/* Imagem decorativa final:
                    - `md:w-fit`: Exibe a imagem com largura ajustada ao conteúdo em telas médias ou maiores.
                    - `w-0`: Oculta a imagem em telas menores. */}
            </div>

            <div className="flex flex-col items-center justify-center gap-4 xl:flex-row m-auto pb-3">
                {/* Subcontêiner dos players do Spotify:
                    - `flex flex-col`: Organização vertical no padrão.
                    - `xl:flex-row`: Organização horizontal em telas grandes.
                    - `items-center`: Centraliza os players horizontalmente.
                    - `justify-center`: Centraliza os players verticalmente.
                    - `gap-4`: Espaçamento entre os players.
                    - `m-auto`: Centraliza o contêiner.
                    - `pb-3`: Adiciona padding inferior de 3 unidades. */}

                <iframe
                    className="rounded-2xl w-[300px] h-[352px]"
                    src="https://open.spotify.com/embed/playlist/1rIllGWmBAdBDtMbsom9wU?utm_source=generator"
                    allowfullscreen=""
                    allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"
                    loading="lazy"
                >
                </iframe>
                {/* Player do Spotify:
                    - `rounded-2xl`: Bordas arredondadas.
                    - `w-[300px]`: Largura fixa de 300px.
                    - `h-[352px]`: Altura fixa de 352px.
                    - `src`: URL do playlist embutido.
                    - `allowfullscreen`: Permite o modo tela cheia.
                    - `allow`: Habilita recursos como autoplay e mídia criptografada.
                    - `loading="lazy"`: Adia o carregamento até que o player esteja visível na tela. */}

                <iframe
                    className="rounded-2xl w-[300px] h-[352px]"
                    src="https://open.spotify.com/embed/playlist/3RXP1GHeziPq7uXIJU1iRr?utm_source=generator"
                    allowfullscreen=""
                    allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"
                    loading="lazy"
                >
                </iframe>
                {/* Segundo player do Spotify com as mesmas configurações. */}

                <iframe
                    className="rounded-2xl w-[300px] h-[352px]"
                    src="https://open.spotify.com/embed/playlist/5ZyTCVn4qWo0U8hSAEEGUB?utm_source=generator"
                    allowfullscreen=""
                    allow="autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture"
                    loading="lazy"
                >
                </iframe>
                {/* Terceiro player do Spotify com as mesmas configurações. */}
            </div>
        </div>
    );
};