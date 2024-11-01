import { useState, useEffect } from 'react' // Importa os hooks useState e useEffect do React para gerenciar o estado e efeitos colaterais.

function Timer() { // Declara um componente funcional chamado Timer.
    const [seconds, setSeconds] = useState(0) // Cria uma variável de estado chamada "seconds", inicializada como 0, e "setSeconds" para atualizá-la.

    useEffect(() => { // useEffect é usado para executar código que possui efeitos colaterais, como definir intervalos de tempo.
        const interval = setInterval(() => { // Define um intervalo que executa uma função a cada 1000 milissegundos (1 segundo).
            setSeconds(prevSeconds => prevSeconds + 1) // Atualiza o estado "seconds" adicionando 1 ao valor anterior a cada segundo.
        }, 1000) // Tempo de intervalo de 1 segundo.

        return () => clearInterval(interval) // Retorna uma função de limpeza que é executada quando o componente é desmontado, para limpar o intervalo e evitar vazamentos de memória.
    }, []) // A lista de dependências vazia faz com que o useEffect seja executado apenas uma vez, ao montar o componente.

    return ( // Início da estrutura de retorno do JSX.
        <div>Segundos: {seconds}</div> // Exibe o valor atual de "seconds" em uma div.
    )
}

export default Timer // Exporta o componente Timer para que possa ser importado e usado em outros arquivos.