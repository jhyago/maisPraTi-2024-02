const Button = ({ onClick, children }) => {
    <button onClick={onClick} data-testid='button'>
        { children }
    </button>
}

export default Button