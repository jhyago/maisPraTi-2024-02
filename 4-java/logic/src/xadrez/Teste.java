package xadrez;

public class Teste {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();

        tabuleiro.exibirTabuleiro();

        System.out.println("Movendo a Rainha");
        tabuleiro.moverPeca(0, 3, 3, 0);

        tabuleiro.exibirTabuleiro();
    }
}
