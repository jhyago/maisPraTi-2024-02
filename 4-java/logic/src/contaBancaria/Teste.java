package contaBancaria;

public class Teste {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("João", "123.456.789-00");

        ContaBancaria conta1 = new ContaBancaria("001", usuario1);

        conta1.imprimirDetalhes();

        conta1.depositar(15000);
        conta1.consultarSaldo();
        conta1.imprimirDetalhes();
    }
}
