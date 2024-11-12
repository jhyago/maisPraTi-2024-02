import { render, screen, fireEvent } from '@testing-library/react'
import Button from './Button'

describe('Componente de botão:', () => {
    it('Deve renderizar o texto corretamente', () => {
        render(<Button>Click Me</Button>)
        const buttonElement = screen.getByText(/Click Me/i)
        expect(buttonElement).toBeInTheDocument()
    })

    it('Deve chamar a função onClick quando clicado', () => {
        const handleClick = vi.fn()
        render(<Button onClick={handleClick}>Click Me</Button>)

        const buttonElement = screen.getByTestId('button')
        fireEvent.click(buttonElement)

        expect(handleClick).toHaveBeenCalledTimes(1)
    })
})