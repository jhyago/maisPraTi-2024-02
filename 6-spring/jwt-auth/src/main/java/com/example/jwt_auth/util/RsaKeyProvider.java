// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.util;

// Importa as classes necessárias para manipulação de chaves RSA.
import org.springframework.core.io.ClassPathResource; // Permite carregar arquivos do classpath.
import org.springframework.stereotype.Component; // Marca a classe como um componente gerenciado pelo Spring.

import java.nio.file.Files; // Para leitura de arquivos.
import java.nio.file.Paths; // Manipulação de caminhos de arquivos.
import java.security.KeyFactory; // Utilizado para gerar chaves RSA a partir de especificações codificadas.
import java.security.PrivateKey; // Representa a chave privada usada para assinar JWTs.
import java.security.PublicKey; // Representa a chave pública usada para validar JWTs.
import java.security.spec.PKCS8EncodedKeySpec; // Define o formato da chave privada (PKCS#8).
import java.security.spec.X509EncodedKeySpec; // Define o formato da chave pública (X.509).
import java.util.Base64; // Utilizado para decodificação de Base64.

@Component // Indica que esta classe será gerenciada pelo Spring.
public class RsaKeyProvider {

    // Atributos para armazenar as chaves privada e pública.
    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    // Métodos públicos para acessar as chaves.
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    // Construtor que inicializa as chaves RSA.
    public RsaKeyProvider() throws Exception {
        this.privateKey = loadPrivateKey(); // Carrega a chave privada do arquivo.
        this.publicKey = loadPublicKey(); // Carrega a chave pública do arquivo.
    }

    // Método para carregar a chave privada do arquivo "private.pem".
    private PrivateKey loadPrivateKey() throws Exception {
        // Lê o conteúdo do arquivo da chave privada do classpath.
        byte[] keyBytes = Files.readAllBytes(Paths.get(new ClassPathResource("keys/private.pem").getURI()));

        // Converte para string e remove cabeçalhos e rodapés desnecessários.
        String keyString = new String(keyBytes)
                .replaceAll("-----BEGIN PRIVATE KEY-----", "")
                .replaceAll("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", ""); // Remove espaços e quebras de linha.

        // Decodifica a chave Base64.
        byte[] decoded = Base64.getDecoder().decode(keyString);

        // Cria uma especificação de chave privada no formato PKCS#8.
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);

        // Obtém uma instância de KeyFactory para RSA e gera a chave privada.
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    // Método para carregar a chave pública do arquivo "public.pem".
    private PublicKey loadPublicKey() throws Exception {
        // Lê o conteúdo do arquivo da chave pública do classpath.
        byte[] keyBytes = Files.readAllBytes(Paths.get(new ClassPathResource("keys/public.pem").getURI()));

        // Converte para string e remove cabeçalhos e rodapés desnecessários.
        String keyString = new String(keyBytes)
                .replaceAll("-----BEGIN PUBLIC KEY-----", "")
                .replaceAll("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", ""); // Remove espaços e quebras de linha.

        // Decodifica a chave Base64.
        byte[] decoded = Base64.getDecoder().decode(keyString);

        // Cria uma especificação de chave pública no formato X.509.
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);

        // Obtém uma instância de KeyFactory para RSA e gera a chave pública.
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}