export const Forms = () => {

    return (
        <div className="w-full mt-12 bg-verde2 m-auto flex flex-col items-center justify-center xl:flex-row text-branco md:p-4 xl:p-0">
            {/* Contêiner principal:
                - `w-full`: Largura total.
                - `mt-12`: Margem superior de 12 unidades.
                - `bg-verde2`: Fundo com cor personalizada verde2.
                - `m-auto`: Centraliza o contêiner horizontalmente.
                - `flex flex-col`: Organização vertical padrão.
                - `xl:flex-row`: Alterna para organização horizontal em telas grandes.
                - `text-branco`: Define a cor do texto como branco.
                - `md:p-4 xl:p-0`: Padding variável conforme breakpoints. */}

            <h1 className="text-2xl md:text-4xl xl:text-3xl text-center m-0 xl:pl-12 xl:text-left pt-12 xl:pt-0">
                Para dúvidas ou contato, <br /> encaminhe sua mensagem
            </h1>
            {/* Título:
                - `text-2xl`: Tamanho do texto padrão.
                - `md:text-4xl`: Aumenta o texto em telas médias.
                - `xl:text-3xl`: Ajusta o texto em telas grandes.
                - `text-center`: Centraliza o texto no padrão.
                - `xl:text-left`: Alinha o texto à esquerda em telas grandes.
                - `pt-12 xl:pt-0`: Padding superior de 12 unidades no padrão, removido em telas grandes. */}

            <form onSubmit={handleSubmit}>
                {/* Formulário:
                    - `onSubmit`: Define o comportamento do envio do formulário. */}

                <div className="flex flex-col xl:flex-row gap-8 p-12 md:w-full">
                    {/* Contêiner dos campos do formulário:
                        - `flex flex-col`: Organização vertical padrão.
                        - `xl:flex-row`: Organização horizontal em telas grandes.
                        - `gap-8`: Espaçamento entre os itens.
                        - `p-12`: Padding interno.
                        - `md:w-full`: Largura total em telas médias. */}

                    <div className="flex flex-col xl:flex-row xl:w-full md:w-dvw m-auto bg-verde1 p-6 rounded-2xl">
                        {/* Campo do Nome:
                            - `flex flex-col`: Organização vertical padrão.
                            - `xl:flex-row`: Organização horizontal em telas grandes.
                            - `xl:w-full`: Largura total em telas grandes.
                            - `bg-verde1`: Fundo verde escuro.
                            - `p-6`: Padding interno.
                            - `rounded-2xl`: Bordas arredondadas. */}

                        <label className="p-4 text-2xl" htmlFor="name">Nome</label>
                        {/* Rótulo do campo Nome:
                            - `p-4`: Padding interno.
                            - `text-2xl`: Tamanho do texto grande.
                            - `htmlFor="name"`: Relaciona o rótulo ao campo com o ID `name`. */}

                        <input
                            className="p-3 rounded-xl text-center"
                            type="text"
                            id="name"
                            value={name}
                            onChange={(e) => setName(e.target.value)}
                            placeholder="Insira seu nome aqui"
                        />
                        {/* Campo de entrada do Nome:
                            - `p-3`: Padding interno.
                            - `rounded-xl`: Bordas arredondadas.
                            - `text-center`: Centraliza o texto dentro do campo.
                            - `value={name}`: Liga o valor do campo ao estado `name`.
                            - `onChange`: Atualiza o estado ao digitar. */}
                    </div>

                    <div className="flex flex-col xl:flex-row w-full bg-verde1 p-6 rounded-2xl">
                        {/* Campo da Mensagem com estrutura semelhante ao campo Nome. */}

                        <label className="p-4 text-2xl" htmlFor="mensagem">Mensagem</label>
                        <input
                            className="p-3 rounded-xl text-center"
                            type="text"
                            id="mensagem"
                            value={mensagem}
                            onChange={(e) => setMensagem(e.target.value)}
                            maxLength="300"
                            placeholder="Insira sua mensagem aqui"
                        />
                        {/* Campo de entrada da Mensagem:
                            - Limita o texto a 300 caracteres com `maxLength`.
                            - Placeholder personalizado. */}
                    </div>

                    <button className="m-auto scale-125 xl:scale-100" type="submit">
                        Enviar
                    </button>
                    {/* Botão de envio:
                        - `m-auto`: Centraliza o botão.
                        - `scale-125`: Aumenta o tamanho em telas padrão.
                        - `xl:scale-100`: Ajusta o tamanho normal em telas grandes.
                        - `type="submit"`: Define o comportamento do botão como envio do formulário. */}
                </div>
            </form>
        </div>
    );
};
