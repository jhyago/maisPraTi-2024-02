package ds;

import java.util.ArrayList;
import java.util.Scanner;

public class FiltroDePalavras {
    public static void main(String[] args) {
        // Criação do Scanner para leitura da entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário que digite uma frase
        System.out.println("Digite uma frase: ");
        String frase = scanner.nextLine(); // Lê a frase digitada pelo usuário

        // Divide a frase em palavras utilizando espaço como delimitador
        String[] palavras = frase.split("\\s+");

        // Cria uma lista para armazenar as palavras
        ArrayList<String> listaPalavras = new ArrayList<>();

        // Adiciona cada palavra à lista
        for (String palavra : palavras) {
            listaPalavras.add(palavra);
        }

        // Remove palavras com menos de 4 caracteres
        listaPalavras.removeIf(palavra -> palavra.length() < 4);

        // Exibe as palavras restantes (com 4 ou mais caracteres)
        System.out.println("Palavras com 4 caracteres ou mais: ");
        listaPalavras.forEach(System.out::println);

        // Fecha o Scanner para liberar recursos
        scanner.close();
    }
}