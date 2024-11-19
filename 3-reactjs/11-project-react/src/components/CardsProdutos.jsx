import React from "react";

export const CardsProdutos = ({ produto }) => {
    return (
        <div className="bg-verde1 rounded-xl flex flex-col items-center justify-between gap-1 p-10 text-branco">
            {/* Contêiner principal:
                - `bg-verde1`: Fundo verde escuro.
                - `rounded-xl`: Bordas arredondadas grandes.
                - `flex flex-col`: Organiza os itens verticalmente.
                - `items-center`: Centraliza os itens horizontalmente.
                - `justify-between`: Espaça os itens verticalmente.
                - `gap-1`: Espaçamento pequeno entre os elementos.
                - `p-10`: Padding interno.
                - `text-branco`: Texto branco. */}

            <div className="mb-8">
                <img
                    className="w-fit"
                    src="./cruz-02.svg"
                    alt="Cruz"
                />
                {/* Ícone decorativo no topo:
                    - `w-fit`: Ajusta largura ao conteúdo.
                    - `src`: Caminho da imagem.
                    - `alt`: Texto alternativo para acessibilidade.
                    - `mb-8`: Margem inferior para separar do próximo elemento. */}
            </div>

            <div className="text-4xl uppercase">{produto.titulo}</div>
            {/* Título do produto:
                - `text-4xl`: Tamanho grande do texto.
                - `uppercase`: Deixa o texto em letras maiúsculas.
                - `produto.titulo`: Propriedade dinâmica recebida como prop. */}

            <img
                className="img-ebook w-fit"
                src={produto.imagem}
                alt={produto.titulo}
            />
            {/* Imagem do produto:
                - `img-ebook`: Classe personalizada para futuras estilizações.
                - `w-fit`: Ajusta largura ao conteúdo.
                - `src={produto.imagem}`: Imagem dinâmica do produto.
                - `alt={produto.titulo}`: Texto alternativo para acessibilidade. */}

            <div className="font-bold text-5xl leading-8 mt-4">{produto.preco1}</div>
            {/* Preço principal:
                - `font-bold`: Texto em negrito.
                - `text-5xl`: Tamanho grande do texto.
                - `leading-8`: Altura da linha ajustada.
                - `mt-4`: Margem superior. */}

            <div
                className="produto-complemento"
                dangerouslySetInnerHTML={{ __html: produto.complemento1 }}
            >
            </div>
            {/* Complemento do preço principal:
                - `produto-complemento`: Classe personalizada para estilizações.
                - `dangerouslySetInnerHTML`: Permite renderizar HTML dinâmico.
                - **Nota de segurança:** Certifique-se de que `produto.complemento1` seja sanitizado para evitar ataques XSS. */}

            {produto.preco2 && (
                <div className="font-bold text-4xl leading-5 mt-6">{produto.preco2}</div>
            )}
            {/* Preço secundário (renderizado condicionalmente):
                - Só aparece se `produto.preco2` for definido.
                - Estilos semelhantes ao preço principal, mas com tamanho menor. */}

            {produto.complemento2 && (
                <div className="produto-complemento">
                    {produto.complemento2}
                </div>
            )}
            {/* Complemento do preço secundário (renderizado condicionalmente):
                - Só aparece se `produto.complemento2` for definido.
                - `produto.complemento2`: Texto adicional recebido como prop. */}

            <div className="mt-6">
                <p>
                    <a
                        href={produto.link}
                        target="_blank"
                        rel="noopener noreferrer"
                    >
                        <button>
                            COMPRE AGORA
                        </button>
                    </a>
                </p>
                {/* Botão de compra:
                    - `href={produto.link}`: Link dinâmico para a página do produto.
                    - `target="_blank"`: Abre o link em uma nova aba.
                    - `rel="noopener noreferrer"`: Melhora segurança e performance para links externos. */}
            </div>
        </div>
    );
};