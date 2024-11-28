export const FaleComigo = () => {
    return (
        <div
            id="FaleComigo"
            className="flex flex-col items-center m-auto justify-center xl:flex-row p-4 sm:p-12 text-center xl:text-left 2xl:w-2/3"
        >
            {/* Contêiner principal:
                - `id="FaleComigo"`: Define um ponto de âncora para navegação.
                - `flex flex-col`: Organização vertical padrão.
                - `xl:flex-row`: Organização horizontal em telas grandes.
                - `items-center`: Alinha os itens horizontalmente ao centro.
                - `m-auto`: Centraliza o contêiner na tela.
                - `justify-center`: Alinha os itens verticalmente ao centro.
                - `p-4 sm:p-12`: Adiciona espaçamento interno (maior em telas pequenas ou maiores).
                - `text-center xl:text-left`: Centraliza o texto no padrão e alinha à esquerda em telas grandes.
                - `2xl:w-2/3`: Define a largura como 2/3 da tela em telas muito grandes. */}

            {/* Texto principal */}
            <div className="w-full xl:w-2/3 p-12">
                {/* Subcontêiner do texto:
                    - `w-full`: Largura total padrão.
                    - `xl:w-2/3`: Reduz para 2/3 da largura em telas grandes.
                    - `p-12`: Espaçamento interno de 12 unidades. */}

                <h1 className="text-4xl font-bold sm:text-5xl mb-8">
                    Para comprar o livro com preço mais acessível (sem tarifas)
                    me chame no Instagram.
                </h1>
                {/* Título:
                    - `text-4xl`: Define o tamanho padrão do texto.
                    - `font-bold`: Negrito.
                    - `sm:text-5xl`: Aumenta o texto em telas pequenas.
                    - `mb-8`: Adiciona margem inferior de 8 unidades. */}

                <p className="text-2xl xl:text-xl">
                    Para leitores de Porto Alegre é possível combinar entrega
                    sem custo de frete. Para outros estados este valor deverá
                    ser calculado juntamente.
                    <br />
                    <br />
                    Indico, principalmente, optar por comprar o e-book por
                    e-mail ou DM do Instagram; você também recebe o arquivo na
                    hora, <strong>apoia mais diretamente o trabalho independente!</strong>
                    <br />
                    <br />
                    Neste modo, o valor é direcionado inteiramente à autora, sem
                    ter parte cortada por taxas de plataforma de vendas.
                </p>
                {/* Parágrafo:
                    - `text-2xl`: Define o tamanho padrão do texto.
                    - `xl:text-xl`: Reduz o tamanho do texto em telas grandes.
                    - Inclui elementos semânticos (`<strong>`) para destacar partes importantes. */}

                <a
                    href="https://www.instagram.com/rduvng/"
                    target="_blank"
                    class=""
                >
                    <button className="mt-12 text-branco scale-125 xl:scale-100">
                        Reserve o Seu Livro Comigo
                    </button>
                </a>
                {/* Botão:
                    - Link externo para o Instagram da autora.
                    - `mt-12`: Margem superior de 12 unidades.
                    - `text-branco`: Texto branco.
                    - `scale-125`: Aumenta o tamanho do botão em telas padrão.
                    - `xl:scale-100`: Reduz o botão para tamanho normal em telas grandes. */}
            </div>

            {/* Foto e informações da autora */}
            <div className="w-5/6 xl:w-3/6 p-2 text-center bg-creme1/50 dark:bg-verde2 rounded-b-[32rem] rounded-t-full">
                {/* Subcontêiner:
                    - `w-5/6`: Largura padrão de 5/6.
                    - `xl:w-3/6`: Reduz para 3/6 da largura em telas grandes.
                    - `p-2`: Pequeno espaçamento interno.
                    - `text-center`: Centraliza o texto.
                    - `bg-creme1/50 dark:bg-verde2`: Fundo translúcido no modo claro e verde escuro no modo escuro.
                    - `rounded-b-[32rem]`: Bordas inferiores arredondadas em formato elíptico.
                    - `rounded-t-full`: Bordas superiores totalmente arredondadas. */}

                <img
                    className="m-auto p-10"
                    src=".\foto-autora.webp"
                    alt="Foto da autora Ana Clara Galli"
                />
                {/* Imagem da autora:
                    - `m-auto`: Centraliza horizontalmente.
                    - `p-10`: Espaçamento interno ao redor da imagem.
                    - `alt`: Texto alternativo para acessibilidade. */}

                <h2 className="font-bold text-2xl">Ana Clara Galli</h2>
                {/* Nome da autora:
                    - `font-bold`: Negrito.
                    - `text-2xl`: Tamanho do texto definido como 2xl. */}

                <h3 className="text-xl pb-6">
                    autora de Relatos de um Vampiro na Guerra
                </h3>
                {/* Descrição da autora:
                    - `text-xl`: Define o tamanho do texto.
                    - `pb-6`: Margem inferior de 6 unidades. */}
            </div>
        </div>
    );
};