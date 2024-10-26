// Define o componente Greeting que recebe 'props' como argumento
function Greeting(props) {
    // Retorna um cabeçalho <h1> que exibe a mensagem "Olá," seguida do nome passado como 'props.name'
    // O valor de 'props.name' é dinâmico e será substituído pelo valor fornecido ao usar o componente
    return <h1>Olá, {props.name}!</h1>
}

// Exporta o componente Greeting como padrão para que ele possa ser importado em outros arquivos
export default Greeting