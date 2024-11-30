package xadrez;

// Classe que representa a peça "Rei", herdando da classe genérica "Peca"
public class Rei extends Peca {

    // Construtor da classe Rei, inicializa com a cor e posição da peça
    public Rei(String cor, int linha, int coluna) {
        super(cor, linha, coluna); // Chama o construtor da classe base "Peca"
    }

    // Método que verifica se o Rei pode se mover para a nova posição (novaLinha, novaColuna)
    @Override
    public boolean mover(int novaLinha, int novaColuna) {
        // Verifica se o movimento está dentro do alcance de uma casa (linha e coluna)
        return Math.abs(this.linha - novaLinha) <= 1 // Diferença de até uma casa na linha
                && Math.abs(this.coluna - novaColuna) <= 1; // Diferença de até uma casa na coluna
    }
}