package br.edu.ufersa.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter // Através da biblioteca lombok pode-se gerar os getters e setters em tempo de compilação, não precisando codificar na mão
public class DBConfiguration {

	private String driverClassName; // padrao CamelCase já converte direto para o arquivo application.properties
	private String url;
	private String username;
	private String password;

	@Profile("dev")
	@Bean
	public String testDatabaseConnection() {
		System.out.println("DB connection for DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection to H2_TEST - Test instance";
	}

	@Profile("prod")
	@Bean
	public String produtionDatabaseConnection() {
		System.out.println("DB connection for Production - MySQL");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB connection to MySQL_PROD - Production instance";
	}

}
