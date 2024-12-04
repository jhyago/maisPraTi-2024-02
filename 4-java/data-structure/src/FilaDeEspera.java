import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class FilaDeEspera {
    public static void main(String[] args) {
        LinkedList<String> fila = new LinkedList<>();
        fila.add("Ana");
        fila.add("Jaques");
        fila.add("Carla");
        fila.add("Taís");

        Scanner scanner = new Scanner(System.in);

        String opcao;

        System.out.println("Simulação de Fila de Espera");
        do {
            System.out.println("\nFila atual: " + fila);

            if(!fila.isEmpty()) {
                System.out.println("Próximo a ser atendido: " + fila.peek());
            } else {
                System.out.println("A fila está vazia");
                break;
            }

            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Adicionar um novo nome à fila");
            System.out.println("2 - Remover o próximo da fila");
            System.out.println("3 - Sair");
            System.out.println("Opção: ");
            opcao = scanner.nextLine();

            switch(opcao) {
                case "1":
                    System.out.println("Digite o nome para adicionar à fila: ");
                    String novoNome = scanner.nextLine();
                    fila.add(novoNome);
                    System.out.println(novoNome + " Foi adicionado à fila");
                    break;
                case "2":
                    if (!fila.isEmpty()) {
                        String removido = fila.poll();
                        System.out.println(removido + " foi removido da fila");
                    } else {
                        System.out.println("A fila já está vazia");
                    }
                    break;
                case "3":
                    System.out.println("Encerrando a simulação");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while(!opcao.equals("3"));

        scanner.close();
    }
}
