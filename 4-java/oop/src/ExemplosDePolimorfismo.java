/**
 * Exemplos de Polimorfismo em Java.
 * O Polimorfismo permite que objetos de diferentes classes sejam tratados de forma uniforme.
 */
public class ExemplosDePolimorfismo {

    /**
     * 1. Polimorfismo de Sobrescrita (Override)
     * Uma subclasse fornece uma implementação específica para um método da classe pai.
     */
    static class Animal {
        public void emitirSom() {
            System.out.println("O animal faz um som genérico.");
        }
    }

    static class Cachorro extends Animal {
        @Override
        public void emitirSom() {
            System.out.println("O cachorro late: Au au!");
        }
    }

    static class Gato extends Animal {
        @Override
        public void emitirSom() {
            System.out.println("O gato mia: Miau!");
        }
    }

    /**
     * 2. Polimorfismo com interfaces
     * Uma interface fornece um contrato comum para classes diferentes.
     */
    interface Veiculo {
        void acelerar();
    }

    static class Carro implements Veiculo {
        @Override
        public void acelerar() {
            System.out.println("O carro acelera rapidamente!");
        }
    }

    static class Moto implements Veiculo {
        @Override
        public void acelerar() {
            System.out.println("A moto acelera com agilidade!");
        }
    }

    /**
     * 3. Polimorfismo com métodos genéricos
     * Um método genérico pode operar com diferentes tipos de objetos.
     */
    static class Impressora {
        public void imprimir(Animal animal) {
            animal.emitirSom();
        }
    }

    /**
     * Método principal para demonstrar os exemplos de polimorfismo.
     */
    public static void main(String[] args) {
        System.out.println("=== Polimorfismo de Sobrescrita ===");
        Animal animalGenerico = new Animal();
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();

        animalGenerico.emitirSom();
        cachorro.emitirSom();
        gato.emitirSom();

        System.out.println("\n=== Polimorfismo com Interfaces ===");
        Veiculo carro = new Carro();
        Veiculo moto = new Moto();

        carro.acelerar();
        moto.acelerar();

        System.out.println("\n=== Polimorfismo com Métodos Genéricos ===");
        Impressora impressora = new Impressora();

        impressora.imprimir(cachorro); // Polimorfismo: o método chamar o comportamento específico
        impressora.imprimir(gato);
    }
}