/**
 * Exemplos de herança em Java, cobrindo todos os tipos permitidos.
 */
public class ExemplosDeHeranca {

    /**
     * 1. Herança Simples
     * Uma classe herda diretamente de outra classe.
     */
    static class Animal {
        void fazerSom() {
            System.out.println("O animal faz um som.");
        }
    }

    static class Cachorro extends Animal {
        @Override
        void fazerSom() {
            System.out.println("O cachorro late: Au au!");
        }
    }

    /**
     * 2. Herança Multinível
     * Uma classe herda de uma classe que já herda de outra.
     */
    static class Mamifero extends Animal {
        void amamentar() {
            System.out.println("O mamífero está amamentando.");
        }
    }

    static class Gato extends Mamifero {
        @Override
        void fazerSom() {
            System.out.println("O gato mia: Miau!");
        }
    }

    /**
     * 3. Herança Hierárquica
     * Várias classes herdam de uma única classe pai.
     */
    static class Cavalo extends Animal {
        @Override
        void fazerSom() {
            System.out.println("O cavalo relincha: Ihhhh!");
        }
    }

    static class Elefante extends Animal {
        @Override
        void fazerSom() {
            System.out.println("O elefante tromba: Fuuuu!");
        }
    }

    /**
     * 4. Uso de `final` para impedir herança
     * Uma classe marcada como `final` não pode ser estendida.
     */
    static final class Peixe extends Animal {
        @Override
        void fazerSom() {
            System.out.println("Os peixes não fazem som, mas podem fazer bolhas!");
        }
    }

    // Tentativa de herdar de uma classe final causaria erro de compilação
    // static class Tubarao extends Peixe {} // ERRO: Não é permitido herdar de uma classe final

    /**
     * Método principal para demonstrar exemplos de herança.
     */
    public static void main(String[] args) {
        System.out.println("=== Herança Simples ===");
        Cachorro cachorro = new Cachorro();
        cachorro.fazerSom();

        System.out.println("\n=== Herança Multinível ===");
        Gato gato = new Gato();
        gato.fazerSom();
        gato.amamentar();

        System.out.println("\n=== Herança Hierárquica ===");
        Cavalo cavalo = new Cavalo();
        Elefante elefante = new Elefante();
        cavalo.fazerSom();
        elefante.fazerSom();

        System.out.println("\n=== Classe Final ===");
        Peixe peixe = new Peixe();
        peixe.fazerSom();

        // Polimorfismo com herança
        System.out.println("\n=== Polimorfismo com Herança ===");
        Animal animalCachorro = new Cachorro();
        Animal animalGato = new Gato();
        animalCachorro.fazerSom();
        animalGato.fazerSom();
    }
}