package dev.sonnhapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class SwaggerConfiguration {
    @Value("${sonnh.openapi.dev-url}")
    private String devUrl;

    @Value("${sonnh.openapi.prod-url}")
    private String prodUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("sonnh296@gmail.com");
        contact.setName("Nguyen Hong Son");
        contact.setUrl("https://www.sonnh.org");

        License mitLicense = new License().name("MIT License").url("https://github.com/sonnh296/sonnhapi/blob/0bf3590a019928b286ff6a6665b393a498eae1b9/LICENSE");

        Info info = new Info()
                .title("sonnh blogs api")
                .version("1.0")
                .contact(contact)
                .description("This API exposes endpoints to manage tutorials.").termsOfService("https://www.sonnh.org")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}
