package org.ps.poc.refactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication(scanBasePackageClasses = App.class)
public class App {

	public static void main(String[] args) {
		healthy(new SpringApplicationBuilder(App.class).banner(new GVBanner()).run(args));
	}

	private static void healthy(ConfigurableApplicationContext context) {
		log.info("Running {} !", context.getId());
	}

}
