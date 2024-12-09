public class ExemplosDeConstrutores {

    // 1. Construtor padrão (default)
    // Este construtor é automaticamente fornecido pelo compilador se nenhum outro construtor for definido
    public ExemplosDeConstrutores() {
        System.out.println("Construtor padrão chamado.");
    }

    // 2. Construtor parametrizado
    // Recebe argumentos para inicializar os atributos da classe
    private String nome;
    private int idade;

    public ExemplosDeConstrutores(String nome, int idade) {
        this.nome = nome; // Inicializa o atributo 'nome' com o valor do argumento
        this.idade = idade; // Inicializa o atributo 'idade' com o valor do argumento
        System.out.println("Construtor parametrizado chamado: Nome = " + nome + ", Idade = " + idade);
    }

    // 3. Construtor sobrecarregado
    // Várias versões do construtor com diferentes listas de parâmetros
    public ExemplosDeConstrutores(String nome) {
        this(nome, 0); // Chama outro construtor da mesma classe usando `this`
        System.out.println("Construtor sobrecarregado chamado com apenas o nome: Nome = " + nome);
    }

    // 4. Construtor de cópia
    // Cria uma nova instância copiando os valores de outra instância
    public ExemplosDeConstrutores(ExemplosDeConstrutores outro) {
        this.nome = outro.nome;
        this.idade = outro.idade;
        System.out.println("Construtor de cópia chamado: Nome = " + nome + ", Idade = " + idade);
    }

    // 5. Construtor privado
    // Não pode ser acessado fora da classe, útil em padrões como Singleton
    private ExemplosDeConstrutores(boolean flag) {
        System.out.println("Construtor privado chamado. Flag = " + flag);
    }

    // Método estático para criar instância com construtor privado (padrão Singleton)
    public static ExemplosDeConstrutores criarInstancia() {
        return new ExemplosDeConstrutores(true);
    }

    // Método para exibir os atributos da instância
    public void exibirDados() {
        System.out.println("Nome: " + nome + ", Idade: " + idade);
    }

    // Método principal para demonstrar os exemplos
    public static void main(String[] args) {
        // 1. Construtor padrão
        ExemplosDeConstrutores exemplo1 = new ExemplosDeConstrutores();

        // 2. Construtor parametrizado
        ExemplosDeConstrutores exemplo2 = new ExemplosDeConstrutores("João", 25);

        // 3. Construtor sobrecarregado
        ExemplosDeConstrutores exemplo3 = new ExemplosDeConstrutores("Maria");

        // 4. Construtor de cópia
        ExemplosDeConstrutores exemplo4 = new ExemplosDeConstrutores(exemplo2);

        // 5. Construtor privado (acessado por método estático)
        ExemplosDeConstrutores exemplo5 = ExemplosDeConstrutores.criarInstancia();

        // Exibindo os dados das instâncias criadas
        exemplo2.exibirDados();
        exemplo3.exibirDados();
        exemplo4.exibirDados();
    }
}