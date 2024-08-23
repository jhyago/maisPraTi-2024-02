// Objeto 'serie' com propriedades e um método
let serie = {
    nome: "The Boys",
    genero: ["Ação", "Paródia", "Heróis"],
    nrTemporadas: 4,
    status: "Em andamento",
    classificao: 18,
    nrEpisodios: {
        temp1: 10,
        temp2: 10,
        temp3: 50
    },
    mostrarCaracteristicas: function() {
        return `O nome da série é: ${this.nome} e sua classificação é +${this.classificao}`;
    }
};

// console.log(serie.mostrarCaracteristicas())

// Objeto 'livro' com propriedades e um método
let livro = {
    titulo: "O Hobbit",
    autor: "J. R. R. Tolkien",
    year: 1925,
    mostrarCaracteristicas: function() {
        return `${this.titulo} foi escrito por ${this.autor}`;
    }
};

// console.log(livro.mostrarCaracteristicas())

// Objeto 'carro' com propriedades e um método
let carro = {
    nome: 'Herby',
    modelo: 'Marea',
    velocidadeMaxima: 350,
    ano: 2005,
    acelerar: function() {
        return "Acelerando com pé no porão";
    }
};

// console.log(carro)
// console.log(carro.acelerar())

// Criação de objeto 'moto' usando variáveis existentes
let motor = "1000";
let nome = "bmw s1000rr";
let tipo = "esportiva";

let moto = {
    nome: nome,
    tipo: tipo,
    motor: motor
};

// console.log(moto)

// Objeto 'atleta' com propriedades, adicionando novas propriedades e métodos
let atleta = {
    nome: "Rayssa Leal",
    esporte: "Skate street",
    idade: 16
};

atleta.nacionalidade = 'Brasil';
atleta.medalhas = {
    ouro: 10,
    prata: 1,
    bronze: 1
};

atleta.celebrarVitoria = function () {
    return "GANHEI!";
};

// console.log(atleta)
// console.log(atleta.celebrarVitoria())

// Clonando um objeto e adicionando uma nova propriedade
let obj1 = {
    nome: "Bruce",
    profissao: "Batman" 
};

let obj2 = obj1;

obj2.companheiro = "Robin";

// console.log(obj1)
// console.log(obj2)

// Função construtora para criar objetos 'computador'
function computador(processador, gpu, ram, armazenamento) {
    this.processador = processador;
    this.gpu = gpu;
    this.ram = ram;  
    this.armazenamento = armazenamento;

    this.ligar = function() {
        console.log(`O ${this.processador} está funcionando!`);
    };

    this.mostrarEspecificacoes = function() {
        return `
            processador: ${this.processador}
            gpu: ${this.gpu}
            ram: ${this.ram}
            armazenamento: ${this.armazenamento}`;
    };
}

let pc = new computador("i9", "RTX4090", "16GB", "500GB SSD");
// console.log(pc.mostrarEspecificacoes())

// Função fábrica para criar objetos 'jogos'
function jogos(titulo, genero, anoLancamento, empresa, jogar) {
    return {
        titulo, 
        genero,
        anoLancamento,
        empresa,
        jogar
    };
}

let jogo1 = jogos("Final Fantasy", "RPG", "1997", "Square Soft", () => { return 'Jogando' });

// console.log(jogo1.jogar())

// Iterando sobre as propriedades de um objeto usando 'for...in'
for(let chave in jogo1) {
    // console.log(`${chave}: ${jogo1[chave]}`)
}

// Iterando sobre elementos de um array multidimensional usando 'for...in'
const jogadores = [['Pelé', 'Romário'], 'CR7', 'Messi'];

for(let key in jogadores) {
    // console.log(jogadores[key])
}

// Iterando sobre os caracteres de uma string usando 'for...of'
const NOME = "Silva";

for(let char of NOME) {
    // console.log(char)
}

// Iterando sobre as chaves de um objeto usando 'for...of' com 'Object.keys'
for(let jogo of Object.keys(jogo1)) {
    // console.log(jogo1[jogo])
}