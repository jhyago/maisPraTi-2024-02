import { useState, useEffect } from 'react' // Importa os hooks useState e useEffect do React, usados para gerenciar estado e efeitos colaterais.

function Counter() { // Declara um componente funcional chamado Counter.
    const [count, setCount] = useState(0) // Declara uma variável de estado chamada "count" inicializada com 0, e "setCount" para atualizar seu valor.

    useEffect(() => { // useEffect permite executar código sempre que o componente for renderizado ou quando variáveis específicas mudam.
        console.log(`O contador mudou para: ${count}`) // Exibe no console uma mensagem com o valor atual do contador sempre que "count" é alterado.
    }, [count]) // A dependência "count" faz com que o useEffect seja executado sempre que "count" mudar.

    return ( // Início da estrutura de retorno do JSX, que define o layout visual do componente.
        <div> {/* Cria uma div que contém o conteúdo do componente. */}
            <p>Contador: {count}</p> {/* Exibe o valor atual de "count" dentro de um parágrafo. */}
            <button onClick={() => setCount(count + 1)}>Incrementar</button> {/* Botão que, ao ser clicado, incrementa "count" em 1 usando "setCount". */}
        </div>
    )
}

export default Counter // Exporta o componente Counter para que possa ser usado em outros arquivos.