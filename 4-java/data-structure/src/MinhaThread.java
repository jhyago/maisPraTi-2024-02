public class MinhaThread extends Thread {
    private static int contador = 0; // Variável estática compartilhada entre todas as threads para contagem.

    public static void main(String[] args) {
        System.out.println("Thread principal (main) iniciada."); // Mensagem inicial indicando o início da execução da thread principal.

        // Criação da primeira thread com um bloco lambda para definir o comportamento.
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) { // Loop de 5 iterações para exibir mensagens.
                System.out.println(Thread.currentThread().getName() + " executando: " + i); // Exibe o nome da thread e o número da iteração.
                try {
                    Thread.sleep(500); // Pausa a execução da thread por 500ms.
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 interrompida"); // Mensagem caso a thread seja interrompida.
                }
            }
        });

        // Criação da segunda thread com comportamento semelhante à primeira, mas com um tempo de pausa diferente.
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) { // Loop de 5 iterações para exibir mensagens.
                System.out.println(Thread.currentThread().getName() + " executando: " + i); // Exibe o nome da thread e o número da iteração.
                try {
                    Thread.sleep(700); // Pausa a execução da thread por 700ms.
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 interrompida"); // Mensagem caso a thread seja interrompida.
                }
            }
        });

        thread1.start(); // Inicia a execução da primeira thread.
        thread2.start(); // Inicia a execução da segunda thread.

        // Loop na thread principal para exibir mensagens enquanto as outras threads estão executando.
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread principal (main) executando " + i); // Exibe uma mensagem com o número da iteração.
            try {
                Thread.sleep(300); // Pausa a execução da thread principal por 300ms.
            } catch (InterruptedException e) {
                System.out.println("Thread principal interrompida"); // Mensagem caso a thread principal seja interrompida.
            }
        }

        System.out.println("Thread principal (main) finalizada"); // Indica o término do trabalho da thread principal.

        // Criação da terceira thread para incrementar a variável `contador` 5000 vezes.
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                contador++; // Incrementa a variável compartilhada.
            }
        });

        // Criação da quarta thread com o mesmo comportamento da terceira.
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                contador++; // Incrementa a variável compartilhada.
            }
        });

        thread3.start(); // Inicia a execução da terceira thread.
        thread4.start(); // Inicia a execução da quarta thread.

        try {
            thread3.join(); // Aguarda a conclusão da terceira thread antes de continuar.
            thread4.join(); // Aguarda a conclusão da quarta thread antes de continuar.
        } catch (InterruptedException e) {
            e.printStackTrace(); // Exibe a pilha de exceções caso haja interrupção.
        }

        System.out.println("Valor final do contador: " + contador); // Exibe o valor final da variável `contador` após o término de todas as threads.
    }
}