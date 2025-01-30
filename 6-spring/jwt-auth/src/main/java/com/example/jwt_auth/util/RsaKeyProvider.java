package com.example.jwt_auth.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Component
public class RsaKeyProvider {
    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public RsaKeyProvider(PrivateKey privateKey, PublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    private PrivateKey loadPrivateKey() throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(new ClassPathResource("keys/private.pem").getURI()));
        String keyString = new String(keyBytes).replaceAll("-----\\ PRIVATE KEY ------", "");
        byte[] decoded = java.util.Base64.getDecoder().decode(keyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    private PublicKey loadPublickey() throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(new ClassPathResource("keys/public.pem").getURI()));
        String keyString = new String(keyBytes).replaceAll("-----\\ PRIVATE KEY ------", "");
        byte[] decoded = java.util.Base64.getDecoder().decode(keyString);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}
