let taskList   = document.getElementById('task-list')
let taskInput  = document.getElementById('task-input')
let addTaskBtn = document.getElementById('add-task-btn')

let filters = document.querySelectorAll('.filter-btn')

addTaskBtn.addEventListener('click', () =>{
    let taskText = taskInput.value.trim()

    if(taskText) {
        let li = createTaskElement(taskText)

        taskList.appendChild(li)

        taskInput.value = ''
    }
})

function createTaskElement(text) {
    let li = document.createElement('li')

    li.textContent = text

    let removeBtn = document.createElement('span')
    removeBtn.textContent = 'Remover'
    removeBtn.classList.add('remove-btn')

    removeBtn.addEventListener('click', () => li.remove())

    li.appendChild(removeBtn)

    let editBtn = document.createElement('span')
    editBtn.textContent = 'Editar'
    editBtn.classList.add('edit-btn')

    editBtn.addEventListener('click', () => editTask(li))

    li.appendChild(editBtn)

    li.addEventListener('click', () => {
        if(!li.classList.contains('editing')){
            li.classList.toggle('completed')
        }
    })

    return li
}

function editTask(li) {
    if(!li.classList.contains('editing')){
        li.classList.add('editing')

        let input = document.createElement('input')
        input.type = 'text'
        input.value = li.firstChild.textContent

        li.firstChild.replaceWith(input)

        input.addEventListener('blur', () => {
            li.classList.remove('editing')

            let newText = input.value.trim()

            if(newText) {
                input.replaceWith(document.createTextNode(newText))
            } else {
                li.remove()
            }
        })

        input.focus()
    }
}

filters.forEach(filter => {
    filter.addEventListener('click', () => {
        filters.forEach(f => f.classList.remove('active-filter'))
        filter.classList.add('active-filter')

        let filterType = filter.id
        let allTasks = taskList.querySelectorAll('li')

        allTasks.forEach(task => {
            switch(filterType) {
                case 'filter-all':
                    task.style.display = ''
                    break
                case 'filter-completed':
                    task.style.display = task.classList.contains('completed') ? '' : 'none'
                    break
                case 'filter-not-completed':
                    task.style.display = task.classList.contains('completed') ? 'none' : ''
                    break 
            }
        })
    })
})