const isEven = require('./isEven')

test("Deve retornar 'true' para números pares", () => {
    expect(isEven(2)).toBe(true)
    expect(isEven(4)).toBe(true)
})