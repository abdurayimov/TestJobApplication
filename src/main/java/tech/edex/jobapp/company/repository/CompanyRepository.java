package tech.edex.jobapp.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.edex.jobapp.company.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
