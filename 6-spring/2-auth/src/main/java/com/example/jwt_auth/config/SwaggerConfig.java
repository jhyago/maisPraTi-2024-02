// Define o pacote onde esta classe está localizada.
package com.example.jwt_auth.config;

// Importa as classes do OpenAPI para documentação da API.
import io.swagger.v3.oas.models.OpenAPI; // Representa a configuração principal do OpenAPI.
import io.swagger.v3.oas.models.info.Info; // Contém informações gerais sobre a API.
import io.swagger.v3.oas.models.info.License; // Representa as informações de licença da API.
import org.springdoc.core.models.GroupedOpenApi; // Permite agrupar e definir quais endpoints serão documentados no Swagger.
import org.springframework.context.annotation.Bean; // Marca métodos como produtores de beans gerenciados pelo Spring.
import org.springframework.context.annotation.Configuration; // Indica que esta classe contém configurações do Spring.

// Marca esta classe como uma classe de configuração do Spring.
@Configuration
public class SwaggerConfig {

    // Define a configuração personalizada do OpenAPI para documentação da API.
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info() // Define as informações gerais da API.
                        .title("API de autenticação com JWT") // Título da documentação da API.
                        .version("1.0") // Define a versão da API.
                        .description("API para autenticação.") // Breve descrição da API.
                        .license(new License().name("Apache 2.0").url("https://springdoc.org"))); // Define a licença utilizada.
    }

    // Define um grupo de endpoints públicos para documentação no Swagger.
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public") // Nome do grupo definido para a API pública.
                .pathsToMatch("/auth/**", "/users/**") // Define quais endpoints serão incluídos na documentação.
                .build(); // Constrói e retorna a configuração da API documentada.
    }
}