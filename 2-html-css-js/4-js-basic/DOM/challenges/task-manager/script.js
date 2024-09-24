let taskList   = document.getElementById('task-list')
// Obtém o elemento da lista de tarefas onde as tarefas serão adicionadas

let taskInput  = document.getElementById('task-input')
// Obtém o campo de entrada onde o usuário digita a nova tarefa

let addTaskBtn = document.getElementById('add-task-btn')
// Obtém o botão que o usuário clica para adicionar uma nova tarefa

let filters = document.querySelectorAll('.filter-btn')
// Obtém todos os botões de filtro (para filtrar tarefas completadas e não completadas)

addTaskBtn.addEventListener('click', () => {
    // Adiciona um evento ao botão de adicionar tarefa, que será acionado ao clicar
    let taskText = taskInput.value.trim();
    // Obtém o valor da tarefa digitada no input e remove espaços desnecessários

    if(taskText) {
        // Verifica se o texto da tarefa não está vazio
        let li = createTaskElement(taskText);
        // Cria um novo item da lista (li) para a tarefa

        taskList.appendChild(li);
        // Adiciona o item da lista (li) à lista de tarefas (ul)

        taskInput.value = '';
        // Limpa o campo de entrada após a tarefa ser adicionada
    }
})

function createTaskElement(text) {
    // Função que cria um novo item de lista para a tarefa
    let li = document.createElement('li');
    // Cria um novo elemento 'li' (item de lista)

    li.textContent = text;
    // Define o conteúdo de texto do 'li' como o texto da tarefa

    let removeBtn = document.createElement('span');
    // Cria um botão de remover (um elemento 'span')

    removeBtn.textContent = 'Remover';
    // Define o texto do botão de remover

    removeBtn.classList.add('remove-btn');
    // Adiciona a classe 'remove-btn' para estilização

    removeBtn.addEventListener('click', () => li.remove());
    // Adiciona um evento para remover a tarefa quando o botão de remover for clicado

    li.appendChild(removeBtn);
    // Adiciona o botão de remover ao item da lista (li)

    let editBtn = document.createElement('span');
    // Cria um botão de editar (um elemento 'span')

    editBtn.textContent = 'Editar';
    // Define o texto do botão de editar

    editBtn.classList.add('edit-btn');
    // Adiciona a classe 'edit-btn' para estilização

    editBtn.addEventListener('click', () => editTask(li));
    // Adiciona um evento ao botão de editar, chamando a função editTask ao ser clicado

    li.appendChild(editBtn);
    // Adiciona o botão de editar ao item da lista (li)

    li.addEventListener('click', () => {
        // Adiciona um evento de clique ao item da lista (li)
        if(!li.classList.contains('editing')){
            // Verifica se o item da lista não está no modo de edição
            li.classList.toggle('completed');
            // Alterna a classe 'completed', que marca a tarefa como completada ou não
        }
    })

    return li;
    // Retorna o item da lista criado
}

function editTask(li) {
    // Função que permite editar uma tarefa
    if(!li.classList.contains('editing')){
        // Verifica se o item da lista não está no modo de edição
        li.classList.add('editing');
        // Adiciona a classe 'editing' para indicar que a tarefa está sendo editada

        let input = document.createElement('input');
        // Cria um campo de entrada (input) para editar a tarefa

        input.type = 'text';
        // Define o tipo do input como 'text'

        input.value = li.firstChild.textContent;
        // Define o valor inicial do input como o texto atual da tarefa

        li.firstChild.replaceWith(input);
        // Substitui o texto da tarefa pelo campo de input

        input.addEventListener('blur', () => {
            // Adiciona um evento que será acionado quando o input perder o foco
            li.classList.remove('editing');
            // Remove a classe 'editing', indicando que a edição terminou

            let newText = input.value.trim();
            // Obtém o novo texto digitado no input e remove espaços desnecessários

            if(newText) {
                // Se o novo texto não estiver vazio
                input.replaceWith(document.createTextNode(newText));
                // Substitui o input pelo novo texto
            } else {
                li.remove();
                // Se o novo texto estiver vazio, remove a tarefa
            }
        })

        input.focus();
        // Coloca o foco no input, permitindo ao usuário digitar imediatamente
    }
}

filters.forEach(filter => {
    // Para cada botão de filtro
    filter.addEventListener('click', () => {
        // Adiciona um evento de clique a cada botão de filtro
        filters.forEach(f => f.classList.remove('active-filter'));
        // Remove a classe 'active-filter' de todos os filtros, para desmarcar o filtro anterior

        filter.classList.add('active-filter');
        // Adiciona a classe 'active-filter' ao filtro que foi clicado, marcando-o como ativo

        let filterType = filter.id;
        // Obtém o tipo de filtro (id do botão de filtro)

        let allTasks = taskList.querySelectorAll('li');
        // Obtém todas as tarefas da lista (elementos 'li')

        allTasks.forEach(task => {
            // Para cada tarefa
            switch(filterType) {
                case 'filter-all':
                    // Se o filtro for para mostrar todas as tarefas
                    task.style.display = '';
                    // Mostra todas as tarefas
                    break;
                case 'filter-completed':
                    // Se o filtro for para mostrar apenas as tarefas completadas
                    task.style.display = task.classList.contains('completed') ? '' : 'none';
                    // Exibe apenas as tarefas com a classe 'completed'
                    break;
                case 'filter-not-completed':
                    // Se o filtro for para mostrar apenas as tarefas não completadas
                    task.style.display = task.classList.contains('completed') ? 'none' : '';
                    // Exibe apenas as tarefas que não têm a classe 'completed'
                    break;
            }
        })
    })
})