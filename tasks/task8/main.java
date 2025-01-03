import java.util.*;

public class Exercicios {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Calculadora Simples");
            System.out.println("2. Verificador de Palíndromos");
            System.out.println("3. Sequência de Fibonacci");
            System.out.println("4. Inversor de Números");
            System.out.println("5. Verificador de Anagramas");
            System.out.println("6. Jogo de Adivinhação");
            System.out.println("7. Contador de Palavras");
            System.out.println("0. Sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    calculadora(scanner);
                    break;
                case 2:
                    verificadorPalindromo(scanner);
                    break;
                case 3:
                    sequenciaFibonacci(scanner);
                    break;
                case 4:
                    inversorNumeros(scanner);
                    break;
                case 5:
                    verificadorAnagramas(scanner);
                    break;
                case 6:
                    jogoAdivinhacao(scanner);
                    break;
                case 7:
                    contadorPalavras(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    // Exercício 1: Calculadora Simples
    public static void calculadora(Scanner scanner) {
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        System.out.print("Digite o operador (+, -, *, /): ");
        char operador = scanner.next().charAt(0);

        double resultado;
        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Erro: Divisão por zero!");
                    return;
                }
                break;
            default:
                System.out.println("Operador inválido!");
                return;
        }
        System.out.println("Resultado: " + resultado);
    }

    // Exercício 2: Verificador de Palíndromos
    public static void verificadorPalindromo(Scanner scanner) {
        System.out.print("Digite uma palavra: ");
        String palavra = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");
        String reverso = new StringBuilder(palavra).reverse().toString();

        if (palavra.equals(reverso)) {
            System.out.println("A palavra é um palíndromo.");
        } else {
            System.out.println("A palavra não é um palíndromo.");
        }
    }

    // Exercício 3: Sequência de Fibonacci
    public static void sequenciaFibonacci(Scanner scanner) {
        System.out.print("Quantos números da sequência de Fibonacci deseja exibir? ");
        int n = scanner.nextInt();
        int a = 0, b = 1;

        System.out.print("Sequência de Fibonacci: " + a);
        for (int i = 1; i < n; i++) {
            System.out.print(", " + b);
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();
    }

    // Exercício 4: Inversor de Números
    public static void inversorNumeros(Scanner scanner) {
        System.out.print("Digite um número inteiro: ");
        int numero = scanner.nextInt();
        int invertido = 0;

        while (numero != 0) {
            invertido = invertido * 10 + numero % 10;
            numero /= 10;
        }

        System.out.println("Número invertido: " + invertido);
    }

    // Exercício 5: Verificador de Anagramas
    public static void verificadorAnagramas(Scanner scanner) {
        System.out.print("Digite a primeira palavra: ");
        String palavra1 = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");
        System.out.print("Digite a segunda palavra: ");
        String palavra2 = scanner.nextLine().toLowerCase().replaceAll("\\s+", "");

        if (isAnagrama(palavra1, palavra2)) {
            System.out.println("As palavras são anagramas.");
        } else {
            System.out.println("As palavras não são anagramas.");
        }
    }

    public static boolean isAnagrama(String palavra1, String palavra2) {
        if (palavra1.length() != palavra2.length()) {
            return false;
        }
        char[] array1 = palavra1.toCharArray();
        char[] array2 = palavra2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }

    // Exercício 6: Jogo de Adivinhação
    public static void jogoAdivinhacao(Scanner scanner) {
        Random random = new Random();
        int numeroEscolhido = random.nextInt(50) + 1;
        int palpite;

        System.out.println("Tente adivinhar o número entre 1 e 50.");

        do {
            System.out.print("Seu palpite: ");
            palpite = scanner.nextInt();

            if (palpite == numeroEscolhido) {
                System.out.println("Parabéns! Você adivinhou o número.");
            } else {
                System.out.println("Palpite errado. Tente novamente.");
            }
        } while (palpite != numeroEscolhido);
    }

    // Exercício 7: Contador de Palavras
    public static void contadorPalavras(Scanner scanner) {
        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine().trim();

        if (frase.isEmpty()) {
            System.out.println("A frase contém 0 palavras.");
        } else {
            String[] palavras = frase.split("\\s+");
            System.out.println("A frase contém " + palavras.length + " palavras.");
        }
    }
}