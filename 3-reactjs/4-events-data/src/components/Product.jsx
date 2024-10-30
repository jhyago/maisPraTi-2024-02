import { useState } from 'react'  // Importa o hook useState do React para gerenciar estados locais do componente

function Product() {  // Define o componente funcional Product

    // Declara estados para armazenar o nome, preço, categoria e descrição de um novo produto
    const [productName, setProductName] = useState('')  
    const [price, setPrice] = useState('')  
    const [category, setCategory] = useState('Eletrônicos')  // Inicializa o estado da categoria com 'Eletrônicos' como valor padrão
    const [description, setDescription] = useState('')  

    // Declara estado 'products' para armazenar a lista de produtos e 'error' para mensagens de erro
    const [products, setProducts] = useState([])  
    const [error, setError] = useState('')  
    
    const [categoryFilter, setCategoryFilter] = useState('Todos')  // Estado para gerenciar o filtro de categoria, com 'Todos' como padrão

    // Funções para atualizar cada campo do formulário com o valor inserido pelo usuário
    const handleNameChange        = (event) => setProductName(event.target.value)
    const handlePriceChange       = (event) => setPrice(event.target.value)
    const handleCategoryChange    = (event) => setCategory(event.target.value)
    const handleDescriptionChange = (event) => setDescription(event.target.value)

    const handleAddProduct = (event) => {  // Função para adicionar um novo produto à lista
        event.preventDefault()  // Previne o comportamento padrão do formulário de recarregar a página

        // Verifica se todos os campos obrigatórios estão preenchidos
        if(!productName || !price || !description) {
            setError('Por favor, preencha todos os campos!')  // Exibe uma mensagem de erro se algum campo estiver vazio
            return
        }

        // Verifica se o preço é um número positivo
        if(isNaN(price) || Number(price) <= 0){
            setError('O preço deve ser um valor positivo.')  // Exibe um erro se o preço for inválido
            return
        }

        setError('')  // Limpa o erro caso os campos estejam preenchidos corretamente

        // Cria um novo objeto produto com as informações preenchidas
        const newProduct = {
            id: Date.now(),  // Usa a data/hora atual como ID único do produto
            name: productName,
            price: parseFloat(price).toFixed(2),  // Converte o preço para um número com duas casas decimais
            category,
            description
        }

        setProducts([...products, newProduct])  // Adiciona o novo produto à lista de produtos

        // Limpa os campos do formulário
        setDescription('')
        setPrice('')
        setProductName('')
    }

    const handleRemoveProduct = (id) => {  // Função para remover um produto da lista usando o ID
        setProducts(products.filter((product) => product.id !== id))  // Filtra a lista para excluir o produto com o ID correspondente
    }

    // Filtra os produtos com base na categoria selecionada
    const filteredProducts = products.filter((product) => categoryFilter === 'Todos' || product.category === categoryFilter)

    return (  // Renderiza o conteúdo do componente
        <div>
            <h1>Cadastro de Produto</h1>
            {error && <p style={{ color: 'red' }}>{error}</p>}  

            {/* Formulário para adicionar um novo produto */}
            <form onSubmit={handleAddProduct}>
                <label>
                    Nome do Produto:
                    <input 
                        type="text"
                        value={productName}
                        onChange={handleNameChange}  // Atualiza o valor de 'productName' conforme o usuário digita
                    />
                </label>
                <br />
                <label>
                    Preço:
                    <input 
                        type="text"
                        value={price}
                        onChange={handlePriceChange}  // Atualiza o valor de 'price' conforme o usuário digita
                    />
                </label>
                <br />
                <label>
                    Categoria:
                    <select value={category} onChange={handleCategoryChange}>  
                        <option value="Eletrônicos">Eletrônicos</option>
                        <option value="Roupas">Roupas</option>
                        <option value="Alimentos">Alimentos</option>
                    </select>
                </label>
                <br />
                <label>
                    Descrição:
                    <textarea 
                        value={description}
                        onChange={handleDescriptionChange}  // Atualiza o valor de 'description' conforme o usuário digita
                    ></textarea>
                </label>
                <br />

                <button type='submit'>Adicionar Produto</button>  
            </form>

            <h2>Lista de Produtos</h2>

            {/* Filtro por categoria */}
            <label>
                Filtrar por Categoria:
                <select value={categoryFilter} onChange={(event) => setCategoryFilter(event.target.value)}>
                    <option value="Todos">Todos</option>
                    <option value="Eletrônicos">Eletrônicos</option>
                    <option value="Roupas">Roupas</option>
                    <option value="Alimentos">Alimentos</option>
                </select>
            </label>

            <ul>
                {/* Renderiza a lista de produtos filtrados */}
                {filteredProducts.map((product) => (
                    <li key={product.id}>
                        <strong>{product.name}</strong> - ${product.price} = {product.category}
                        <p>{product.description}</p>
                        <button onClick={() => handleRemoveProduct(product.id)}>Remover</button>  
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default Product  // Exporta o componente Product para ser utilizado em outros arquivos
