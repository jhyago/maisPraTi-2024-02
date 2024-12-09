public class ExemplosDeMetodos {

    // 1. Método estático (static)
    // Pode ser chamado sem a necessidade de uma instância da classe
    public static void metodoEstatico() {
        System.out.println("Este é um método estático.");
    }

    // 2. Método de instância
    // Requer uma instância da classe para ser chamado
    public void metodoDeInstancia() {
        System.out.println("Este é um método de instância.");
    }

    // 3. Método abstrato
    // Declarado em uma classe abstrata, deve ser implementado por subclasses
    public abstract static class ClasseComMetodoAbstrato {
        public abstract void metodoAbstrato(); // Sem implementação aqui
    }

    public static class SubClasse extends ClasseComMetodoAbstrato {
        @Override
        public void metodoAbstrato() {
            System.out.println("Implementação de um método abstrato na subclasse.");
        }
    }

    // 4. Método final
    // Não pode ser sobrescrito por subclasses
    public final void metodoFinal() {
        System.out.println("Este é um método final. Não pode ser sobrescrito.");
    }

    // 5. Método privado
    // Só pode ser acessado dentro da classe onde foi declarado
    private void metodoPrivado() {
        System.out.println("Este é um método privado. Só pode ser chamado dentro desta classe.");
    }

    // 6. Método protegido
    // Pode ser acessado dentro do mesmo pacote ou por subclasses
    protected void metodoProtegido() {
        System.out.println("Este é um método protegido. Acessível no mesmo pacote ou por subclasses.");
    }

    // 7. Método sincronizado
    // Usado em ambientes multithread para garantir exclusão mútua
    public synchronized void metodoSincronizado() {
        System.out.println("Este é um método sincronizado. Garantido para ser executado por uma thread por vez.");
    }

    // 8. Método varargs (com argumentos variáveis)
    // Permite passar um número variável de argumentos
    public void metodoVarargs(String... valores) {
        System.out.println("Este é um método com argumentos variáveis. Valores recebidos:");
        for (String valor : valores) {
            System.out.println(valor);
        }
    }

    // 9. Método que retorna valor
    // Retorna um valor ao chamador
    public int metodoComRetorno() {
        System.out.println("Este é um método que retorna um valor.");
        return 42; // Retorna um valor inteiro
    }

    // 10. Método sem retorno (void)
    // Não retorna nada
    public void metodoSemRetorno() {
        System.out.println("Este é um método que não retorna valor.");
    }

    // 11. Método sobrescrito (override)
    // Sobrescreve o comportamento de um método em uma superclasse
    public static class SuperClasse {
        public void metodoSobrescrito() {
            System.out.println("Método da superclasse.");
        }
    }

    public static class SubClasseSobrescrita extends SuperClasse {
        @Override
        public void metodoSobrescrito() {
            System.out.println("Método sobrescrito na subclasse.");
        }
    }

    // Método principal para demonstrar os exemplos
    public static void main(String[] args) {
        // 1. Chamando método estático
        metodoEstatico();

        // 2. Chamando método de instância
        ExemplosDeMetodos exemplos = new ExemplosDeMetodos();
        exemplos.metodoDeInstancia();

        // 3. Método abstrato sendo implementado por uma subclasse
        SubClasse subClasse = new SubClasse();
        subClasse.metodoAbstrato();

        // 4. Chamando método final
        exemplos.metodoFinal();

        // 5. Chamando método privado (dentro da classe)
        exemplos.metodoPrivado();

        // 6. Chamando método protegido
        exemplos.metodoProtegido();

        // 7. Chamando método sincronizado
        exemplos.metodoSincronizado();

        // 8. Chamando método com argumentos variáveis
        exemplos.metodoVarargs("Primeiro", "Segundo", "Terceiro");

        // 9. Chamando método que retorna valor
        int resultado = exemplos.metodoComRetorno();
        System.out.println("Valor retornado: " + resultado);

        // 10. Chamando método sem retorno
        exemplos.metodoSemRetorno();

        // 11. Chamando método sobrescrito
        SuperClasse superClasse = new SuperClasse();
        SubClasseSobrescrita subClasseSobrescrita = new SubClasseSobrescrita();
        superClasse.metodoSobrescrito();
        subClasseSobrescrita.metodoSobrescrito();
    }
}