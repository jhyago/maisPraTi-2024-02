public class ExemplosDeInterfaces {

    // 1. Interface funcional
    // Contém exatamente um método abstrato, usado em expressões lambda
    @FunctionalInterface
    interface InterfaceFuncional {
        void executar(); // Método abstrato único
    }

    // 2. Interface com métodos abstratos
    // A forma tradicional de definir contratos
    interface InterfaceTradicional {
        void metodo1();

        void metodo2(String mensagem);
    }

    // 3. Interface com métodos padrão (default)
    // Introduzida no Java 8, permite fornecer implementações padrão para métodos
    interface InterfaceComDefault {
        void metodoObrigatorio(); // Método abstrato

        default void metodoOpcional() {
            System.out.println("Método padrão da interface.");
        }
    }

    // 4. Interface com métodos estáticos
    // Introduzida no Java 8, permite definir métodos estáticos dentro da interface
    interface InterfaceComEstatico {
        static void metodoEstatico() {
            System.out.println("Método estático na interface.");
        }
    }

    // 5. Interface com constantes
    // Contém campos automaticamente `public`, `static` e `final`
    interface InterfaceComConstantes {
        String CONSTANTE = "Valor constante";

        void usarConstante();
    }

    // 6. Interface herdada
    // Uma interface que herda de outra interface
    interface InterfaceBase {
        void metodoBase();
    }

    interface InterfaceHerdada extends InterfaceBase {
        void metodoHerdado();
    }

    // Classe principal demonstrando as implementações
    public static void main(String[] args) {
        // 1. Usando uma interface funcional com expressão lambda
        InterfaceFuncional funcional = () -> System.out.println("Interface funcional executada!");
        funcional.executar();

        // 2. Implementação de uma interface tradicional
        InterfaceTradicional tradicional = new InterfaceTradicional() {
            @Override
            public void metodo1() {
                System.out.println("Método 1 executado.");
            }

            @Override
            public void metodo2(String mensagem) {
                System.out.println("Mensagem recebida: " + mensagem);
            }
        };
        tradicional.metodo1();
        tradicional.metodo2("Exemplo de mensagem.");

        // 3. Implementação de uma interface com métodos padrão
        InterfaceComDefault comDefault = new InterfaceComDefault() {
            @Override
            public void metodoObrigatorio() {
                System.out.println("Método obrigatório implementado.");
            }
        };
        comDefault.metodoObrigatorio();
        comDefault.metodoOpcional(); // Método padrão sendo chamado

        // 4. Usando método estático de uma interface
        InterfaceComEstatico.metodoEstatico();

        // 5. Usando constante de uma interface
        InterfaceComConstantes comConstantes = new InterfaceComConstantes() {
            @Override
            public void usarConstante() {
                System.out.println("Usando a constante: " + CONSTANTE);
            }
        };
        comConstantes.usarConstante();

        // 6. Implementando interface herdada
        InterfaceHerdada herdada = new InterfaceHerdada() {
            @Override
            public void metodoBase() {
                System.out.println("Método base da interface herdada.");
            }

            @Override
            public void metodoHerdado() {
                System.out.println("Método herdado da interface.");
            }
        };
        herdada.metodoBase();
        herdada.metodoHerdado();
    }
}