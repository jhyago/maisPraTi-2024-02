import axios from 'axios'
import { useState, useEffect } from 'react'
import { CardsProdutos } from './CardsProdutos'

export const OndeComprar = () => {
    const [produtos, setProdutos] = useState([])
    const [error, setError] = useState(null)
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        axios.get("https://my-json-server.typicode.com/leomaciel14/JSON-Server/produtos").then(
            response => {
                setProdutos(response.data)
                setLoading(false)
            }).catch(error => {
                console.error("Houve um erro ao buscar os produtos")
                setError("Não foi possível recuperar os dados dos produtos")
                setLoading(false)
            })
    }, [])

    return (
        <div id="kits">
            {/* Contêiner principal com um ID único "kits" para facilitar o acesso, por exemplo, com âncoras de links. */}
            
            <h1>Escolha seu Kit</h1>
            {/* Título da seção. Pode ser estilizado com classes adicionais, se necessário. */}
    
            {loading ? (
                // Verifica se o estado `loading` está ativo.
                <div className="flex justify-center items-center">
                    {/* Contêiner centralizado com Flexbox para exibir o loader. */}
                    
                    <div className="loader ease-linear rounded-full border-8 border-t-8 h-20 w-20"></div>
                    {/* Loader animado:
                        - `ease-linear`: Animação linear.
                        - `rounded-full`: Loader circular.
                        - `border-8 border-t-8`: Define largura da borda.
                        - `h-20 w-20`: Altura e largura fixas de 20 unidades. */}
                </div>
            ) : error ? (
                // Se `loading` for falso e houver um erro (`error`), exibe a mensagem de erro.
                <div className="text-red-500 text-xl">
                    {error}
                </div>
                /* Mensagem de erro estilizada:
                    - `text-red-500`: Texto vermelho para indicar erro.
                    - `text-xl`: Texto em tamanho grande. */
            ) : (
                // Caso não esteja carregando e não haja erro, exibe os produtos.
                <div className="grid grid-cols-1 gap-12 p-8 sm:gap-6 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 text-2xl sm:text-base xl:text-xl">
                    {/* Contêiner dos produtos com layout de grade:
                        - `grid grid-cols-1`: Uma coluna padrão.
                        - `gap-12`: Espaçamento entre os itens.
                        - `p-8`: Espaçamento interno.
                        - Breakpoints para colunas variáveis:
                            - `sm:grid-cols-2`: 2 colunas em telas pequenas.
                            - `lg:grid-cols-3`: 3 colunas em telas grandes.
                            - `xl:grid-cols-4`: 4 colunas em telas muito grandes. */}
                    
                    {produtos.map((produto) => (
                        <CardsProdutos key={produto.id} produto={produto} />
                        // Renderiza o componente `CardsProdutos` para cada item do array `produtos`.
                        // `key={produto.id}`: Cada produto precisa de uma chave única para melhor performance do React.
                        // `produto={produto}`: Passa os dados de cada produto como props para o componente. 
                    ))}
                </div>
            )}
        </div>
    );
}