export const Reviews = () => {
    return (
        <div className="p-6">
            {/* Contêiner principal:
                - `p-6`: Adiciona padding interno de 6 unidades. */}
            
            <h1 className="text-preto font-bold">Mural de recados</h1>
            {/* Título:
                - `text-preto`: Define a cor do texto como preto.
                - `font-bold`: Aplica negrito. */}
    
            <p>Deixe aqui seu recado para a autora</p>
            {/* Subtítulo para instruções. */}
    
            <div className="flex flex-col sm:flex-row justify-center items-center gap-4 m-0 p-4">
                {/* Contêiner do formulário:
                    - `flex flex-col`: Organização vertical no padrão.
                    - `sm:flex-row`: Organização horizontal em telas pequenas.
                    - `justify-center`: Centraliza os itens horizontalmente.
                    - `items-center`: Centraliza os itens verticalmente.
                    - `gap-4`: Espaçamento entre os itens.
                    - `m-0`: Margem zerada.
                    - `p-4`: Padding interno de 4 unidades. */}
    
                <input
                    className="p-3 m-0 rounded-lg text-branco"
                    type="text"
                    value={newName}
                    placeholder="Seu nome..."
                    maxLength="30"
                    onChange={(e) => setNewName(e.target.value)}
                />
                {/* Campo de entrada para o nome:
                    - `p-3`: Padding interno.
                    - `m-0`: Margem zerada.
                    - `rounded-lg`: Bordas arredondadas.
                    - `text-branco`: Define a cor do texto como branco.
                    - `placeholder`: Texto de instrução.
                    - `maxLength="30"`: Limita a entrada a 30 caracteres.
                    - `onChange`: Atualiza o estado `newName` ao digitar. */}
    
                <input
                    className="p-3 m-0 rounded-lg text-branco"
                    type="text"
                    value={newReview}
                    placeholder="Escreva aqui seu recado..."
                    maxLength="60"
                    onChange={(e) => setNewReview(e.target.value)}
                />
                {/* Campo de entrada para o recado:
                    - Estrutura semelhante ao campo de nome, mas com `maxLength="60"`. */}
    
                <button className="text-branco m-0" onClick={addReview}>
                    {editIndex !== null
                        ? "Atualizar Recado"
                        : "Adicionar Recado"}
                </button>
                {/* Botão para adicionar ou atualizar recado:
                    - `text-branco`: Texto branco.
                    - `m-0`: Margem zerada.
                    - `onClick={addReview}`: Chama a função de adicionar ou atualizar recado.
                    - Exibe texto dinâmico com base em `editIndex`. */}
            </div>
    
            <ul className="grid items-center justify-center m-auto grid-cols-1 gap-12 p-8 sm:gap-6 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 2xl:w-2/3">
                {/* Lista de recados:
                    - `grid`: Usa grid layout para organizar os itens.
                    - `items-center`: Centraliza os itens verticalmente.
                    - `justify-center`: Centraliza os itens horizontalmente.
                    - `m-auto`: Centraliza a lista.
                    - `grid-cols-1`: Uma coluna no padrão.
                    - `gap-12`: Espaçamento entre os itens no padrão.
                    - `sm:grid-cols-2`: Duas colunas em telas pequenas.
                    - `lg:grid-cols-3`: Três colunas em telas grandes.
                    - `xl:grid-cols-4`: Quatro colunas em telas muito grandes.
                    - `2xl:w-2/3`: Largura de 2/3 da tela em telas muito grandes. */}
    
                {reviews.map((review, index) => (
                    <li className="relative" key={index}>
                        {/* Item de recado:
                            - `relative`: Posicionamento relativo para facilitar a sobreposição de botões.
                            - `key={index}`: Cada item precisa de uma chave única. */}
    
                        <div className="absolute inset-0 flex justify-center items-center text-branco opacity-0 hover:opacity-100 transition-opacity transition-color rounded-2xl hover:backdrop-blur-sm hover:bg-preto/20">
                            {/* Contêiner de botões sobrepostos:
                                - `absolute`: Posiciona sobre o item.
                                - `inset-0`: Expande o contêiner para cobrir todo o item.
                                - `flex`: Organiza os botões em linha.
                                - `justify-center`: Centraliza horizontalmente.
                                - `items-center`: Centraliza verticalmente.
                                - `text-branco`: Texto branco.
                                - `opacity-0 hover:opacity-100`: Transição de opacidade ao passar o mouse.
                                - `hover:backdrop-blur-sm`: Aplica desfoque no fundo ao passar o mouse.
                                - `hover:bg-preto/20`: Adiciona um fundo preto translúcido no hover. */}
    
                            <button
                                className="p-4 mx-2 bg-verde2 hover:bg-preto"
                                onClick={() => editReview(index)}
                            >
                                <FaEdit />
                            </button>
                            {/* Botão para editar recado:
                                - `p-4`: Padding interno.
                                - `mx-2`: Margem horizontal.
                                - `bg-verde2`: Fundo verde escuro.
                                - `hover:bg-preto`: Muda o fundo para preto no hover.
                                - `onClick`: Chama a função `editReview` passando o índice do recado. */}
    
                            <button
                                className="p-4 mx-2"
                                onClick={() => deleteReview(index)}
                            >
                                <FaTrash />
                            </button>
                            {/* Botão para deletar recado:
                                - Estrutura semelhante ao botão de edição, mas chama `deleteReview`. */}
                        </div>
    
                        <div className="max-w-80 w-fit h-fit m-auto bg-creme1 dark:bg-verde2 dark:text-branco text-2xl p-12 rounded-xl">
                            {/* Contêiner do conteúdo do recado:
                                - `max-w-80`: Largura máxima.
                                - `w-fit h-fit`: Largura e altura ajustadas ao conteúdo.
                                - `m-auto`: Centraliza o contêiner.
                                - `bg-creme1`: Fundo creme no modo claro.
                                - `dark:bg-verde2`: Fundo verde no modo escuro.
                                - `dark:text-branco`: Texto branco no modo escuro.
                                - `text-2xl`: Tamanho grande do texto.
                                - `p-12`: Padding interno.
                                - `rounded-xl`: Bordas arredondadas. */}
    
                            <strong>{review.name}:</strong> {review.text}
                            {/* Exibe o nome e a mensagem do recado. */}
                        </div>
                    </li>
                ))}
            </ul>
        </div>
    );    
}