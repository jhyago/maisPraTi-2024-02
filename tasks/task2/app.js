// =====================================================
// 1. Acessando Propriedades de Objetos (Carro)
// =====================================================
const carro = {
    marca: 'Toyota',
    modelo: 'Corolla',
    ano: 2020,
    cor: 'Prata'
};

for (let propriedade in carro) {
    console.log(`${propriedade}: ${carro[propriedade]}`);
}

// =====================================================
// 2. Verificando Propriedades (Livro)
// =====================================================
const livro = {
    titulo: 'O Senhor dos Anéis',
    autor: 'J.R.R. Tolkien',
    anoPublicacao: 1954,
    genero: 'Fantasia'
};

for (let propriedade in livro) {
    if (!livro.hasOwnProperty('editora')) {
        livro.editora = 'HarperCollins';
    }
}
console.log(livro);

// =====================================================
// 3. Filtrando Propriedades de Objetos (Produto)
// =====================================================
const produto = {
    nome: 'Celular',
    preco: 1200,
    desconto: 100,
    garantia: 24
};

function filtrarPropriedades(obj, valorMinimo) {
    let novoObjeto = {};
    for (let propriedade in obj) {
        if (obj[propriedade] > valorMinimo) {
            novoObjeto[propriedade] = obj[propriedade];
        }
    }
    return novoObjeto;
}

console.log(filtrarPropriedades(produto, 200));

// =====================================================
// 4. Iterando Sobre Arrays de Objetos (Pessoas)
// =====================================================
const pessoas = [
    { nome: 'João', idade: 25, cidade: 'São Paulo' },
    { nome: 'Maria', idade: 30, cidade: 'Rio de Janeiro' },
    { nome: 'Pedro', idade: 22, cidade: 'Belo Horizonte' }
];

for (let pessoa of pessoas) {
    console.log(`${pessoa.nome}, ${pessoa.idade} anos, mora em ${pessoa.cidade}`);
}

// =====================================================
// 5. Calculando Valores em Arrays de Objetos (Alunos)
// =====================================================
const alunos = [
    { nome: 'Ana', nota1: 8, nota2: 9 },
    { nome: 'Carlos', nota1: 7, nota2: 6 },
    { nome: 'Fernanda', nota1: 9, nota2: 10 }
];

for (let aluno of alunos) {
    let media = (aluno.nota1 + aluno.nota2) / 2;
    console.log(`${aluno.nome} - Média: ${media}`);
}

// =====================================================
// 6. Filtrando Arrays de Objetos (Funcionários)
// =====================================================
const funcionarios = [
    { nome: 'Paulo', cargo: 'Gerente', salario: 5000 },
    { nome: 'Lucas', cargo: 'Assistente', salario: 2500 },
    { nome: 'Mariana', cargo: 'Diretora', salario: 10000 }
];

const salarioMinimo = 3000;
for (let funcionario of funcionarios) {
    if (funcionario.salario > salarioMinimo) {
        console.log(`${funcionario.nome} - ${funcionario.salario}`);
    }
}

// =====================================================
// 7. Modificando Objetos em um Array (Produtos)
// =====================================================
const produtos = [
    { nome: 'Notebook', preco: 3000, desconto: 0 },
    { nome: 'Mouse', preco: 150, desconto: 0 },
    { nome: 'Teclado', preco: 200, desconto: 0 }
];

produtos.forEach(produto => {
    produto.preco = produto.preco * 0.9;  // Aplicando 10% de desconto
    console.log(`${produto.nome} - Novo preço: R$${produto.preco.toFixed(2)}`);
});

// =====================================================
// 8. Criando Novos Arrays a Partir de Objetos (Filmes)
// =====================================================
const filmes = [
    { titulo: 'Inception', diretor: 'Christopher Nolan', anoLancamento: 2010 },
    { titulo: 'Matrix', diretor: 'Wachowski', anoLancamento: 1999 },
    { titulo: 'O Senhor dos Anéis', diretor: 'Peter Jackson', anoLancamento: 2001 }
];

const titulos = [];
filmes.forEach(filme => {
    titulos.push(filme.titulo);
});
console.log(titulos);

// =====================================================
// 9. Contabilizando Elementos com uma Condição (Clientes)
// =====================================================
const clientes = [
    { nome: 'Rafael', idade: 35, cidade: 'Curitiba' },
    { nome: 'Letícia', idade: 28, cidade: 'Fortaleza' },
    { nome: 'Gabriel', idade: 42, cidade: 'Salvador' }
];

let contador = 0;
clientes.forEach(cliente => {
    if (cliente.idade > 30) {
        contador++;
    }
});
console.log(`Clientes com mais de 30 anos: ${contador}`);

// =====================================================
// 10. Criando Relatórios com Objetos e Arrays (Vendas)
// =====================================================
const vendas = [
    { produto: 'TV', quantidade: 2, valor: 2000 },
    { produto: 'Geladeira', quantidade: 1, valor: 3000 },
    { produto: 'Fogão', quantidade: 3, valor: 1200 }
];

let totalVendas = 0;
vendas.forEach(venda => {
    totalVendas += venda.quantidade * venda.valor;
});
console.log(`Valor total de vendas: R$${totalVendas}`);

// =====================================================
// 11. Agrupando Elementos com forEach (Pedidos)
// =====================================================
const pedidos = [
    { cliente: 'Ana', produto: 'Cadeira', quantidade: 4 },
    { cliente: 'João', produto: 'Mesa', quantidade: 1 },
    { cliente: 'Ana', produto: 'Sofá', quantidade: 2 }
];

const totalPorCliente = {};
pedidos.forEach(pedido => {
    if (totalPorCliente[pedido.cliente]) {
        totalPorCliente[pedido.cliente] += pedido.quantidade;
    } else {
        totalPorCliente[pedido.cliente] = pedido.quantidade;
    }
});
console.log(totalPorCliente);

// =====================================================
// 12. Atualizando um Array de Objetos (Estoque)
// =====================================================
const estoque = [
    { produto: 'Cadeira', quantidade: 5, minimo: 10 },
    { produto: 'Mesa', quantidade: 3, minimo: 5 },
    { produto: 'Sofá', quantidade: 2, minimo: 2 }
];

estoque.forEach(item => {
    if (item.quantidade < item.minimo) {
        item.quantidade *= 2;  // Duplicando a quantidade
    }
});
console.log(estoque);

// =====================================================
// 13. Implementando um Carrinho de Compras (Carrinho)
// =====================================================
const carrinho = {
    itens: [
        { nome: 'Camiseta', quantidade: 2, precoUnitario: 50 },
        { nome: 'Calça', quantidade: 1, precoUnitario: 100 }
    ]
};

let valorTotalCarrinho = 0;
carrinho.itens.forEach(item => {
    valorTotalCarrinho += item.quantidade * item.precoUnitario;
});
console.log(`Valor total do carrinho: R$${valorTotalCarrinho}`);

// =====================================================
// 14. Manipulando Objetos Complexos (Empresa)
// =====================================================
const empresa = {
    departamentos: [
        {
            nome: 'TI',
            funcionarios: ['Carlos', 'Amanda', 'João']
        },
        {
            nome: 'Marketing',
            funcionarios: ['Mariana', 'Fernanda']
        }
    ]
};

for (let departamento in empresa.departamentos) {
    const dept = empresa.departamentos[departamento];
    for (let funcionario of dept.funcionarios) {
        console.log(`Funcionário: ${funcionario}, Departamento: ${dept.nome}`);
    }
}

// =====================================================
// 15. Filtrando e Somando Valores (Transações)
// =====================================================
const transacoes = [
    { tipo: 'entrada', valor: 1000 },
    { tipo: 'saída', valor: 500 },
    { tipo: 'entrada', valor: 300 },
    { tipo: 'saída', valor: 200 }
];

let saldo = 0;
transacoes.forEach(transacao => {
    if (transacao.tipo === 'entrada') {
        saldo += transacao.valor;
    } else {
        saldo -= transacao.valor;
    }
});
console.log(`Saldo final: R$${saldo}`);