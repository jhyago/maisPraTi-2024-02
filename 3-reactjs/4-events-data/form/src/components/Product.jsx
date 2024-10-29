import { useState } from 'react'

function Product() {

    return (
        <div>
            <h1>Cadastro de Produto</h1>
            <form onSubmit={handleAddProduct}>
                <label>
                    Nome do Produto:
                    <input 
                        type="text"
                        value={productName}
                        onChange={handleNameChange}
                    />
                </label>
                <br />
                <label>
                    Preço:
                    <input 
                        type="text"
                        value={price}
                        onChange={handlePriceChange}
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
                        onChange={handleDescriptionChange}
                    ></textarea>
                </label>
                <br />

                <button type='submit'>Adicionar Produto</button>
            </form>

            <h2>Filtro de Categoria</h2>
            <label>
                Filtrar por Categoria:
                <select value={categoryFilter} onChange={}>
                    <option value="todos"><Todos></Todos></option>
                    <option value="Eletrônicos">Eletrônicos</option>
                    <option value="Roupas">Roupas</option>
                    <option value="Alimentos">Alimentos</option>
                </select>
            </label>
        </div>
    )
}

export default Product