package ds;

import java.util.ArrayList;
import java.util.Scanner;

public class FiltroDePalavras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        String frase = scanner.nextLine();

        String[] palavras = frase.split("\\s+");
        ArrayList<String> listaPalavras = new ArrayList<>();

        for(String palavra : palavras) {
            listaPalavras.add(palavra);
        }

        listaPalavras.removeIf(palavra -> palavra.length() < 4);

        System.out.println("Palavras com 4 caracteres ou mais: ");
        listaPalavras.forEach(System.out::println);

        scanner.close();
    }
}
