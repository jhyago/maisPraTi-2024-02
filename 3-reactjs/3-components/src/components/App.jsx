// Define o componente Button que recebe 'props' como argumento
function Button(props) {
  // Retorna um botão com um evento 'onClick' que usa a função passada através de 'props'
  // Quando clicado, o botão executará a função recebida via 'props.onClick'
  return <button onClick={props.onClick}>Clique aqui!</button>
}

// Define o componente principal App
function App() {

  // Declara a função 'handleClick' que será executada quando o botão for clicado
  // Neste caso, exibe um alerta com a mensagem "Botão clicado!"
  const handleClick = () => {
    alert("Botão clicado!")
  }

  // Renderiza o componente App
  // Aqui, o componente Button é utilizado e a função 'handleClick' é passada para ele como a prop 'onClick'
  return (
    <>
      {/* Chama o componente Button e passa a função 'handleClick' como prop */}
      <Button onClick={handleClick}/>
    </>
  )
}

// Exporta o componente App como padrão para que ele possa ser importado em outros arquivos
export default App