// Importa a função calculateArea para ser testada
const calculateArea = require('./calculateArea')

// Agrupa os testes para a função calculateArea
describe("Testes para a função calculateArea", () => {

    // Subgrupo de testes para cálculos de área de um círculo
    describe("Testes da área de um círculo", () => {
        // Testa o cálculo da área de um círculo com raio 2
        test("Deve retornar a área correta para um círculo de raio 2", () => {
            const result = calculateArea('circle', 2) // Chama a função com a forma 'circle' e o raio 2
            expect(result).toBeCloseTo(12.5663, 2) // Verifica se o resultado está próximo a 12.5663 (2 casas decimais de precisão)
        })

        // Teste comentado que verifica a ausência do raio. Pode ser ajustado dependendo da necessidade.
        // test("Deve lançar um erro se o raio não for fornecido", () => {
        //     expect(() => calculateArea('circle')).toThrow("Forma geométrica desconhecida")
        // })
    })

    // Subgrupo de testes para cálculos de área de um quadrado
    describe("Cálculo da área de um quadrado", () => {
        // Testa o cálculo da área de um quadrado com lado 4
        test("Deve retornar a área correta para um quadrado com 4 lados", () => {
            const result = calculateArea('square', 4) // Chama a função com a forma 'square' e o lado 4
            expect(result).toBe(16) // Verifica se o resultado é 16
        })
    })

    // Subgrupo de testes para cálculos de área de um retângulo
    describe("Cálculo da área de um retângulo", () => {
        // Testa o cálculo da área de um retângulo com largura 4 e altura 5
        test("Deve retornar a área correta para um retângulo com largura 4 e altura 5", () => {
            const result = calculateArea('rectangle', 4, 5) // Chama a função com 'rectangle', largura 4 e altura 5
            expect(result).toBe(20) // Verifica se o resultado é 20
        })

        // Testa se um erro é lançado ao usar uma forma geométrica desconhecida
        test("Deve lançar um erro para forma desconhecida", () => {
            expect(() => calculateArea('triangle', 4, 5)).toThrow("Forma geométrica desconhecida")
        })
    })
})