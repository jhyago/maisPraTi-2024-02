public interface Animal {

    int MAX_USUARIOS  = 100;

    void emitirSom();

    default void dormir() {
        System.out.println("Dormir");
    }

    static void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    private void preparar() {
        System.out.println("Configurando a interface!");
    }
}
