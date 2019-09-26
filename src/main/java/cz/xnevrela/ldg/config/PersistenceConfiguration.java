package cz.xnevrela.ldg.config;

import cz.xnevrela.ldg.repository.ContactRequestRepository;
import cz.xnevrela.ldg.repository.RepositoryPackage;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = RepositoryPackage.class)
public class PersistenceConfiguration {
}
