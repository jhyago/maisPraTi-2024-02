import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Declaração de variáveis primitivas

        byte byteVar = 127;   // Variável byte pode armazenar valores de -128 a 127.
        short shortVar = 32000; // Variável short pode armazenar valores de -32.768 a 32.767.
        int intVar = 2100000000; // Variável int pode armazenar valores de -2.147.483.648 a 2.147.483.647.
        long longVar = 9000000000000000000L; // Variável long pode armazenar valores muito grandes, sendo necessário um 'L' no final para indicar que é long.

        float floatVar = 3.1415F; // Variável float é um ponto flutuante de precisão simples, é necessário adicionar um 'F' no final.
        double doubleVar = 3.14159265; // Variável double é um ponto flutuante de precisão dupla.

        char charVar = 'A'; // Variável char armazena um único caractere Unicode, que aqui é 'A'.

        boolean booleanVar = true; // Variável boolean armazena valores true ou false.

        // Saída das variáveis na console usando System.out.println e System.out.printf
        System.out.println("Byte: " + byteVar); // Imprime o valor de byteVar.
        System.out.println("Short: " + shortVar); // Imprime o valor de shortVar.
        System.out.println("Int: " + intVar); // Imprime o valor de intVar.
        System.out.println("Long: " + longVar); // Imprime o valor de longVar.
        System.out.println("Float: " + floatVar); // Imprime o valor de floatVar.
        System.out.println("Double: " + doubleVar); // Imprime o valor de doubleVar.
        System.out.println("Char: " + charVar); // Imprime o valor de charVar.
        System.out.println("Boolean: " + booleanVar); // Imprime o valor de booleanVar.

        // Formatação de ponto flutuante com duas casas decimais
        System.out.printf("%.2f\n", floatVar); // Imprime floatVar com duas casas decimais.

        String name = "Jaques"; // Declara uma variável do tipo String e a inicializa com "Jaques".

        System.out.println(name); // Imprime o valor da String 'name'.

        // Configuração de Localidade para a formatação numérica
        Locale.setDefault(Locale.US); // Define a localidade padrão como US para garantir o uso do ponto decimal.
        System.out.printf("%.2f\n", floatVar); // Imprime floatVar com formatação de duas casas decimais no padrão US.

        int a, b, c; // Declara três variáveis inteiras a, b e c.
        double area; // Declara uma variável double para armazenar o valor da área.

        a = 5; // Atribui o valor 5 à variável a.
        b = 7; // Atribui o valor 7 à variável b.
        c = 3; // Atribui o valor 3 à variável c.

        area = (double) (a + b) / 2 * c; // Calcula a área do trapézio usando a fórmula: área = ((a + b) / 2) * c, com casting para garantir a precisão do cálculo.

        System.out.println(area); // Imprime o valor da área calculada.

        // Criando um objeto Scanner para leitura de dados do console
        Scanner sc = new Scanner(System.in); // Scanner é usado para ler a entrada do usuário a partir do console.

        // Exercício 1: Conversão de Celsius para Fahrenheit
        double celsius = 25.0; // Declara uma variável para armazenar a temperatura em Celsius e inicializa com 25.0.
        double fahrenheit = (celsius * 9 / 5) + 32; // Converte Celsius para Fahrenheit usando a fórmula: F = (C * 9/5) + 32.
        System.out.println("A temperatura em Fahrenheit é: " + fahrenheit); // Imprime a temperatura em Fahrenheit.

        // Exercício 2: Verificação de maioridade
        int idade = 19; // Declara uma variável inteira para idade e inicializa com 19.
        if (idade >= 18) { // Verifica se a idade é maior ou igual a 18.
            System.out.println("Você é maior de idade!"); // Imprime se a condição for verdadeira.
        } else {
            System.out.println("Você é menor de idade!"); // Imprime se a condição for falsa.
        }

        // Exercício 3: Verificação de par ou ímpar
        int numero = 4; // Declara uma variável inteira e inicializa com 4.
        if (numero % 2 == 0) { // Verifica se o número é divisível por 2.
            System.out.println("O número é par!"); // Imprime se for par.
        } else {
            System.out.println("O número é ímpar!"); // Imprime se for ímpar.
        }

        // Exercício 4: Dia da semana usando switch-case
        System.out.println("Digite o dia da semana: "); // Solicita ao usuário que digite o dia da semana.
        int dia = sc.nextInt(); // Lê um número inteiro representando o dia da semana.
        switch (dia) {
            case 1:
                System.out.println("Domingo!"); // Imprime se o dia for 1.
                break;
            case 2:
                System.out.println("Segunda-feira!"); // Imprime se o dia for 2.
                break;
            case 3:
                System.out.println("Terça-feira!"); // Imprime se o dia for 3.
                break;
            case 4:
                System.out.println("Quarta-feira!"); // Imprime se o dia for 4.
                break;
            case 5:
                System.out.println("Quinta-feira!"); // Imprime se o dia for 5.
                break;
            case 6:
                System.out.println("Sexta-feira!"); // Imprime se o dia for 6.
                break;
            case 7:
                System.out.println("Sábado!"); // Imprime se o dia for 7.
                break;
            default:
                System.out.println("Dia inválido!"); // Imprime se o número não corresponder a um dia da semana.
                break;
        }

        // Exercício 5: Verificação de ano bissexto
        System.out.println("Digite o ano para verificação: "); // Solicita ao usuário que digite um ano.
        int ano = sc.nextInt(); // Lê o ano como um número inteiro.
        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) { // Verifica se o ano é bissexto.
            System.out.println(ano + " é um ano bissexto!"); // Imprime se for bissexto.
        } else {
            System.out.println(ano + " não é um ano bissexto!"); // Imprime se não for bissexto.
        }

        // Exercício 6: Calculadora simples
        System.out.println("Digite um número: "); // Solicita o primeiro número ao usuário.
        double num1 = sc.nextDouble(); // Lê o primeiro número.
        System.out.println("Digite o segundo número: "); // Solicita o segundo número ao usuário.
        double num2 = sc.nextDouble(); // Lê o segundo número.
        System.out.println("Digite um operador (+, -, /, *):"); // Solicita o operador ao usuário.
        char operador = sc.next().charAt(0); // Lê o operador como um caractere.
        double resultado = 0; // Inicializa a variável de resultado.
        switch (operador) {
            case '+':
                resultado = num1 + num2; // Realiza a soma se o operador for '+'.
                break;
            case '-':
                resultado = num1 - num2; // Realiza a subtração se o operador for '-'.
                break;
            case '/':
                if (num2 != 0) { // Verifica divisão por zero.
                    resultado = num1 / num2; // Realiza a divisão se o operador for '/'.
                } else {
                    System.out.println("Erro: Divisão por zero não permitida!"); // Imprime mensagem de erro.
                }
                break;
            case '*':
                resultado = num1 * num2; // Realiza a multiplicação se o operador for '*'.
                break;
            default:
                System.out.println("Operador inválido!"); // Imprime se o operador for inválido.
                break;
        }
        System.out.println("O resultado é: " + resultado); // Imprime o resultado.

        // Exercício 7: Login básico com limite de tentativas
        int count = 0; // Inicializa o contador de tentativas.
        while (true) { // Loop infinito até atingir o limite ou login ser bem-sucedido.
            if (count == 3) { // Verifica se o limite de tentativas foi atingido.
                System.out.println("Excedeu o limite de tentativas"); // Imprime mensagem de bloqueio.
                break; // Sai do loop.
            }
            System.out.println("Informe o usuário:"); // Solicita o nome de usuário.
            String user = sc.next(); // Lê o nome de usuário.
            System.out.println("Informe sua senha:"); // Solicita a senha.
            String password = sc.next(); // Lê a senha.
            if (user.equals("Dênis") && password.equals("Admin")) { // Verifica as credenciais.
                System.out.println("Login efetuado com sucesso!"); // Imprime se o login for bem-sucedido.
                break; // Sai do loop.
            } else {
                System.out.println("Senha ou usuário incorretos!"); // Imprime mensagem de erro.
                count++; // Incrementa o contador de tentativas.
            }
        }
        System.out.println("Fim do programa!"); // Imprime fim do programa após login ou bloqueio.

        // Estruturas de repetição: For
        for (int i = 0; i < 10; i++) { // Loop de 0 a 9 (10 iterações).
            System.out.println("Valor de i é: " + i); // Imprime o valor atual de i.
        }

        // Estruturas de repetição: While
        int i = 0; // Inicializa a variável i.
        while (i < 10) { // Loop enquanto i for menor que 10.
            System.out.println("Valor de i é: " + i); // Imprime o valor atual de i.
            i++; // Incrementa i.
        }

        // Estruturas de repetição: Do-While
        i = 0; // Reinicializa a variável i.
        do {
            System.out.println("Valor de i é: " + i); // Imprime o valor atual de i.
            i++; // Incrementa i.
        } while (i < 10); // Executa o loop enquanto i for menor que 10.

        // Manipulação de Strings
        String texto = "Java é melhor que aquela linguagem"; // Declara uma String.
        int comprimento = texto.length(); // Obtém o comprimento da String.
        System.out.println(comprimento); // Imprime o comprimento.
        String maiusculas = texto.toUpperCase(); // Converte a String para maiúsculas.
        System.out.println(maiusculas); // Imprime a String em maiúsculas.
        String minusculas = texto.toLowerCase(); // Converte a String para minúsculas.
        System.out.println(minusculas); // Imprime a String em minúsculas.
        boolean contem = texto.contains("java"); // Verifica se a String contém "java".
        System.out.println(contem); // Imprime se contém.
        String substituto = texto.replace("Java", "Python"); // Substitui "Java" por "Python".
        System.out.println(substituto); // Imprime a String modificada.
        String substring = texto.substring(0, 4); // Obtém uma substring dos primeiros 4 caracteres.
        System.out.println(substring); // Imprime a substring.

        // Funções matemáticas
        double num = 50.30; // Declara uma variável double.
        double arredondado = Math.round(num); // Arredonda o número para o inteiro mais próximo.
        System.out.println(arredondado); // Imprime o valor arredondado.
        double arredondadoPraCima = Math.ceil(num); // Arredonda o número para cima.
        System.out.println(arredondadoPraCima); // Imprime o valor arredondado para cima.
        double arredondadoPraBaixo = Math.floor(num); // Arredonda o número para baixo.
        System.out.println(arredondadoPraBaixo); // Imprime o valor arredondado para baixo.
        double raizQuadrada = Math.sqrt(num); // Calcula a raiz quadrada do número.
        System.out.println(raizQuadrada); // Imprime a raiz quadrada.
        double absoluto = Math.abs(num); // Obtém o valor absoluto do número.
        System.out.println(absoluto); // Imprime o valor absoluto.
        double aleatorio = Math.random(); // Gera um número aleatório entre 0.0 e 1.0.
        System.out.println(aleatorio); // Imprime o número aleatório.

        // Fatorial de um número e sequência de Fibonacci
        // (Implementações de fatorial e Fibonacci podem ser adicionadas aqui)

        // Manipulação de arrays

        int[] vetor = new int[5]; // Declara um array de inteiros com tamanho 5.
        vetor[0] = 10; // Atribui o valor 10 à primeira posição do array.
        vetor[1] = 20; // Atribui o valor 20 à segunda posição do array.
        vetor[2] = 30; // Atribui o valor 30 à terceira posição do array.
        vetor[3] = 40; // Atribui o valor 40 à quarta posição do array.
        vetor[4] = 50; // Atribui o valor 50 à quinta posição do array.

        // Imprimindo elementos do array
        System.out.println("Elementos do array 'vetor': ");
        for (int j = 0; j < vetor.length; j++) { // Itera sobre o array.
            System.out.println("Elemento na posição " + j + ": " + vetor[j]); // Imprime cada elemento.
        }

        // Soma dos elementos do array
        int soma = 0; // Inicializa a variável para armazenar a soma.
        for (int j = 0; j < vetor.length; j++) { // Itera sobre o array.
            soma += vetor[j]; // Soma cada elemento à variável soma.
        }
        System.out.println("Soma do array 'vetor': " + soma); // Imprime a soma dos elementos.

        // Encontrando o valor máximo no array
        int max = vetor[0]; // Assume que o primeiro elemento é o maior.
        for (int value : vetor) { // Itera sobre cada elemento do array.
            if (value > max) { // Compara com o valor atual máximo.
                max = value; // Atualiza o valor máximo, se necessário.
            }
        }
        System.out.println("Valor máximo no array: " + max); // Imprime o valor máximo.

        // Revertendo o array
        int start = 0; // Posição inicial para a inversão.
        int end = vetor.length - 1; // Posição final para a inversão.
        while (start < end) { // Loop até os índices se cruzarem.
            int temp = vetor[start]; // Armazena temporariamente o valor inicial.
            vetor[start] = vetor[end]; // Substitui o valor inicial pelo final.
            vetor[end] = temp; // Coloca o valor armazenado na posição final.
            start++; // Move o índice inicial para a direita.
            end--; // Move o índice final para a esquerda.
        }
        System.out.println("Array 'vetor' invertido: ");
        for (int j = 0; j < vetor.length; j++) { // Itera sobre o array.
            System.out.println("Elemento na posição " + j + ": " + vetor[j]); // Imprime cada elemento invertido.
        }

        // Adicionando um elemento a um array
        int[] newArray = new int[vetor.length + 1]; // Cria um novo array com espaço adicional.
        for (int j = 0; j < vetor.length; j++) { // Itera sobre o array original.
            newArray[j] = vetor[j]; // Copia os elementos para o novo array.
        }
        newArray[vetor.length] = 1; // Adiciona o novo elemento no final do array.

        // Removendo um elemento de um array
        int countRemocao = 0; // Conta os elementos diferentes do valor a ser removido.
        for (int j = 0; j < vetor.length; j++) { // Itera sobre o array.
            if (vetor[j] != 10) { // Verifica se o elemento é diferente de 10.
                countRemocao++; // Incrementa a contagem.
            }
        }
        int[] newArrayRemocao = new int[countRemocao]; // Cria um novo array sem os elementos a remover.
        int index = 0; // Índice para o novo array.
        for (int j = 0; j < vetor.length; j++) { // Itera sobre o array.
            if (vetor[j] != 10) { // Verifica se o elemento é diferente de 10.
                newArrayRemocao[index] = vetor[j]; // Adiciona o elemento ao novo array.
                index++; // Incrementa o índice.
            }
        }
        System.out.println("Array após remoção: ");
        for (int j = 0; j < newArrayRemocao.length; j++) { // Itera sobre o novo array.
            System.out.println("Elemento na posição " + j + ": " + newArrayRemocao[j]); // Imprime cada elemento.
        }

        // Pesquisando elementos em um array
        for (int j = 0; j < vetor.length; j++) { // Itera sobre o array.
            if (vetor[j] == 20) { // Verifica se o elemento é igual a 20.
                System.out.println("Elemento 20 encontrado na posição: " + j); // Imprime a posição.
            }
        }

        // Matrizes (arrays bidimensionais)
        int[][] matrix = { // Declara e inicializa uma matriz 3x3.
                {10, 20, 35},
                {30, 50, 60},
                {70, 80, 90}
        };

        // Rotação de matriz 90 graus
        int n = matrix.length; // Obtém o tamanho da matriz (n x n).
        int[][] rotacionada = new int[n][n]; // Cria uma matriz para armazenar a rotação.
        for (int j = 0; j < n; j++) { // Itera sobre as linhas da matriz.
            for (int k = 0; k < n; k++) { // Itera sobre as colunas da matriz.
                rotacionada[k][n - 1 - j] = matrix[j][k]; // Rotaciona a matriz em 90 graus.
            }
        }
        System.out.println("Matriz rotacionada 90 graus:");
        for (int j = 0; j < n; j++) { // Itera sobre a matriz rotacionada.
            for (int k = 0; k < n; k++) { // Itera sobre as colunas.
                System.out.print(rotacionada[j][k] + " "); // Imprime cada elemento.
            }
            System.out.println(); // Nova linha após cada linha da matriz.
        }

        // Soma das diagonais da matriz
        int sumPrincipal = 0; // Soma da diagonal principal.
        int sumSecundaria = 0; // Soma da diagonal secundária.
        for (int j = 0; j < matrix.length; j++) { // Itera sobre as linhas da matriz.
            for (int k = 0; k < matrix[j].length; k++) { // Itera sobre as colunas.
                if (j == k) { // Verifica se é a diagonal principal.
                    sumPrincipal += matrix[j][k]; // Soma o elemento.
                }
                if ((j + k) == matrix.length - 1) { // Verifica se é a diagonal secundária.
                    sumSecundaria += matrix[j][k]; // Soma o elemento.
                }
            }
        }

        System.out.println("Soma principal: " + sumPrincipal); // Imprime a soma da diagonal principal.
        System.out.println("Soma secundária: " + sumSecundaria); // Imprime a soma da diagonal secundária.
    }
}
