package cz.xnevrela.ldg.repository;

import cz.xnevrela.ldg.domain.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRequestRepository extends JpaRepository<ContactRequest, Long> {
}
