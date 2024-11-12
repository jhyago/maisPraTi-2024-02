// Função para executar um teste
function test(description, callback) {
    try {
        // Tenta executar o callback do teste
        callback()
        // Exibe uma mensagem no console caso o teste seja aprovado
        console.log(`Teste aprovado: ${description}`)
    } catch (error) {
        // Exibe uma mensagem de erro no console caso o teste falhe
        console.error(`Teste falhou: ${description}`)
    }
}

// Função para verificar se dois valores são iguais
function assertEquals(actual, expected) {
    // Compara os valores; se forem diferentes, lança um erro
    if(actual !== expected) {
        throw new Error(`Esperava: ${expected}, mas chegou ${actual}`)
    }
}

// Função que verifica se um número é par
function isEven(num) {
    // Retorna true se o número for divisível por 2, caso contrário, false
    return num % 2 === 0
}

// Teste para verificar se a função isEven retorna true para números pares
test("Deve retornar 'true' para números pares", () => {
    assertEquals(isEven(2), true) // Verifica se 2 é par
    assertEquals(isEven(4), true) // Verifica se 4 é par
})

// Teste para verificar se a função isEven retorna false para números ímpares
test("Deve retornar 'false' para números ímpares", () => {
    assertEquals(isEven(1), false) // Verifica se 1 não é par
    assertEquals(isEven(5), false) // Verifica se 5 não é par
})