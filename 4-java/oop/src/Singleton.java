public class Singleton {

    // Instância única da classe Singleton (inicialização tardia - lazy initialization)
    private static Singleton instanciaUnica;

    // Construtor privado para impedir que a classe seja instanciada externamente
    private Singleton() {
        System.out.println("Instância única do Singleton criada!");
    }

    /**
     * Método estático para fornecer acesso à única instância do Singleton.
     * Compatível com o Java 17, sem sincronização explícita ou inicialização antecipada.
     *
     * @return a instância única do Singleton.
     */
    public static Singleton getInstancia() {
        if (instanciaUnica == null) { // Verifica se a instância já foi criada
            instanciaUnica = new Singleton(); // Cria a instância única, caso ainda não exista
        }
        return instanciaUnica;
    }

    /**
     * Exemplo de método de instância.
     */
    public void exibirMensagem() {
        System.out.println("Método chamado na instância Singleton!");
    }

    /**
     * Método principal para demonstrar o Singleton.
     */
    public static void main(String[] args) {
        // Obtendo a instância única do Singleton
        Singleton instancia1 = Singleton.getInstancia();
        instancia1.exibirMensagem();

        // Obtendo a instância novamente e verificando se é a mesma
        Singleton instancia2 = Singleton.getInstancia();
        instancia2.exibirMensagem();

        // Verificando se as duas referências apontam para a mesma instância
        System.out.println("As instâncias são iguais? " + (instancia1 == instancia2));
    }
}