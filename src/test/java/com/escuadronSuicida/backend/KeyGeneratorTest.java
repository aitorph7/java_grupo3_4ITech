package com.escuadronSuicida.backend;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class KeyGeneratorTest {

    @Test
    void generateSecureKey() {

        SecureRandom random = new SecureRandom();

        // 32 bytes equivale a 256 bits, tamaño suficiente para el algoritmo HMAC-SHA-256
        byte[] key = new byte[32];
        random.nextBytes(key);

        System.out.println(Arrays.toString(key));

        // Convertir a Base64 para mayor comodidad
        String base64Key = Base64.getEncoder().encodeToString(key);
        System.out.println(base64Key);
        // Ejemplo: FZD5maIaX04mYCwsgckoBh1NJp6T3t62h2MVyEtdo3w=
    }
}
