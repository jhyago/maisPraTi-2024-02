package xadrez;

// Classe que representa o tabuleiro de xadrez
public class Tabuleiro {
    Peca[][] tabuleiro; // Matriz que representa o tabuleiro (8x8)

    // Construtor da classe Tabuleiro, inicializa o tabuleiro vazio e posiciona as peças
    public Tabuleiro() {
        this.tabuleiro = new Peca[8][8]; // Inicializa a matriz de 8x8 com null
        iniciarTabuleiro(); // Posiciona as peças iniciais
    }

    // Método que posiciona as peças no tabuleiro na configuração inicial
    void iniciarTabuleiro() {
        tabuleiro[0][3] = new Rainha("Branca", 0, 3); // Coloca a Rainha branca
        tabuleiro[0][4] = new Rei("Branca", 0, 4); // Coloca o Rei branco

        tabuleiro[7][3] = new Rainha("Preta", 7, 3); // Coloca a Rainha preta
        tabuleiro[7][4] = new Rei("Preta", 7, 4); // Coloca o Rei preto
    }

    // Método para exibir o tabuleiro no console
    public void exibirTabuleiro() {
        for (int i = 0; i < 8; i++) { // Percorre as linhas do tabuleiro
            for (int j = 0; j < 8; j++) { // Percorre as colunas do tabuleiro
                if (tabuleiro[i][j] != null) { // Verifica se há uma peça na posição
                    System.out.print(tabuleiro[i][j].getCor().charAt(0) + " "); // Exibe a cor da peça
                } else {
                    System.out.print(". "); // Exibe "." para posições vazias
                }
            }
            System.out.println(); // Pula para a próxima linha ao final de cada linha do tabuleiro
        }
    }

    // Método para mover uma peça de uma posição para outra
    public boolean moverPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        Peca peca = tabuleiro[linhaOrigem][colunaOrigem]; // Obtém a peça na posição de origem
        if (peca != null && peca.mover(linhaDestino, colunaDestino)) { // Verifica se há peça e se o movimento é válido
            tabuleiro[linhaDestino][colunaDestino] = peca; // Move a peça para a posição de destino
            tabuleiro[linhaOrigem][colunaOrigem] = null; // Remove a peça da posição de origem
            return true; // Movimento realizado com sucesso
        }
        return false; // Movimento inválido ou posição inicial vazia
    }
}