export const Relatos = () => {

    
    return (
        <div className="flex flex-col items-center justify-center m-auto">
            {/* Contêiner principal:
                - `flex flex-col`: Usa Flexbox para organizar os itens em uma coluna.
                - `items-center`: Centraliza os itens horizontalmente.
                - `justify-center`: Centraliza os itens verticalmente.
                - `m-auto`: Centraliza o contêiner na tela. */}
            
            <div className="flex flex-col sm:flex-row items-center m-auto p-12">
                {/* Subcontêiner para o título e as imagens laterais:
                    - `flex flex-col`: Organização vertical no padrão.
                    - `sm:flex-row`: Organização horizontal em telas pequenas (sm) ou maiores.
                    - `items-center`: Centraliza os itens horizontalmente.
                    - `m-auto`: Centraliza o contêiner na tela.
                    - `p-12`: Espaçamento interno de 12 unidades. */}
                
                <img
                    className="w-20 mt-0 fill-white"
                    src="./cruz-02.svg"
                    alt="Cruz"
                />
                {/* Imagem decorativa inicial (cruz):
                    - `w-20`: Largura fixa de 20 unidades.
                    - `mt-0`: Remove a margem superior.
                    - `fill-white`: Aplica cor branca ao SVG (se suportado). */}
    
                <h1 className="text-4xl px-10 mt-6 sm:mt-0 sm:text-5xl font-bold">
                    Relatos de quem já garantiu sua leitura
                </h1>
                {/* Título principal:
                    - `text-4xl`: Tamanho padrão do texto.
                    - `px-10`: Espaçamento interno horizontal (padding).
                    - `mt-6`: Margem superior padrão.
                    - `sm:mt-0`: Remove a margem superior em telas pequenas.
                    - `sm:text-5xl`: Aumenta o tamanho do texto em telas pequenas.
                    - `font-bold`: Aplica negrito ao texto. */}
    
                <img
                    className="sm:w-20 w-0 mt-0"
                    src="./cruz-02.svg"
                    alt="Cruz"
                />
                {/* Imagem decorativa final (cruz):
                    - `sm:w-20`: Exibe a imagem com largura de 20 unidades em telas pequenas.
                    - `w-0`: Oculta a imagem em telas menores que `sm`.
                    - `mt-0`: Remove a margem superior. */}
            </div>
    
            <div className="grid items-center justify-center grid-cols-1 gap-12 p-8 sm:gap-6 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 text-2xl sm:text-base xl:text-xl">
                {/* Contêiner para os relatos em formato de grade:
                    - `grid`: Aplica layout de grade.
                    - `items-center`: Alinha os itens verticalmente no centro.
                    - `justify-center`: Alinha os itens horizontalmente no centro.
                    - `grid-cols-1`: Define uma única coluna como padrão.
                    - `gap-12`: Espaçamento entre os itens no padrão.
                    - `p-8`: Adiciona espaçamento interno.
                    - Breakpoints:
                        - `sm:gap-6`: Reduz o espaçamento entre itens em telas pequenas.
                        - `sm:grid-cols-2`: Mostra 2 colunas em telas pequenas.
                        - `lg:grid-cols-3`: Mostra 3 colunas em telas grandes.
                        - `xl:grid-cols-4`: Mostra 4 colunas em telas muito grandes. */}
                
                {relatos.map((relatos) => (
                    <img
                        className="w-fit"
                        id={relatos.id}
                        src={relatos.imagem}
                        alt={relatos.alt}
                    />
                    /* Cada relato é renderizado como uma imagem:
                        - `w-fit`: A largura da imagem se ajusta ao conteúdo.
                        - `id={relatos.id}`: Atribui um ID único para cada imagem.
                        - `src={relatos.imagem}`: Define o caminho da imagem.
                        - `alt={relatos.alt}`: Define texto alternativo para acessibilidade. */
                ))}
            </div>
        </div>
    );    
}