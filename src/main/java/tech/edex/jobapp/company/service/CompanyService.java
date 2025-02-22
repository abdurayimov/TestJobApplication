package tech.edex.jobapp.company.service;

import tech.edex.jobapp.company.model.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    void createCompany(Company job);

    Company getCompanyById(Long id);

    boolean deleteCompany(Long id);

    boolean updateCompany(Long id, Company updatedJob);
}
