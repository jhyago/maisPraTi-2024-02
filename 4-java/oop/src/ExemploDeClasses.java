// Classe principal para organizar os exemplos
public class ExemplosDeClasses {

    // Classe interna estática (static nested class)
    // Geralmente usada quando não é necessário acessar membros da classe externa
    public static class ClasseEstatica {
        public void mostrarMensagem() {
            System.out.println("Exemplo de classe estática.");
        }
    }

    // Classe interna (inner class)
    // Tem acesso a todos os membros da classe externa, inclusive privados
    public class ClasseInterna {
        public void mostrarMensagem() {
            System.out.println("Exemplo de classe interna.");
        }
    }

    // Classe anônima
    // Usada quando precisamos implementar ou estender uma classe no momento da sua criação
    public void exemploClasseAnonima() {
        Runnable runnable = new Runnable() { // Classe anônima que implementa a interface Runnable
            @Override
            public void run() {
                System.out.println("Exemplo de classe anônima.");
            }
        };
        runnable.run();
    }

    // Classe local
    // Definida dentro de um método e só pode ser usada dentro deste método
    public void exemploClasseLocal() {
        class ClasseLocal {
            public void mostrarMensagem() {
                System.out.println("Exemplo de classe local.");
            }
        }

        // Criando e usando a classe local
        ClasseLocal classeLocal = new ClasseLocal();
        classeLocal.mostrarMensagem();
    }

    // Classe abstrata
    // Não pode ser instanciada diretamente; deve ser estendida por outras classes
    public abstract static class ClasseAbstrata {
        public abstract void mostrarMensagem(); // Método abstrato que deve ser implementado pelas subclasses
    }

    // Classe concreta que estende uma classe abstrata
    public static class SubClasseConcreta extends ClasseAbstrata {
        @Override
        public void mostrarMensagem() {
            System.out.println("Exemplo de classe abstrata sendo estendida por uma classe concreta.");
        }
    }

    // Classe selada (sealed class)
    // Restringe quais classes podem estendê-la
    public sealed class ClasseSelada permits SubClassePermitida {
        public void mostrarMensagem() {
            System.out.println("Exemplo de classe selada.");
        }
    }

    // Classe permitida (permits)
    // Pode estender a classe selada
    public final class SubClassePermitida extends ClasseSelada {
        @Override
        public void mostrarMensagem() {
            System.out.println("Exemplo de classe permitida pela classe selada.");
        }
    }

    // Classe registro (record)
    // Introduzida no Java 16 e estabilizada no Java 17, usada para representar dados imutáveis
    public record ClasseRecord(String nome, int idade) {
        // Métodos `nome()` e `idade()` são automaticamente gerados
    }

    // Método principal para demonstrar os exemplos
    public static void main(String[] args) {
        // Exemplo de classe estática
        ClasseEstatica classeEstatica = new ClasseEstatica();
        classeEstatica.mostrarMensagem();

        // Exemplo de classe interna
        ExemplosDeClasses exemplos = new ExemplosDeClasses();
        ClasseInterna classeInterna = exemplos.new ClasseInterna();
        classeInterna.mostrarMensagem();

        // Exemplo de classe anônima
        exemplos.exemploClasseAnonima();

        // Exemplo de classe local
        exemplos.exemploClasseLocal();

        // Exemplo de classe abstrata e sua subclasse concreta
        ClasseAbstrata subClasseConcreta = new SubClasseConcreta();
        subClasseConcreta.mostrarMensagem();

        // Exemplo de classe selada e sua subclasse permitida
        ClasseSelada classeSelada = new SubClassePermitida();
        classeSelada.mostrarMensagem();

        // Exemplo de classe record
        ClasseRecord record = new ClasseRecord("João", 25);
        System.out.println("Classe Record - Nome: " + record.nome() + ", Idade: " + record.idade());
    }
}
