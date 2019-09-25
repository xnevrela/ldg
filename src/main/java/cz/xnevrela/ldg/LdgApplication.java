package cz.xnevrela.ldg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class LdgApplication {

    public static void main(String[] args) {
        SpringApplication.run(LdgApplication.class, args);
    }

}
