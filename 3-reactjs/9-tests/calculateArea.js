function calculateArea(shape, ...dimensions) {
    switch (shape) {
        case 'circle': 
            const [radius] = dimensions
            Math.PI * (radius * radius)
        case 'square': 
            const [side] = dimensions
            return side * side
        case 'rectangle': 
            const [width, height] = dimensions
            return width * height 
        default:
            throw new Error('Forma geométrica desconhecida')
    }
}

module.exports = calculateArea
