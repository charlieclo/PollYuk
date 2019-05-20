package com.clodpa.pollyuk.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Charlie Leonardo Oroh
 */

@EnableAspectJAutoProxy
@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class PollyukCoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollyukCoreAppApplication.class, args);
	}

}
