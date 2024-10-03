let title = document.getElementById('title');
// Obtém o elemento com o id 'title' (geralmente um título como <h1> ou <h2>)

title.textContent = "Aula de JS básico";
// Altera o conteúdo de texto do elemento 'title' para "Aula de JS básico"
// textContent altera apenas o texto, sem permitir tags HTML

title.innerHTML = "Mudei o conteúdo do título novamente";
// Altera o conteúdo HTML do elemento 'title' para "Mudei o conteúdo do título novamente"
// innerHTML permite usar tags HTML dentro do conteúdo, diferente de textContent

title.style.color = "blue";
// Altera a cor do texto do elemento 'title' para azul, manipulando o estilo CSS diretamente

let button = document.getElementById('button');
// Obtém o elemento com o id 'button' (provavelmente um botão <button>)

button.addEventListener('click', () => {
    // Adiciona um evento de clique ao botão. Quando o botão for clicado, a função anônima será executada
    alert('Você clicou no botão!');
    // Exibe um alerta com a mensagem "Você clicou no botão!" quando o botão for clicado
})

let newParagraph = document.createElement('p');
// Cria um novo elemento <p> (parágrafo) dinamicamente usando JavaScript

newParagraph.innerHTML = "Este é um parágrafo criado via JS";
// Define o conteúdo HTML do novo parágrafo criado com a mensagem "Este é um parágrafo criado via JS"

document.body.appendChild(newParagraph);
// Adiciona o novo parágrafo como o último filho do elemento <body>, inserindo-o na página

let paragraph = document.querySelector('.paragraph');
// Seleciona o primeiro elemento com a classe 'paragraph' na página

paragraph.remove();
// Remove o elemento parágrafo selecionado da página