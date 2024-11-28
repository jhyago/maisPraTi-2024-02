export const BannerDireto = () => {
    return (
        <div
            id="OndeComprar"
            className="flex flex-col items-center xl:flex-row m-auto bg-verde2 rounded-xl text-branco text-center xl:text-left p-6 w-5/6 min-h-[450px] md:w-5/6 xl:w-4/6 2xl:w-3/6 2xl:mt-8"
        >
            {/* Contêiner principal:
                - `id="OndeComprar"`: Define um ponto de âncora para navegação na página.
                - `flex flex-col`: Organiza os itens verticalmente no padrão.
                - `xl:flex-row`: Altera para layout horizontal em telas grandes (xl).
                - `m-auto`: Centraliza o contêiner horizontalmente na tela.
                - `bg-verde2`: Define o fundo como a cor personalizada verde2.
                - `rounded-xl`: Adiciona bordas arredondadas ao contêiner.
                - `text-branco`: Define a cor do texto como branco.
                - `text-center xl:text-left`: Centraliza o texto no padrão e alinha à esquerda em telas grandes.
                - `p-6`: Adiciona espaçamento interno de 6 unidades.
                - `w-5/6`: Define a largura como 5/6 da tela.
                - `min-h-[450px]`: Define uma altura mínima de 450px.
                - `md:w-5/6 xl:w-4/6 2xl:w-3/6`: Ajusta a largura conforme os breakpoints.
                - `2xl:mt-8`: Adiciona margem superior em telas muito grandes. */}

            <div>
                <img
                    className="max-h-[700px] p-0 xl:pr-10"
                    src=".\red_cross2.webp"
                    alt=""
                />
                {/* Imagem decorativa à esquerda:
                    - `max-h-[700px]`: Define uma altura máxima de 700px.
                    - `p-0`: Remove espaçamento interno padrão.
                    - `xl:pr-10`: Adiciona padding direito de 10 unidades em telas grandes. */}
            </div>

            <div className="flex flex-col p-6 m-auto">
                {/* Texto principal:
                    - `flex flex-col`: Organiza os elementos em coluna.
                    - `p-6`: Adiciona espaçamento interno.
                    - `m-auto`: Centraliza horizontalmente. */}

                <h1 className="text-3xl sm:text-5xl my-6">
                    Uma história que irá atravessar um século.
                </h1>
                {/* Título:
                    - `text-3xl`: Define o tamanho padrão do texto como 3xl.
                    - `sm:text-5xl`: Aumenta o texto para 5xl em telas pequenas.
                    - `my-6`: Adiciona margem vertical de 6 unidades. */}

                <p className="text-xl mb-12">
                    Reserve sua cópia agora e faça parte dessa jornada.
                </p>
                {/* Descrição:
                    - `text-xl`: Define o tamanho do texto como extra grande.
                    - `mb-12`: Adiciona margem inferior de 12 unidades. */}

                <div className="flex flex-col items-center xl:m-0 sm:flex-row m-auto gap-4">
                    {/* Botões de links:
                        - `flex flex-col`: Organiza os botões verticalmente no padrão.
                        - `sm:flex-row`: Alinha os botões horizontalmente em telas pequenas.
                        - `items-center`: Centraliza os botões horizontalmente.
                        - `m-auto`: Centraliza o contêiner.
                        - `xl:m-0`: Remove a margem em telas grandes.
                        - `gap-4`: Adiciona espaçamento entre os botões. */}

                    {/* Link para o eBook na Amazon */}
                    <a href="https://www.amazon.com.br/Relatos-um-Vampiro-na-Guerra-ebook/dp/B0D1LC8STG/ref=sr_1_1?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=3G5NNER48W4QE&dib=eyJ2IjoiMSJ9.O6NOoZJbXXRT2r5PnwTXdvzD-u0bQh4XZcjm-GrRXJEPW1PoItxUb5P2wmlY7dVNv5K_86IH2A1xXLXq7HKwm-eamNukd7CvGOSg1s4qIWQrgqGnth3KqW6wPR57U6PAYgbrxwfoqdjiX-K1oGNi_z7NKkrYr26cslvbP9MZF6ZVbcOtZjzJFkVArOEUxz0bC_1BwJZ9bvbKuEAZvQX94fw6HSlNuEwiRVxB76h71O4.3mZeE0Jeswmdkbd5fKP6dn0hC8vy40EIHgY0tgJCO9Q&dib_tag=se&keywords=Relatos+de+um+Vampiro+na+Guerra&qid=1714523437&s=books&sprefix=%2Cstripbooks%2C216&sr=1-1">
                        <button>
                            AMAZON - EBOOK
                        </button>
                    </a>

                    {/* Link para a versão capa dura na Amazon */}
                    <a href="https://www.amazon.com.br/dp/6500988353?ref=myi_title_dp">
                        <button>
                            AMAZON - CAPA DURA
                        </button>
                    </a>

                    {/* Link para a Shopee */}
                    <a href="https://shopee.com.br/product/332636394/18499247830/">
                        <button>
                            SHOPPE
                        </button>
                    </a>
                </div>
            </div>
        </div>
    );
};
