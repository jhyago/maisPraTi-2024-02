package contaBancaria;

// Classe que representa uma conta bancária
public class ContaBancaria {
    private String numeroConta; // Número único da conta bancária
    private Usuario usuario; // Referência ao usuário dono da conta
    private double saldo; // Saldo atual da conta

    // Construtor da conta bancária, inicializa com saldo zero
    public ContaBancaria(String numeroConta, Usuario usuario) {
        this.numeroConta = numeroConta; // Define o número da conta
        this.usuario = usuario; // Associa o usuário à conta
        this.saldo = 0.0; // Inicializa o saldo da conta como zero
    }

    // Método para realizar depósito na conta
    public void depositar(double valor) {
        if (valor > 0) { // Verifica se o valor do depósito é positivo
            this.saldo += valor; // Adiciona o valor ao saldo da conta
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso."); // Mensagem de confirmação
        } else {
            System.out.println("Valor inválido, precisa ser maior do que zero."); // Mensagem de erro para valores inválidos
        }
    }

    // Método para realizar saque na conta
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) { // Verifica se o valor é positivo e não excede o saldo
            this.saldo -= valor; // Deduz o valor do saldo da conta
            System.out.println("Saque de R$ " + valor + " realizado com sucesso."); // Mensagem de confirmação
        } else if (valor > this.saldo) { // Verifica se o valor excede o saldo disponível
            System.out.println("Saldo insuficiente para o saque!"); // Mensagem de saldo insuficiente
        } else { // Caso o valor seja negativo ou zero
            System.out.println("Valor inválido para saque."); // Mensagem de erro para valores inválidos
        }
    }

    // Método para consultar e exibir o saldo atual da conta
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + this.saldo); // Exibe o saldo formatado
    }

    // Método para imprimir os detalhes da conta
    public void imprimirDetalhes() {
        System.out.println("Conta número: " + this.numeroConta); // Exibe o número da conta
        usuario.imprimirDetalhes(); // Chama o método de exibir detalhes do usuário associado
        consultarSaldo(); // Exibe o saldo atual
    }
}