package cz.xnevrela.ldg.repository;

import cz.xnevrela.ldg.domain.ContactRequestType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRequestTypeRepository extends JpaRepository<ContactRequestType, Long> {
}
