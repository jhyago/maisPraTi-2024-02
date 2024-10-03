class Task {
    constructor(year, month, day, type, description){
        this.year        = year
        this.month       = month
        this.day         = day
        this.type        = type
        this.description = description
    }

    validateData() {
        for (let key in this){
            if(this[key] === undefined || this[key] === ""){
                console.error(`O campo ${key} é obrigatório.`)

                return false
            }

            return true
        }
    }
}

class Database {

    constructor(){
        this.initDatabase()
    }

    initDatabase() {
        const id = localStorage.getItem('id')

        if(id === null){
            localStorage.setItem('id', '0')
        }
    }

    loadTasks() {}

    createTask(task) {
        let id = this.getNextId()
        localStorage.setItem(id, JSON.stringify(task))
        localStorage.setItem('id', id.toString())
    }
    
    removeTask(id){}

    searchTasks(task){}

    getNextId(){
        let currentId = localStorage.getItem('id')
        return parseInt(currentId) + 1
    }
}

const database = new Database()

function registerTask(){
    let year = document.getElementById('year').value
    let month = document.getElementById('month').value
    let day = document.getElementById('day').value
    let type = document.getElementById('type').value
    let description = document.getElementById('description').value

    let task = new Task(year, month, day, type, description)

    if(task.validateData()){
        database.createTask(task)
        alert('Tarefa criada com sucesso!')
    } else {
        alert('Preencha todos os campos.')
    }
}