package xadrez;

public class Rainha extends Peca {
    public Rainha(String cor, int linha, int coluna) {
        super(cor, linha, coluna);
    }

    @Override
    public boolean mover(int novaLinha, int novaColuna) {
        return this.linha == novaLinha || this.coluna == novaColuna
                || Math.abs(this.linha - novaLinha) == Math.abs(this.coluna - novaColuna);
    }
}
