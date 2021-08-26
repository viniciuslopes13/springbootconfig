package br.edu.ufersa.springbootconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Value("${app.message}")
	private String appMessage;
	
	@Value("${ENV_DB_URL:NENHUMA}")
	private String dbEnvironmentVaiable;
	
	@GetMapping("/")
	public String getAppMessage() {
		return appMessage;
	}
	
	@GetMapping("/envVariable")
	public String getDbEnvironmentVaiable() {
		return "A seguinte variável de ambiente foi passada: "+dbEnvironmentVaiable;
	}
	
}
