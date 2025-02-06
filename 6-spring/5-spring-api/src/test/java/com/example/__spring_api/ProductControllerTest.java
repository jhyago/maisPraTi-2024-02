package com.example.__spring_api;

import com.example.__spring_api.model.Product;
import com.example.__spring_api.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testCreateAndGetProduct() {
        Product product = new Product("Produto Exemplo", "Descrição do Produto", new BigDecimal("99.99"));

        ResponseEntity<Product> postResponse = restTemplate
                .withBasicAuth("user", "password")
                .postForEntity("/api/products", product, Product.class);

        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        Product createdProduct = postResponse.getBody();
        assertThat(createdProduct).isNotNull();
        assertThat(createdProduct.getId()).isNotNull();

        ResponseEntity<Product> getResponse = restTemplate
                .withBasicAuth("user", "password")
                .getForEntity("/api/products/" + createdProduct.getId(), Product.class);

        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        Product retrievedProduct = getResponse.getBody();
        assertThat(retrievedProduct.getName()).isEqualTo("Produto Exemplo");
    }
}
