package xadrez;

// Classe que representa a peça "Rainha", herdando da classe genérica "Peca"
public class Rainha extends Peca {

    // Construtor da classe Rainha, inicializa com a cor e posição da peça
    public Rainha(String cor, int linha, int coluna) {
        super(cor, linha, coluna); // Chama o construtor da classe base "Peca"
    }

    // Método que verifica se a peça pode se mover para a nova posição (novaLinha, novaColuna)
    @Override
    public boolean mover(int novaLinha, int novaColuna) {
        // Verifica se o movimento é válido para a Rainha:
        // 1. Movimento na mesma linha (horizontal).
        // 2. Movimento na mesma coluna (vertical).
        // 3. Movimento diagonal, onde a diferença entre linha e coluna é a mesma.
        return this.linha == novaLinha // Movimento horizontal
                || this.coluna == novaColuna // Movimento vertical
                || Math.abs(this.linha - novaLinha) == Math.abs(this.coluna - novaColuna); // Movimento diagonal
    }
}