let title = document.getElementById('title')

title.textContent = "Aula de JS básico"

title.innerHTML = "Mudei o conteúdo do título novamente"

title.style.color = "blue"

let button = document.getElementById('button')

button.addEventListener('click', () => {
    alert('Você clicou no botão!')
})

let newParagraph = document.createElement('p')

newParagraph.innerHTML = "Este é um parágrafo criado via JS"

document.body.appendChild(newParagraph)

let paragraph = document.querySelector('.paragraph')

paragraph.remove()