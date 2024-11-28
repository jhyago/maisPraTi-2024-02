// Componente Sticker, exibindo informações sobre o conteúdo do livro.
export const Sticker = () => {
    return (
        <div className="flex flex-col m-auto w-full p-12">
            {/* Contêiner principal:
                - `flex flex-col`: Usa Flexbox para organizar os itens em uma coluna.
                - `m-auto`: Centraliza horizontalmente.
                - `w-full`: Define largura total.
                - `p-12`: Aplica espaçamento interno de 12 unidades. */}
            
            <h1 className="text-center text-5xl font-bold xl:text-5xl sm:text-4xl">
                O que você encontrará neste livro:
            </h1>
            {/* Título principal:
                - `text-center`: Centraliza o texto.
                - `text-5xl`: Define o tamanho padrão do texto.
                - `font-bold`: Aplica negrito.
                - Ajusta o tamanho para telas pequenas (sm) e muito grandes (xl). */}

            <ul className="grid grid-cols-1 gap-12 p-8 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 text-2xl sm:text-base xl:text-xl">
                {/* Lista de itens:
                    - `grid grid-cols-1`: Aplica layout de grade com 1 coluna.
                    - `gap-12`: Define o espaçamento entre os itens.
                    - `p-8`: Adiciona espaçamento interno.
                    - `sm:grid-cols-2`: Mostra 2 colunas em telas pequenas.
                    - `lg:grid-cols-3`: Mostra 3 colunas em telas grandes.
                    - `xl:grid-cols-4`: Mostra 4 colunas em telas muito grandes.
                    - `text-2xl`: Define tamanho de texto padrão e ajusta conforme os breakpoints. */}
                
                {/* Item 1 */}
                <li className="flex flex-col items-center gap-4 mb-12">
                    {/* Contêiner do item:
                        - `flex flex-col`: Organiza o conteúdo verticalmente.
                        - `items-center`: Centraliza o conteúdo horizontalmente.
                        - `gap-4`: Adiciona espaço entre elementos.
                        - `mb-12`: Adiciona margem inferior. */}
                    
                    <img
                        className="w-60"
                        src="./adesivo-01.webp"
                        alt=""
                    />
                    {/* Imagem do adesivo 1:
                        - `w-60`: Define largura fixa de 60 unidades.
                        - `src`: Caminho da imagem.
                        - `alt`: Deve conter uma descrição acessível. */}

                    <p className="text-2xl">
                        Uma jornada épica de autodescoberta e desafios inimagináveis.
                    </p>
                    {/* Descrição do item 1. O tamanho do texto é ajustado conforme breakpoints. */}
                </li>

                {/* Item 2 */}
                <li className="flex flex-col items-center gap-4 mb-12">
                    <img
                        className="w-60"
                        src="./adesivo-02.webp"
                        alt=""
                    />
                    <p className="text-2xl">
                        Uma protagonista corajosa que desafia as convenções de seu tempo.
                    </p>
                </li>
                {/* Descrição do item 2 segue o mesmo layout do item 1. */}

                {/* Item 3 */}
                <li className="flex flex-col items-center gap-4 mb-12">
                    <img
                        className="w-60"
                        src="./adesivo-03.webp"
                        alt=""
                    />
                    <p className="text-2xl">
                        Um mergulho na cultura e na história da Hungria nas vésperas da Primeira Guerra Mundial.
                    </p>
                </li>
                {/* Descrição do item 3 segue o mesmo layout do item 1. */}

                {/* Item 4 */}
                <li className="flex flex-col items-center gap-4 mb-12">
                    <img
                        className="w-60"
                        src="./adesivo-04.webp"
                        alt=""
                    />
                    <p className="text-2xl">
                        Um confronto com mitos e realidades que mudarão a vida de Mina para sempre.
                    </p>
                </li>
                {/* Descrição do item 4 segue o mesmo layout do item 1. */}
            </ul>
        </div>
    );
};