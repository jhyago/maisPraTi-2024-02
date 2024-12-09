import java.util.LinkedList;
import java.util.Scanner;

public class FilaDeEspera {
    public static void main(String[] args) {
        // Criação da LinkedList para representar a fila de espera
        LinkedList<String> fila = new LinkedList<>();
        fila.add("Ana");
        fila.add("Jaques");
        fila.add("Carla");
        fila.add("Taís");

        // Scanner para leitura de entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Variável para armazenar a escolha do usuário
        String opcao;

        System.out.println("=== Simulação de Fila de Espera ===");

        // Loop principal da simulação
        do {
            System.out.println("\nFila atual: " + fila);

            // Verifica se há alguém na fila e exibe o próximo a ser atendido
            if (!fila.isEmpty()) {
                System.out.println("Próximo a ser atendido: " + fila.peek());
            } else {
                System.out.println("A fila está vazia.");
                break; // Sai do loop se a fila estiver vazia
            }

            // Exibe o menu de opções para o usuário
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar um novo nome à fila");
            System.out.println("2 - Remover o próximo da fila");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextLine(); // Lê a opção do usuário

            // Processa a escolha do usuário
            switch (opcao) {
                case "1": // Adicionar um novo nome à fila
                    System.out.print("Digite o nome para adicionar à fila: ");
                    String novoNome = scanner.nextLine(); // Lê o nome do usuário
                    fila.add(novoNome); // Adiciona o nome à fila
                    System.out.println(novoNome + " foi adicionado à fila.");
                    break;

                case "2": // Remover o próximo da fila
                    if (!fila.isEmpty()) {
                        String removido = fila.poll(); // Remove o primeiro da fila
                        System.out.println(removido + " foi removido da fila.");
                    } else {
                        System.out.println("A fila já está vazia.");
                    }
                    break;

                case "3": // Sair da simulação
                    System.out.println("Encerrando a simulação.");
                    break;

                default: // Opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (!opcao.equals("3")); // Continua o loop até que o usuário escolha "3"

        // Fecha o scanner para liberar recursos
        scanner.close();
    }
}