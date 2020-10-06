package com.example.demo;

import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableJpaRepositories({ "com.sample.app.repositories"})
@EntityScan({ "com.example.demo.entity"})
@ComponentScan({ 
	"com.example.demo"
})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SampleAppApplication.class);
//	}
	
	@PostConstruct
	void started() {
		Locale.setDefault(new Locale("pt", "BR"));
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3"));
	}

}

@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
class DataJpaConfig {

	@Bean
	public AuditorAware<String> auditor() {
		return () -> {
			return Optional.of("demo");
		};
	}
}
