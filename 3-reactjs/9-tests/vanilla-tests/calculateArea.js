// Define uma função chamada calculateArea para calcular a área de diferentes formas geométricas
function calculateArea(shape, ...dimensions) {
    // Usa um switch para determinar o cálculo baseado na forma geométrica (shape)
    switch (shape) {
        // Caso a forma seja um círculo
        case 'circle': 
            // Extrai o primeiro valor do array dimensions como o raio
            const [radius] = dimensions
            // Retorna a área do círculo: π * raio^2
            return Math.PI * (radius * radius)

        // Caso a forma seja um quadrado
        case 'square': 
            // Extrai o primeiro valor do array dimensions como o lado do quadrado
            const [side] = dimensions
            // Retorna a área do quadrado: lado * lado
            return side * side

        // Caso a forma seja um retângulo
        case 'rectangle': 
            // Extrai dois valores do array dimensions: largura e altura
            const [width, height] = dimensions
            // Retorna a área do retângulo: largura * altura
            return width * height 

        // Caso nenhuma forma geométrica válida seja fornecida
        default:
            // Lança um erro informando que a forma é desconhecida
            throw new Error('Forma geométrica desconhecida')
    }
}

// Exporta a função para que possa ser usada em outros arquivos
module.exports = calculateArea