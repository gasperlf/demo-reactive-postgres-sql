package net.ontopsolutions.demoreactivepostgressql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class DemoReactivePostgresSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoReactivePostgresSqlApplication.class, args);
	}

}
