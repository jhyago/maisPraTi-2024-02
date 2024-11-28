package xadrez;

public class Tabuleiro {
    Peca[][] tabuleiro;

    public Tabuleiro() {
        this.tabuleiro = new Peca[8][8];
        iniciarTabuleiro();
    }

    void iniciarTabuleiro() {
        tabuleiro[0][3] = new Rainha("Branca", 0, 3);
        tabuleiro[0][4] = new Rei("Branca", 0, 4);

        tabuleiro[7][3] = new Rainha("Preta", 7, 3);
        tabuleiro[7][4] = new Rei("Preta", 7, 4);
    }

    public void exibirTabuleiro() {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++) {
                if(tabuleiro[i][j] != null) {
                    System.out.print(tabuleiro[i][j].getCor().charAt(0) + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public boolean moverPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        Peca peca = tabuleiro[linhaOrigem][colunaOrigem];
        if(peca != null && peca.mover(linhaDestino, colunaDestino)) {
            tabuleiro[linhaDestino][colunaDestino] = peca;
            tabuleiro[linhaOrigem][colunaOrigem] = null;
            return true;
        }
        return false;
    }


}
