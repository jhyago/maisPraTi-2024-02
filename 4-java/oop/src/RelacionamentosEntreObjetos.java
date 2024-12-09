import java.util.ArrayList;
import java.util.List;

/**
 * Demonstração de todos os tipos de relacionamentos entre objetos em Java.
 */
public class RelacionamentosEntreObjetos {

    /**
     * 1. Associação (relacionamento "usa")
     * Uma classe usa outra de forma genérica.
     */
    static class Motorista {
        private String nome;

        public Motorista(String nome) {
            this.nome = nome;
        }

        public void dirigir(Carro carro) {
            System.out.println(nome + " está dirigindo o carro " + carro.getModelo());
        }
    }

    static class Carro {
        private String modelo;

        public Carro(String modelo) {
            this.modelo = modelo;
        }

        public String getModelo() {
            return modelo;
        }
    }

    /**
     * 2. Agregação (relacionamento "tem")
     * Um objeto contém outro como parte de si, mas a parte pode existir independentemente.
     */
    static class Curso {
        private String nome;
        private List<Aluno> alunos; // Curso agrega alunos

        public Curso(String nome) {
            this.nome = nome;
            this.alunos = new ArrayList<>();
        }

        public void adicionarAluno(Aluno aluno) {
            alunos.add(aluno);
            System.out.println(aluno.getNome() + " foi adicionado ao curso " + nome);
        }
    }

    static class Aluno {
        private String nome;

        public Aluno(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }
    }

    /**
     * 3. Composição (relacionamento "é dono de")
     * Um objeto contém outro, mas a parte não pode existir independentemente.
     */
    static class Computador {
        private CPU cpu; // Computador é dono de uma CPU

        public Computador(String modeloCpu) {
            this.cpu = new CPU(modeloCpu);
        }

        public void ligar() {
            System.out.println("Ligando o computador com CPU " + cpu.getModelo());
        }

        // Classe interna para representar a CPU, exclusivamente associada ao Computador
        private static class CPU {
            private String modelo;

            public CPU(String modelo) {
                this.modelo = modelo;
            }

            public String getModelo() {
                return modelo;
            }
        }
    }

    /**
     * 4. Dependência (relacionamento "depende de")
     * Um método em uma classe recebe outro objeto como parâmetro.
     */
    static class Impressora {
        public void imprimir(Documento documento) {
            System.out.println("Imprimindo documento: " + documento.getConteudo());
        }
    }

    static class Documento {
        private String conteudo;

        public Documento(String conteudo) {
            this.conteudo = conteudo;
        }

        public String getConteudo() {
            return conteudo;
        }
    }

    /**
     * Método principal para demonstrar os tipos de relacionamentos.
     */
    public static void main(String[] args) {
        // 1. Associação
        System.out.println("=== Associação ===");
        Carro carro = new Carro("Toyota Corolla");
        Motorista motorista = new Motorista("Carlos");
        motorista.dirigir(carro);

        // 2. Agregação
        System.out.println("\n=== Agregação ===");
        Curso curso = new Curso("Engenharia de Software");
        Aluno aluno1 = new Aluno("João");
        Aluno aluno2 = new Aluno("Maria");
        curso.adicionarAluno(aluno1);
        curso.adicionarAluno(aluno2);

        // 3. Composição
        System.out.println("\n=== Composição ===");
        Computador computador = new Computador("Intel Core i7");
        computador.ligar();

        // 4. Dependência
        System.out.println("\n=== Dependência ===");
        Documento documento = new Documento("Relatório Anual");
        Impressora impressora = new Impressora();
        impressora.imprimir(documento);
    }
}