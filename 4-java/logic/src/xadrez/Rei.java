package xadrez;

public class Rei extends Peca {
    public Rei(String cor, int linha, int coluna) {
        super(cor, linha, coluna);
    }

    @Override
    public boolean mover(int novaLinha, int novaColuna) {
        return Math.abs(this.linha - novaLinha) <= 1 && Math.abs(this.coluna - novaColuna) <= 1;
    }
}
